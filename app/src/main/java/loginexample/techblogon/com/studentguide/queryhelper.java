package loginexample.techblogon.com.studentguide;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class queryhelper
{
		static final String DATABASE_NAME = "query.db";
		static final int DATABASE_VERSION = 1;
		public static final int NAME_COLUMN = 1;
		// TODO: Create public field for each column in your table.
		// SQL Statement to create a new database.
		static final String DATABASE_CREATE = "create table "+"QUERY"+
		                             "( " +"ID"+" integer primary key autoincrement,"+ " POSTQUERY  text); ";
		// Variable to hold the database instance
		public  SQLiteDatabase db;
		// Context of the application using the database.
		private final Context context;
		// Database open/upgrade helper
		private DataBaseHelper dbHelper;
		public  queryhelper(Context _context) 
		{
			context = _context;
			dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		public  queryhelper open() throws SQLException 
		{
			db = dbHelper.getWritableDatabase();
			return this;
		}
		public void close() 
		{
			db.close();
		}

		public  SQLiteDatabase getDatabaseInstance()
		{
			return db;
		}

		public void insertEntry(String postquery)
		{
	       ContentValues newValues = new ContentValues();
			// Assign values for each row.
			newValues.put("POSTQUERY",postquery);
			
			
			// Insert the row into your table
			db.insert("QUERY", null, newValues);
			///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
		}
		
		
		
		
}

