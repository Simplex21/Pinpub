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
import android.widget.Toast;

public class AdditionActivity extends AppCompatActivity {

    public DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

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
    }
}
