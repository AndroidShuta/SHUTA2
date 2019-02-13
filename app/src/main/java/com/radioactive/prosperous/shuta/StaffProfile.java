package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.radioactive.prosperous.shuta.StaffCourses.STAFF_ID;

public class StaffProfile extends AppCompatActivity {
    Button load;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private static int RESULT_LOAD_IMAGE = 1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_profile);
        //button


        // NAVIGATION BAR
        dl = findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.course) {
                    Intent intent = new Intent(getApplicationContext(),StaffCourses.class);
                    intent.putExtra("staff_ID",STAFF_ID);
                    startActivity(intent);
                } else if (id == R.id.OptionalCourse) {
                    Toast.makeText(StaffProfile.this, "Registered", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.About) {
                    Toast.makeText(StaffProfile.this, "about", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (abdt.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}