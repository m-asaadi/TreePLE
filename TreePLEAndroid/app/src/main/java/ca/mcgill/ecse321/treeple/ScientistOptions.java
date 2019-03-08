package ca.mcgill.ecse321.treeple;

import android.content.Context;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * This class implements the scientist options page
 * Created by leaakkari on 2018-03-19.
 */



public class ScientistOptions extends AppCompatActivity {

    Button plant, cut, maps, diseased, toBeCut, back;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_scientist);

        //plant tree button
        plant= (Button) findViewById(R.id.sc_plant);
        plant.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                Intent intent = new Intent(ScientistOptions.this, PlantTree.class);
                intent.putExtra("userName",userName);
                intent.putExtra("userType", userType);
                startActivity(intent);

            }

        });


        // View Maps Button
        maps = (Button) findViewById(R.id.maps_scientist);

        maps.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                Intent i = new Intent(ScientistOptions.this, MapsActivity.class);
                i.putExtra("userName",userName);
                i.putExtra("userType", userType);
                startActivity(i);

            }

        });

        //cut Tree Button
        cut  = (Button) findViewById(R.id.sc_cut);

        cut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");


                Intent i = new Intent(ScientistOptions.this, CutTree.class);
                i.putExtra("userName",userName);
                i.putExtra("userType", userType);
                startActivity(i);
            }

        });

        diseased = (Button) findViewById(R.id.sc_diseased);
        diseased.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                Intent i = new Intent(ScientistOptions.this, DiseasedTree.class);
                i.putExtra("userName",userName);
                i.putExtra("userType", userType);
                startActivity(i);
            }

        });

        toBeCut = (Button) findViewById(R.id.sc_mark_cut);
        toBeCut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");


                Intent i = new Intent(ScientistOptions.this, DiseasedTree.class);
                i.putExtra("userName",userName);
                i.putExtra("userType", userType);
                startActivity(i);
            }

        });

        back  = (Button) findViewById(R.id.back_scientist);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //setContentView(R.layout.cut);
                Intent i = new Intent(ScientistOptions.this, MainActivity.class);
                startActivity(i);
            }

        });

    }











}
