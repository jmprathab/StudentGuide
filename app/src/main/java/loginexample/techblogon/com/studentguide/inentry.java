package loginexample.techblogon.com.studentguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inentry extends Activity {
    Button btnCoursematerial, Facultylocation, Queries, answerQuery;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        btnCoursematerial = (Button) findViewById(R.id.btntextbooks);
        Facultylocation = (Button) findViewById(R.id.facultyloc);
        Queries = (Button) findViewById(R.id.Querysection);
        answerQuery = (Button) findViewById(R.id.answer_queries);
        answerQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(inentry.this, AnswerQuery.class));
            }
        });
        btnCoursematerial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  and Start The Activity
                Intent intentText = new Intent(getApplicationContext(), textbook.class);
                startActivity(intentText);
            }
        });
        Queries.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  and Start The Activity
                Intent intentt = new Intent(getApplicationContext(), query.class);
                startActivity(intentt);
            }
        });
    }

}


