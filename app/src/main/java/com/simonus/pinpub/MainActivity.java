package com.simonus.pinpub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView firstNumTextView = findViewById(R.id.firstNumTextView);
        TextView secondNumTextView = findViewById(R.id.secondNumTextView);
        int randNum1 = ThreadLocalRandom.current().nextInt(10, 100 + 1);
        int randNum2 = ThreadLocalRandom.current().nextInt(10, 100 + 1);
        firstNumTextView.setText(randNum1 + "");
        secondNumTextView.setText(randNum2 + "");

        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView accuracyTextView = findViewById(R.id.accuracyTextView);
                EditText resultUserEditText = findViewById(R.id.resultUserEditText);
                TextView firstNumTextView = findViewById(R.id.firstNumTextView);
                TextView secondNumTextView = findViewById(R.id.secondNumTextView);

                int num1 = Integer.parseInt(firstNumTextView.getText().toString());
                int num2 = Integer.parseInt(secondNumTextView.getText().toString());

                int result = num1 + num2;

                int resultUser = Integer.parseInt(resultUserEditText.getText().toString());

                if (resultUser == result) {
                    accuracyTextView.setText("True");
                    firstNumTextView.setText(ThreadLocalRandom.current().nextInt(10, 100+ 1) + "");
                    secondNumTextView.setText(ThreadLocalRandom.current().nextInt(10, 100+ 1) + "");
                    resultUserEditText.setText("");
                } else {
                    accuracyTextView.setText("False");
                }
            }
        });

        Button secondActivityBtn = findViewById(R.id.secondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), secondActivity.class);
                startActivity(startIntent);
            }
        });



        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        mDrawerLayout = findViewById(R.id.drawer_layout);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        if (menuItem.getItemId() == R.id.nav_addition) {
                            Intent startIntent = new Intent(getApplicationContext(), AdditionActivity.class);
                            startActivity(startIntent);
                        } else if (menuItem.getItemId() == R.id.nav_substraction) {
                            Intent startIntent = new Intent(getApplicationContext(), SubstractionActivity.class);
                            startActivity(startIntent);
                        } else if (menuItem.getItemId() == R.id.nav_multiplication) {
                            Intent startIntent = new Intent(getApplicationContext(), MultiplicationActivity.class);
                            startActivity(startIntent);
                        } else if (menuItem.getItemId() == R.id.nav_division) {
                            Intent startIntent = new Intent(getApplicationContext(), DivisionActivity.class);
                            startActivity(startIntent);
                        }

                        return true;
                    }
                }
        );
    }
}
