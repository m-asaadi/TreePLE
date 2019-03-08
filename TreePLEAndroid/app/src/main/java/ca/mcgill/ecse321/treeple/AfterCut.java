package ca.mcgill.ecse321.treeple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * This class pops up after a user cuts down a tree
 * Created by leaakkari on 2018-04-02.
 */

public class AfterCut extends AppCompatActivity {

    Button back;

    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.aftercut);



        //Go to Options
        back = (Button) findViewById(R.id.back_to_cut);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {



                Intent i = getIntent();
                String userName = i.getStringExtra("userName");
                String userType = i.getStringExtra("userType");

                Intent intent = new Intent(AfterCut.this, CutTree.class);
                intent.putExtra("userName",userName);
                intent.putExtra("userType",userType);
                startActivity(intent);

                System.out.println("Username "  + userName);
                System.out.println("UserType " + userType);
            }

        });




    }
}
