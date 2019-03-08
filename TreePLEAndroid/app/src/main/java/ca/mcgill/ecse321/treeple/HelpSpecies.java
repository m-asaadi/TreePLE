package ca.mcgill.ecse321.treeple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * This class helps the user identify a tree species
 * Created by leaakkari on 2018-04-06.
 */

public class HelpSpecies extends AppCompatActivity {

    Button back;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_species);

        //Go to back to help page
        back = (Button) findViewById(R.id.b_help3);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = getIntent();
                String userName = intent.getStringExtra("userName");
                String userType = intent.getStringExtra("userType");

                Intent i = new Intent(HelpSpecies.this, HelpPlant.class);
                i.putExtra("userName",userName);
                i.putExtra("userType",userType);
                startActivity(i);
            }

        });


    }

}
