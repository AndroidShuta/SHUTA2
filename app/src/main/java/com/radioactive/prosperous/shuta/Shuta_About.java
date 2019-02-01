package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
public class Shuta_About extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuta__about);

        dl = findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);



        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.course){
                    Intent intent = new Intent(getApplicationContext(),student_Courses.class);
                    startActivity(intent);}
                else if (id == R.id.OptionalCourse) {
                    Intent intent = new Intent(getApplicationContext(),student_OptionalCourse.class);
                    startActivity(intent);}
                else if (id == R.id.result) {
                    Intent intent = new Intent(getApplicationContext(),student_Results.class);
                    startActivity(intent);}
                else if (id == R.id.timetable) {
                    Intent intent = new Intent(getApplicationContext(),student_Timetable.class);
                    startActivity(intent);}
                else if (id == R.id.About) {
                    Intent intent = new Intent(getApplicationContext(),Shuta_About.class);
                    startActivity(intent);}

                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (abdt.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

