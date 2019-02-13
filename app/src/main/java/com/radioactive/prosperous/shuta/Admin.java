package com.radioactive.prosperous.shuta;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Admin extends AppCompatActivity {
    studentDatabase myDb;
    StaffDataBaseHelper mydb;
    CourseDatabase Cdb;
    EditText txtAddCourseID;
    EditText txtAddCourseName;
    EditText txtAddCourseYr;
    EditText txtAddCourseStaff;
    EditText txtAddCourseDesc;
    Button btnCourseAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        myDb = new studentDatabase(this);
        mydb = new StaffDataBaseHelper(this);
        Cdb = new CourseDatabase(this);


        // btnAddData = (Button)findViewById(R.id.btn_Add);
        //VIEW DATA

        txtAddCourseID = (EditText) findViewById(R.id.txtAddCourseID);
        txtAddCourseName = (EditText) findViewById(R.id.txtAddCourseName);
        txtAddCourseYr = (EditText) findViewById(R.id.txtAddCourseYr);
        txtAddCourseStaff = (EditText) findViewById(R.id.txtAddCourseStaff);
        txtAddCourseDesc = (EditText) findViewById(R.id.txtAddCourseDesc);
        btnCourseAdd = (Button) findViewById(R.id.btnCourseAdd);
        // btnviewUpdate= (Button)findViewById(R.id.button_update);
        // btnDelete= (Button)findViewById(R.id.button_delete);

    }

    //add courses

    private class AdminAddCourseTask extends AsyncTask<String,Void, String> {
        String id, name, yr, staff, desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            id = txtAddCourseID.getText().toString();
            name = txtAddCourseName.getText().toString();
            yr = txtAddCourseYr.getText().toString();
            staff = txtAddCourseStaff.getText().toString();
            desc = txtAddCourseDesc.getText().toString();

            Toast.makeText(getApplicationContext(), "preexecute", Toast.LENGTH_LONG).show();

        }

        @Override
        protected String doInBackground(String... args) {

            Toast.makeText(getApplicationContext(), "Connect db", Toast.LENGTH_LONG).show();

            boolean isAdded = Cdb.addCourse(id, name, yr, staff, desc);
            if (isAdded)
                Toast.makeText(getApplicationContext(), "Course Added", Toast.LENGTH_LONG).show();

            else
                Toast.makeText(getApplicationContext(), "Failed to Add Course", Toast.LENGTH_LONG).show();

            return id;

        }
    }

    public void addCourse(View view) {
        String id, name, yr, staff, desc;
        CourseDatabase Cdb = new CourseDatabase(Admin.this);

        id = txtAddCourseID.getText().toString();
        name = txtAddCourseName.getText().toString();
        yr = txtAddCourseYr.getText().toString();
        staff = txtAddCourseStaff.getText().toString();
        desc = txtAddCourseDesc.getText().toString();

        if (id.isEmpty() || name.isEmpty() || yr.isEmpty())
            Toast.makeText(getApplicationContext(), "Please Fill Empty Spaces", Toast.LENGTH_LONG).show();
        else {
            //new AdminAddCourseTask().execute();
            boolean isAdded = Cdb.addCourse(id, name, yr, staff, desc);
            if (isAdded)
                Toast.makeText(getApplicationContext(), "Course Added", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(), "Failed to Add Course", Toast.LENGTH_LONG).show();

        }
    }
}
