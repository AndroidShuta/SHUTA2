package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminHome extends AppCompatActivity {
    studentDatabase myDb;
    CourseDatabase MYDB;
    StaffDataBaseHelper mydb;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        myDb = new studentDatabase(this);
        mydb= new StaffDataBaseHelper(this);
        MYDB= new CourseDatabase(this);


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
                if (id == R.id.ViewStudent){
                    Student_viewAll();
                }
                else if (id == R.id.Viewcourse) {
                    Courses_viewAll();
                }
                else if (id == R.id.viewStaff) {
                    Staff_viewAll();
                }
                else if (id == R.id.addCourse) {
                    addcourses();
                }
                return true;
            }
        });


    }

    // student view from the database
    public void Student_viewAll(){
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            // show message
            showStaffMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();


        buffer.append("ID \t\t");
        buffer.append("E-MAIL \t\t");
        buffer.append("password \n\n");

        while (res.moveToNext()) {
            buffer.append(res.getString(0) + "\t\t");
            buffer.append(res.getString(1) + "\t\t");
            buffer.append(res.getString(2) + "\n");
        }
        // Show all data
        showStaffMessage("Data",buffer.toString());
    }

    public void showStaffMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    // staff view from the database
    public void Staff_viewAll(){
        Cursor res = mydb.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();


        buffer.append("Staff Id \t\t");
        buffer.append("E-mail \t\t");
        buffer.append("staff \n\n");

        while (res.moveToNext()) {
            buffer.append(res.getString(0) + "\t\t");
            buffer.append(res.getString(1) + "\t\t");
            buffer.append(res.getString(2) + "\n\n");
        }
        // Show all data
        showMessage("Data",buffer.toString());
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    // Courses view from the database
    public void Courses_viewAll(){
        Cursor res = MYDB.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessageCourses("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();


        buffer.append("course_id\t\t");
        buffer.append("course_name \t\t");
        buffer.append("course_yr \t\t");
        buffer.append("staff_id \t\t");
        buffer.append("description \n");

        while (res.moveToNext()) {
            buffer.append(res.getString(0) + "\t\t");
            buffer.append(res.getString(1) + "\t\t");
            buffer.append(res.getString(2) + "\t\t");
            buffer.append(res.getString(3) + "\t\t");
            buffer.append(res.getString(4) + "\n");
        }
        // Show all data
        showMessageCourses("Data",buffer.toString());
    }

    public void showMessageCourses(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void addcourses(){
        Intent intent = new Intent(getApplicationContext(),Admin.class);
        startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (abdt.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
