package com.radioactive.prosperous.shuta;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.radioactive.prosperous.shuta.CourseDatabase.COURSE_TABLE;

public class StaffCourses extends AppCompatActivity {

    public static String STAFF_ID;
    Spinner spinStaffCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_courses);
        STAFF_ID = getIntent().getExtras().getString("staff_id");
}



    public void addCourse(View view){


        CourseDatabase db = new CourseDatabase(StaffCourses.this);

        String[] courses = db.getCourse();

        spinStaffCourse = findViewById(R.id.spinnerStaffCourse);
        String[] items  = new String[]{"1", "2", "three"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(StaffCourses.this, android.R.layout.simple_spinner_dropdown_item,courses);
        spinStaffCourse.setAdapter(adapter);

        Toast.makeText(getApplicationContext(),"Courses updated", Toast.LENGTH_LONG).show();

    }




}
