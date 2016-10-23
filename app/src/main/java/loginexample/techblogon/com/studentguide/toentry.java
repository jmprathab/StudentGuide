package loginexample.techblogon.com.studentguide;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class toentry extends Activity 
{
	Button btnnSignIn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.login);
	     btnnSignIn=(Button)findViewById(R.id.buttonSignIn);
	     btnnSignIn.setOnClickListener(new View.OnClickListener() {
	 		public void onClick(View v) {
	 			// TODO Auto-generated method stub
	 			/// Create Intent for SignUpActivity  and Start The Activity
	 			Intent intentSignIn=new Intent(getApplicationContext(),inentry.class);
	 			startActivity(intentSignIn);
	 			}
	 		});
	 	}
}