package ca.mcgill.ecse321.treeple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * This class implements the helper guide.
 * Created by leaakkari on 2018-04-06.
 */

public class HelpPlant extends AppCompatActivity{

    Button help_diameter, help_height, help_species,back;


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_plant);



        //Go to help height page
        help_height = (Button) findViewById(R.id.help_height);

        help_height.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = getIntent();
                String userName = intent.getStringExtra("userName");
                String userType = intent.getStringExtra("userType");

                Intent i = new Intent(HelpPlant.this, HelpHeight.class);
                i.putExtra("userName",userName);
                i.putExtra("userType",userType);
                startActivity(i);

            }

        });

        //Go to help diameter page
        help_diameter = (Button) findViewById(R.id.help_diameter);

        help_diameter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = getIntent();
                String userName = intent.getStringExtra("userName");
                String userType = intent.getStringExtra("userType");

                Intent i = new Intent(HelpPlant.this, HelpDiameter.class);
                i.putExtra("userName",userName);
                i.putExtra("userType",userType);
                startActivity(i);
            }

        });


        //Go to help species page
        help_species = (Button) findViewById(R.id.help_species);

        help_species.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = getIntent();
                String userName = intent.getStringExtra("userName");
                String userType = intent.getStringExtra("userType");

                Intent i = new Intent(HelpPlant.this, HelpSpecies.class);
                i.putExtra("userName",userName);
                i.putExtra("userType",userType);
                startActivity(i);
            }

        });


        //Go back to plant tree page
        back = (Button) findViewById(R.id.b_plant);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = getIntent();
                String userName = intent.getStringExtra("userName");
                String userType = intent.getStringExtra("userType");

                Intent i = new Intent(HelpPlant.this, PlantTree.class);
                i.putExtra("userName",userName);
                i.putExtra("userType",userType);
                startActivity(i);
            }

        });







    }
}
