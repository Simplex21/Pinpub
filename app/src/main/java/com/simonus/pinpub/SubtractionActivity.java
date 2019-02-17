package com.simonus.pinpub;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import javax.security.auth.Destroyable;

public class SubtractionActivity extends AppCompatActivity {

    public int currentImageId = R.drawable.bali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);

        Button simpleBtn = findViewById(R.id.simpleBtn);
        simpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView simpleImg = findViewById(R.id.simpleImage);

                if (currentImageId == R.drawable.bali) {
                    currentImageId = R.drawable.lighthouse;
                } else {
                    currentImageId = R.drawable.bali;
                }

                simpleImg.setImageResource(currentImageId);
            }
        });

        simpleBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ImageView simpleImg = findViewById(R.id.simpleImage);
                simpleImg.setImageResource(R.drawable.killer);
                return true;
            }
        });
    }
}
