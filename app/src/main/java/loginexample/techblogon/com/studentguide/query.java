package loginexample.techblogon.com.studentguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class query extends Activity


{
    EditText editquery;
    Button btnpost;
    String inputQuery;
    private int serverSuccess;
    private String serverMessage;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.queryy);
        editquery = (EditText) findViewById(R.id.userInputQuery);
        btnpost = (Button) findViewById(R.id.post);
        btnpost.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputQuery = editquery.getText().toString();
                pushToDatabase();
            }
        });
    }

    private void pushToDatabase() {
        final RequestQueue requestQueue = VolleySingleton.getInstance().getRequestQueue();
        Map<String, String> formData = new HashMap<>();
        formData.put("query", inputQuery);
        final CustomRequest request = new CustomRequest(Request.Method.POST, "http://10.12.82.68:80/guide/postquery.php", formData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(query.this, response.toString(), Toast.LENGTH_LONG).show();
                jsonParser(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(query.this, error.toString(), Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(request);
    }


    private void jsonParser(JSONObject response) {
        try {
            serverSuccess = response.getInt("success");
            serverMessage = response.getString("message");
            if (serverSuccess == 1) {
                Toast.makeText(query.this, "Query successfully posted", Toast.LENGTH_LONG).show();
            }
            finalDecision();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void finalDecision() {
        if (serverSuccess == 0) {
            Toast.makeText(query.this, serverMessage, Toast.LENGTH_LONG).show();
        }
    }
}

