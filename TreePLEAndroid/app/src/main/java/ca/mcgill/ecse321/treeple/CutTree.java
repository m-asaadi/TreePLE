package ca.mcgill.ecse321.treeple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


/**
 * This class implements a method that lets a user cut down a tree
 * Created by leaakkari on 2018-03-22.
 */

public class CutTree extends AppCompatActivity {

    Button  ok , back, bob;
    private String error = null;

    TextView message, invalid;

    EditText lgt, lat;



    /**
     * On Create
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cut);

        //latitude/longitude user input
       lgt = (EditText)findViewById(R.id.lgt_cut);
       lat = (EditText)findViewById(R.id.ltd_cut);


        //error message
        invalid = (TextView)findViewById((R.id.invalid_cut));

        //click on ok to cut a tree
        ok = (Button) findViewById(R.id.ok_cut);

        //go back to options page
        back = (Button)findViewById(R.id.back_c);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                if(userType.equals("User")){

                    Intent i = new Intent(CutTree.this, Options.class);
                    i.putExtra("userName",userName);
                    i.putExtra("userType", userType);
                    startActivity(i);

                }else if(userType.equals("Scientist")){

                    Intent i = new Intent(CutTree.this, ScientistOptions.class);
                    i.putExtra("userName",userName);
                    i.putExtra("userType", userType);
                    startActivity(i);

                }



            }

        });

        //click on bob to find a surprise
        bob = (Button)findViewById(R.id.bob_think);

        bob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(CutTree.this, "Please make sure you really need to cut the tree!", Toast.LENGTH_SHORT).show();


            }

        });






    }


    /**
     * refresh error message, displays error on screen
     */
    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = (TextView) findViewById(R.id.success);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }

    }


    /**
     * Method that lets the user cut down a tree
     * @param v
     */
   public void cut(View v){

        Intent i = getIntent();
        String userName = i.getStringExtra("userName");
       String userType = i.getStringExtra("userType");

        lgt = (EditText)findViewById(R.id.lgt_cut);
        lat = (EditText)findViewById(R.id.ltd_cut);

        message = (TextView)findViewById(R.id.success);

        HttpUtils.post("cutDownTree/"  + lat.getText().toString() + "/"+ lgt.getText().toString() +"/"+ userName ,  new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                refreshErrorMessage();
               lgt.setText("");
               lat.setText("");

                //going to Bob's page
                Intent i = getIntent();
                String userName = i.getStringExtra("userName");
                String userType = i.getStringExtra("userType");

                Intent intent = new Intent(CutTree.this, AfterCut.class);
                intent.putExtra("userName",userName);
                intent.putExtra("userType",userType);
                startActivity(intent);

                System.out.println("Username "  + userName);
                System.out.println("UserType " + userType);

                //System.out.println("Success");

            }
           @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                try {
                    error += errorResponse.get("message").toString();
                } catch (JSONException e) {
                    error += e.getMessage();
                }

                error = "Error! Please make sure your inputs are correct, or that the tree you are trying to cut down exists";
                //System.out.println("Fail");

                refreshErrorMessage();

            }
        });


    }








}
