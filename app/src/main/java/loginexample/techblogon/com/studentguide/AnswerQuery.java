package loginexample.techblogon.com.studentguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AnswerQuery extends Activity {

    final RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
    String queryData = "No Query to display";
    TextView querListTextView;
    EditText queryId, queryAnswer;
    Button postAnswer;
    private int serverSuccess;
    private String serverMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answerqueries);
        querListTextView = (TextView) findViewById(R.id.query_list);
        postAnswer = (Button) findViewById(R.id.post);
        queryId = (EditText) findViewById(R.id.query_id);
        queryAnswer = (EditText) findViewById(R.id.query_answer);
        final CustomRequest request = new CustomRequest(Request.Method.POST, "http://10.12.82.68:80/guide/fetchquery.php", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(AnswerQuery.this, response.toString(), Toast.LENGTH_LONG).show();
                jsonParser(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AnswerQuery.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(request);

        postAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postAnswerToDatabase();
            }
        });
    }

    private void postAnswerToDatabase() {
        Map<String, String> formData = new HashMap<>();
        formData.put("query_id", queryId.getText().toString());
        formData.put("answer", queryAnswer.getText().toString());
        final CustomRequest request = new CustomRequest(Request.Method.POST, "http://10.12.82.68:80/guide/answerquery.php", formData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(AnswerQuery.this, response.toString(), Toast.LENGTH_LONG).show();
                postAnswerJsonParser(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AnswerQuery.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(request);
    }

    private void postAnswerJsonParser(JSONObject response) {
        try {
            serverSuccess = response.getInt("success");
            if (serverSuccess == 1) {
                Toast.makeText(AnswerQuery.this, "Answer successfully posted", Toast.LENGTH_LONG).show();

            } else {
                serverMessage = response.getString("message");
                Toast.makeText(AnswerQuery.this, serverMessage, Toast.LENGTH_LONG).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void jsonParser(JSONObject response) {
        try {
            serverSuccess = response.getInt("success");
            if (serverSuccess == 1) {
                JSONArray data = response.getJSONArray("data");
                queryData = "";
                for (int i = 0; i < data.length(); i++) {
                    JSONObject query = data.getJSONObject(i);
                    queryData = queryData + "ID : " + query.getString("id") + "\n";
                    queryData = queryData + "Query :\n" + query.getString("question");
                    queryData += "\n\n";
                }

            } else {
                serverMessage = response.getString("message");
            }
            finalDecision();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void finalDecision() {
        if (serverSuccess == 1) {
            querListTextView.setText(queryData);
        } else {
            querListTextView.setText(serverMessage);
        }
    }
}
