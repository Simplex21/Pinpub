package com.simonus.pinpub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

public class SubtractionActivity extends AppCompatActivity {

    public DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);

        // Den Support für die Toolbar einrichten
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Toolbar toggler einrichten, damit er den Drawer öffnet
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // TODO: 15.02.19 Zurückbutton für das Schließen vom Drawer (im Drawermenü)

        // Das Menü des Drawers interaktiv machen, sodass auf andere Aktivitäten zugeriffen werden kann
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        mDrawerLayout = findViewById(R.id.drawer_layout);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        if (menuItem.getItemId() == R.id.nav_addition) {
                            Context context = getApplicationContext();
                            CharSequence text = getString(R.string.already_on_activity);
                            int duration = Toast.LENGTH_SHORT;
                            Toast.makeText(context, text, duration).show();
                        } else if (menuItem.getItemId() == R.id.nav_subtraction) {
                            Intent startIntent = new Intent(getApplicationContext(), SubtractionActivity.class);
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

        // Die Zahlen TextViews mit zufälligen Zahlen belegen
        TextView sub_zahl1TextView = findViewById(R.id.sub_zahl1TextView);
        TextView sub_zahl2TextView = findViewById(R.id.sub_zahl2TextView);
        int randNum1 = 0;
        int randNum2 = 0;
        int num1 = 0;
        int num2 = 0;

        while (!isPositive(num1, num2)) {
            randNum1 = randInt(10, 100);
            randNum2 = randInt(10, 100);
            sub_zahl1TextView.setText(String.valueOf(randNum1));
            sub_zahl2TextView.setText(String.valueOf(randNum2));
            num1 = Integer.parseInt(sub_zahl1TextView.getText().toString());
            num2 = Integer.parseInt(sub_zahl2TextView.getText().toString());
        }
        // Button findet heraus ob die Eingabe richtig ist und macht dementsprechend weiter
        final Button sub_bestBtn = findViewById(R.id.sub_bestBtn);
        sub_bestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sub_zahl1TextView = findViewById(R.id.sub_zahl1TextView);
                TextView sub_zahl2TextView = findViewById(R.id.sub_zahl2TextView);
                TextView sub_indicatorTextView = findViewById(R.id.sub_indicatorTextView);
                EditText sub_userEntryEditText = findViewById(R.id.sub_userEntryEditText);
                int newNum1 = Integer.parseInt(sub_zahl1TextView.getText().toString());
                int newNum2 = Integer.parseInt(sub_zahl2TextView.getText().toString());
                int result = newNum1 + newNum2;
                int userEntry = Integer.parseInt(sub_userEntryEditText.getText().toString());
            }
        });
    }
    // Funktion zur Erstellung von zufälligen Zahlen
    public int randInt(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound + 1);
    }

    public boolean isPositive(int num1, int num2) {
        return(num1 > num2);
    }
}
