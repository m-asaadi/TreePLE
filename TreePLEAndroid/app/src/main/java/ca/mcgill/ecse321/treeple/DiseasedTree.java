package ca.mcgill.ecse321.treeple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * This class allows the scientist to mark tree as diseased
 * Created by leaakkari on 2018-03-22.
 */


public class DiseasedTree extends AppCompatActivity {

    EditText lat, lng;
    TextView title, thanks, message, back;
    Button ok;
    String error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.diseased);

        lat = (EditText)findViewById(R.id.lat_dis);
        lng = (EditText) findViewById(R.id.lgt_d);

        title = (TextView)findViewById(R.id.title_diseased);
        thanks = (TextView)findViewById(R.id.thanks);

        back = (Button)findViewById(R.id.back_diseased);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                Intent i = new Intent(DiseasedTree.this, ScientistOptions.class);
                i.putExtra("userName",userName);
                i.putExtra("userType", userType);
                startActivity(i);

            }

        });



    }



//@PostMapping(value = { "/MarkAsDiseased/{latitude}/{longitude}/{userName}" })
    public void MarkDiseased(View v){

        Intent i = getIntent();
        String userName = i.getStringExtra("userName");

        lng = (EditText)findViewById(R.id.lgt_d);
        lat = (EditText)findViewById(R.id.lat_dis);

        message = (TextView)findViewById(R.id.error_d);

        HttpUtils.post("MarkAsDiseased/"  + lat.getText().toString() + "/"+ lng.getText().toString() +"/"+ userName ,  new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                refreshErrorMessage();
                lng.setText("");
                lat.setText("");

                thanks.setVisibility(View.VISIBLE);

                //System.out.println("Success");

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }

                error = "Error!";
                //System.out.println("Fail");

                refreshErrorMessage();

            }
        });


    }


    //@PostMapping(value = { "/MarktoBeCutDown/{latitude}/{longitude}/{userName}" })
    public void MarkCut(View v){

        Intent i = getIntent();
        String userName = i.getStringExtra("userName");

        lng = (EditText)findViewById(R.id.lgt_d);
        lat = (EditText)findViewById(R.id.lat_dis);

        message = (TextView)findViewById(R.id.error_d);

        HttpUtils.post("MarktoBeCutDown/"  + lat.getText().toString() + "/"+ lng.getText().toString() +"/"+ userName ,  new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                refreshErrorMessage();
                lng.setText("");
                lat.setText("");


                //going to Bob's page
                Intent i = getIntent();
                String userName = i.getStringExtra("userName");
                String userType = i.getStringExtra("userType");

                Intent intent = new Intent(DiseasedTree.this, AfterCut.class);
                intent.putExtra("userName",userName);
                intent.putExtra("userType",userType);
                startActivity(intent);

                System.out.println("Username "  + userName);
                System.out.println("UserType " + userType);

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }
                //System.out.println("Fail");
                error = "Error!";
                refreshErrorMessage();

            }
        });


    }



    /**
     * refresh error message, displays error on screen
     */
    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = (TextView) findViewById(R.id.error_d);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }

    }


}
