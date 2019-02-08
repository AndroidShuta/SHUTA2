package com.radioactive.prosperous.shuta;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.radioactive.prosperous.shuta.helper.CourseDatabase;

public class AdminAddCourse extends AppCompatActivity {
    EditText txtAddCourseID;
    EditText txtAddCourseName;
    EditText txtAddCourseYr;
    EditText txtAddCourseStaff;
    EditText txtAddCourseDesc;
    Button btnCourseAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_course);

        txtAddCourseID = (EditText)findViewById(R.id.txtAddCourseID);
        txtAddCourseName = (EditText)findViewById(R.id.txtAddCourseName);
        txtAddCourseYr = (EditText)findViewById(R.id.txtAddCourseYr);
        txtAddCourseStaff = (EditText)findViewById(R.id.txtAddCourseStaff);
        txtAddCourseDesc = (EditText)findViewById(R.id.txtAddCourseDesc);
        btnCourseAdd = (Button)findViewById(R.id.btnCourseAdd);

    }

    private class AdminAddCourseTask extends AsyncTask<String, Void, String> {
        String id, name, yr, staff,desc;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

            id = txtAddCourseID.getText().toString();
            name = txtAddCourseName.getText().toString();
            yr = txtAddCourseYr.getText().toString();
            staff = txtAddCourseStaff.getText().toString();
            desc = txtAddCourseDesc.getText().toString();

            Toast.makeText(getApplicationContext(),"preexecute",Toast.LENGTH_LONG).show();

        }

        @Override
        protected String doInBackground(String... args){
            CourseDatabase db = new CourseDatabase(AdminAddCourse.this);

            Toast.makeText(getApplicationContext(),"Connect db",Toast.LENGTH_LONG).show();

            boolean isAdded = db.addCourse(id, name, yr, staff, desc);
            if(isAdded)
                Toast.makeText(getApplicationContext(),"Course Added",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Failed to Add Course",Toast.LENGTH_LONG).show();

            return id;

        }
    }

    public void addCourse(View view){
        String id, name, yr, staff, desc;
        CourseDatabase db = new CourseDatabase(AdminAddCourse.this);

        id = txtAddCourseID.getText().toString();
        name = txtAddCourseName.getText().toString();
        yr = txtAddCourseYr.getText().toString();
        staff = txtAddCourseStaff.getText().toString();
        desc = txtAddCourseDesc.getText().toString();

        if(id.isEmpty() || name.isEmpty() || yr.isEmpty())
            Toast.makeText(getApplicationContext(),"Please Fill Empty Spaces",Toast.LENGTH_LONG).show();
        else{
            //new AdminAddCourseTask().execute();
            boolean isAdded = db.addCourse(id, name, yr, staff, desc);
            if(isAdded)
                Toast.makeText(getApplicationContext(),"Course Added",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Failed to Add Course",Toast.LENGTH_LONG).show();

        }
    }
}
