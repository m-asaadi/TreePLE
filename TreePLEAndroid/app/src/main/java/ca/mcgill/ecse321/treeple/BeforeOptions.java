package ca.mcgill.ecse321.treeple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * This class shows up when the user is a local user, Bob welcomes the user to TreePLE
 * Created by leaakkari on 2018-04-01.
 */


public class BeforeOptions extends AppCompatActivity{

    Button b, b1;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.before_options);


        //Go to Options
        b = (Button) findViewById(R.id.next_options);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                //setContentView(R.layout.options);

                Intent i2 = getIntent();
                String userName = i2.getStringExtra("userName");
                String userType = i2.getStringExtra("userType");

                Intent intent = new Intent(BeforeOptions.this, Options.class);
                intent.putExtra("userName",userName);
                intent.putExtra("userType", userType);
                startActivity(intent);
            }

        });

        //Go to before options Options
        b1 = (Button) findViewById(R.id.back_main);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                //setContentView(R.layout.options);

                Intent i = new Intent(BeforeOptions.this, MainActivity.class);
                startActivity(i);
            }

        });

    }
}
