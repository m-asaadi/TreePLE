package ca.mcgill.ecse321.treeple;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the login page of the app. It allows the user to put their name and select if they are a scientist or a local user
 * Created by leaakkari on 07/03/18.
 */


import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import cz.msebera.android.httpclient.entity.mime.Header;
import ca.mcgill.ecse321.TreePLE.dto.MunicipalityDto;
import cz.msebera.android.httpclient.Header;



/**
 * This class implements the first login page. user has to input his username and pick his role.
 */


public class MainActivity  extends AppCompatActivity {

        EditText username;
        TextView welcome, entername, entertype,errorMsg;


        private String error;

        Button ok_b, back_first, bob;


        private List<String> userType = new ArrayList<>();
        private ArrayAdapter<String> userAdapter;


    /**
     *
     * @param savedInstanceState
     */
    @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.welcomepage);


            welcome = (TextView) findViewById(R.id.welcome);

            //username input
            username = (EditText) findViewById(R.id.username_entry);

            //Click on Bob to get a surprise message
            bob = (Button) findViewById(R.id.drums);
            bob.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Toast.makeText(MainActivity.this, "Hi there! I'm Bob!", Toast.LENGTH_SHORT).show();



                }

            });



            entername = (TextView) findViewById(R.id.textView2);


            entertype = (TextView) findViewById(R.id.textView4);
            errorMsg = (TextView) findViewById(R.id.error);

            userType.add("Please Select");
            userType.add("Local");
            userType.add("Expert");
            final Spinner userSpinner = (Spinner) findViewById(R.id.userType);

            userAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, userType);
            userAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            userSpinner.setAdapter(userAdapter);


            //Go to Options
            ok_b = (Button) findViewById(R.id.ok_1);



             ok_b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {

                        //if username is empty, throw an error
                        if(username.getText().toString().matches("")){
                           error = "You did not enter a Username!";
                            errorMsg.setText(error);
                            errorMsg.setVisibility(View.VISIBLE);
                        }

                        else if(userSpinner.getSelectedItem().toString().equals("Local")){      //if local user, go to local user options page

                           Intent i2 = new Intent(MainActivity.this, PlantTree.class);
                            i2.putExtra("userType", "User");
                            System.out.println("user" + i2.getStringExtra("userType"));

                            Intent i = new Intent(MainActivity.this, BeforeOptions.class);
                            i.putExtra("userName", username.getText().toString());
                            i.putExtra("userType", "User");
                            System.out.println("userType " + i.getStringExtra("userType"));



                            startActivity(i);
                    }
                        //If scientist not with specific ID, cannot procede
                        else if(userSpinner.getSelectedItem().toString().equals("Expert") && (username.getText().toString().matches("Daniel")  ||  username.getText().toString().matches("John") )) {


                            Intent i = new Intent(MainActivity.this, ScientistOptions.class);
                            i.putExtra("userName", username.getText().toString());
                            i.putExtra("userType", "Scientist");
                            System.out.println("userType " + i.getStringExtra("userType"));
                            startActivity(i);



                        }else{ //if(userSpinner.getSelectedItem().toString().equals("Please Select") ){
                            error = "Invalid Selection!";

                            errorMsg.setText(error);
                            errorMsg.setVisibility(View.VISIBLE);


                        }



                    }

                    });


            //Go back to first page
            back_first = (Button) findViewById(R.id.b_first);

            back_first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {


                    Intent i = new Intent(MainActivity.this, FirstPage.class);

                    startActivity(i);
                }

            });



        }


}





