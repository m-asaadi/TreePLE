package ca.mcgill.ecse321.treeple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * This class pops up after a user plants a tree
 * Created by leaakkari on 2018-04-02.
 */


public class AfterPlant extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.afterplant);



        //Go to Options
        back = (Button) findViewById(R.id.back_to_plant);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                //keeping the data

                Intent intent = getIntent();
                String userName = intent.getStringExtra("userName");
                String userType = intent.getStringExtra("userType");


                Intent i = new Intent(AfterPlant.this, PlantTree.class);
                i.putExtra("userName",userName);
                i.putExtra("userType",userType);

                startActivity(i);
                System.out.println("Username "  + userName);
                System.out.println("UserType " + userType);
            }

        });




    }
}
