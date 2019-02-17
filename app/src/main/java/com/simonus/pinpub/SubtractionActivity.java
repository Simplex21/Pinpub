package com.simonus.pinpub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SubtractionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);

        Button simpleBtn = findViewById(R.id.simpleBtn);
        simpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView simpleImg = findViewById(R.id.simpleImage);
                boolean imgSwitch = false;

                //if (simpleImg.getDrawable() == R.drawable.bali) {
                //    // do something
                //}
            }
        });
    }
}
