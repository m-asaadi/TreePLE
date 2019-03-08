package ca.mcgill.ecse321.treeple;

import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * This class implements the Local User Options page
 * Created by leaakkari on 2018-03-19.
 */



public class Options extends AppCompatActivity {

    Button plant, cut, maps, back_b, bob;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);

        //plant tree button
        plant= (Button) findViewById(R.id.planttree_b);
        plant.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                Intent intent = new Intent(Options.this, PlantTree.class);
                intent.putExtra("userName",userName);
                intent.putExtra("userType",userType);
                startActivity(intent);


            }

        });

        //click on Bob to view secret message
        bob = (Button) findViewById(R.id.button5);

        bob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(Options.this, "Is it hot in here? Or is it just you?!", Toast.LENGTH_SHORT).show();

            }

        });

        maps = (Button) findViewById(R.id.viewmaps_b);

        maps.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                Intent i = new Intent(Options.this, MapsActivity.class);
                i.putExtra("userName",userName);
                i.putExtra("userType",userType);
                startActivity(i);

            }

        });

        //cut Tree Button
        cut  = (Button) findViewById(R.id.cuttree_b);

        cut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                //setContentView(R.layout.cut);
                Intent i = new Intent(Options.this, CutTree.class);
                i.putExtra("userName",userName);
                i.putExtra("userType",userType);
                startActivity(i);
            }

        });


        back_b  = (Button) findViewById(R.id.back_ic);

        back_b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //setContentView(R.layout.cut);
                Intent i = new Intent(Options.this, MainActivity.class);
                startActivity(i);
            }

        });


    }











}
