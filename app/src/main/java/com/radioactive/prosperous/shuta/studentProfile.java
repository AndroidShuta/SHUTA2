package com.radioactive.prosperous.shuta;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class studentProfile extends AppCompatActivity {
    private DrawerLayout dl2;
    private ActionBarDrawerToggle abdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        dl2 =(DrawerLayout)findViewById(R.id.dl2);
        abdt = new ActionBarDrawerToggle(this,dl2,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);



        dl2.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.course){
                    Toast.makeText(studentProfile.this, "Student'sProfile",Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.OptionalCourse) {
                    Toast.makeText(studentProfile.this, "Registered", Toast.LENGTH_SHORT).show();
                }
                else if (id == R.id.About) {
                    Toast.makeText(studentProfile.this, "about", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        }); }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (abdt.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
