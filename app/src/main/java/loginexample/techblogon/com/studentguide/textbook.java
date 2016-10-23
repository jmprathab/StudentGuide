package loginexample.techblogon.com.studentguide;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class textbook extends Activity
{
	Button btn310,btn320,btn369,btn331,btn272;

public void onCreate(Bundle savedInstanceState)
{
	super.onCreate(savedInstanceState);
    setContentView(R.layout.textbooks);
    btn310=(Button)findViewById(R.id.button1);
    btn320=(Button)findViewById(R.id.button2);
    btn369=(Button)findViewById(R.id.button3);
    btn272=(Button)findViewById(R.id.button5);
    btn331=(Button)findViewById(R.id.button4);
    

    btn310.setOnClickListener(new View.OnClickListener() {
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			
 			/// Create Intent for SignUpActivity  and Start The Activity
 			Intent intentSignIn=new Intent(getApplicationContext(),cse310.class);
 			startActivity(intentSignIn);
 			}
 		});
 	
btn320.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			/// Create Intent for SignUpActivity  and Start The Activity
			Intent intentSignIn=new Intent(getApplicationContext(),cse320.class);
			startActivity(intentSignIn);
			}
		});
	
btn369.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			/// Create Intent for SignUpActivity  and Start The Activity
			Intent intentSignIn=new Intent(getApplicationContext(),cse369.class);
			startActivity(intentSignIn);
			}
		});
	
	btn331.setOnClickListener(new View.OnClickListener() {
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			
 			/// Create Intent for SignUpActivity  and Start The Activity
 			Intent intentSignIn=new Intent(getApplicationContext(),cse331.class);
 			startActivity(intentSignIn);
 			}
 		});
 	

btn272.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			/// Create Intent for SignUpActivity  and Start The Activity
			Intent intentSignIn=new Intent(getApplicationContext(),chy272.class);
			startActivity(intentSignIn);
			}
		});
	}}





	


