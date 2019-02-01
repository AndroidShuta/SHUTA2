package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudentRegisterActivity extends AppCompatActivity {

    studentDatabase mydb;
    EditText fname;
    EditText Mname;
    EditText lname;
    EditText passowrd;
    EditText Email;
    EditText Department;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);
// linking the shuta database and the  register class
        mydb= new studentDatabase(this);

        fname= (EditText)findViewById(R.id.Fname);
        Mname= (EditText)findViewById(R.id.Sname);
        lname= (EditText)findViewById(R.id.Lname);
        passowrd= (EditText)findViewById(R.id.pwd);
        Email= (EditText)findViewById(R.id.email);
        Department= (EditText)findViewById(R.id.dpt);

    }
// register button

    public void Register(View view) {
        String firstname = fname.getText().toString();
        String secname = Mname.getText().toString();
        String lastname = lname.getText().toString();
        String email = Email.getText().toString();
        String pwd = passowrd.getText().toString();
        String dpartment = Department.getText().toString();

        if (
                firstname.isEmpty()
                        || secname.isEmpty()
                        || lastname.isEmpty()
                        || pwd.isEmpty()
                        || email.isEmpty()
                        || dpartment.isEmpty()
        )
        {
            Toast.makeText(this, "Fill the Empty Space", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean isInserted = mydb.insertData(firstname, secname, lastname, pwd, email, dpartment);

            if (isInserted == true)
            {
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
        }



    }

}
