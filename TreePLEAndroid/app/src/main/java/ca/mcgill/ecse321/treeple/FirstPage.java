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

/**
 * First page of the app
 * Created by leaakkari on 2018-04-01.
 */

public class FirstPage  extends AppCompatActivity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);



        //Go to Options
        next = (Button) findViewById(R.id.next_b);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                //setContentView(R.layout.options);

                Intent i = new Intent(FirstPage.this, MainActivity.class);
                startActivity(i);
            }

        });
    }




}
