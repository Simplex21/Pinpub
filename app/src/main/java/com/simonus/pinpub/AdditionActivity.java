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
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

public class AdditionActivity extends AppCompatActivity {

    public DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        // Den Support für die Toolbar einrichten
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Toolbar toggler einrichten, damit er den Drawer öffnet
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

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
        TextView add_zahl1TextView = findViewById(R.id.add_zahl1TextView);
        TextView add_zahl2TextView = findViewById(R.id.add_zahl2TextView);
        add_zahl1TextView.setText(String.valueOf(randInt(10, 100)));
        add_zahl2TextView.setText(String.valueOf(randInt(10, 100)));

        // Button findet heraus ob die Eingabe richtig ist und macht dementsprechend weiter
        Button add_bestBtn = findViewById(R.id.add_bestBtn);
        add_bestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Alle Views ansprechen und ihren Wert auslesen, sowie ersetzen oder festlegen
                TextView add_zahl1TextView = findViewById(R.id.add_zahl1TextView);
                TextView add_zahl2TextView = findViewById(R.id.add_zahl2TextView);
                TextView add_userEntryEditText = findViewById(R.id.add_userEntryEditText);
                TextView add_indicatorTextView = findViewById(R.id.add_indicatorTextView);

                int num1 = Integer.parseInt(add_zahl1TextView.getText().toString());
                int num2 = Integer.parseInt(add_zahl2TextView.getText().toString());

                int userInput = 0;
                boolean inputMistake = false;

                // Herausfinden, ob der Benutzereingabe ein leerer String ist
                if (add_userEntryEditText.getText().toString().equals("")) {
                    Context context = getApplicationContext();
                    CharSequence emptyInputText = getString(R.string.empty_input);
                    int toastDuration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, emptyInputText, toastDuration).show();
                    inputMistake = true;
                }else if (1 + 1 == 3) {
                    // TODO: 15.02.19 Zu große Zahlen, dass App abstürzt
                } else {
                    userInput = Integer.parseInt(add_userEntryEditText.getText().toString());
                }

                // Das Ergebnis kalkulieren
                int result = num1 + num2;

                // Die Benutzereingabe mit dem kalkulierten Ergebnis vergleichen und je nach dem verschiedene Schlüsse ziehen
                if (userInput == result) {
                    add_zahl1TextView.setText(String.valueOf(randInt(10, 100)));
                    add_zahl2TextView.setText(String.valueOf(randInt(10, 100)));
                    add_indicatorTextView.setText(R.string.right_expression);
                    add_userEntryEditText.setText("");

                    // Toast anzeigen, wenn Ergebnis richtig war
                    Context context = getApplicationContext();
                    CharSequence rewardText = getString(R.string.reward_text);
                    int toastDuration = Toast.LENGTH_SHORT;
                    Toast.makeText(context, rewardText, toastDuration).show();
                } else if (inputMistake) {
                    add_indicatorTextView.setText(R.string.sth_wrong);
                } else {
                    add_indicatorTextView.setText(R.string.wrong_expression);
                }
            }
        });
    }

    public int randInt(int origin, int bound) {
        return ThreadLocalRandom.current().nextInt(origin, bound + 1);
    }
}
