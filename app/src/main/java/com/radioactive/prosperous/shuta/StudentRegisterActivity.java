package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StudentRegisterActivity extends AppCompatActivity {

    studentDatabase mydb;
    EditText regno;
    EditText fname;
    EditText Mname;
    EditText lname;
    EditText passowrd;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentregister);
// linking the shuta database and the  register class
        mydb= new studentDatabase(this);

        regno= (EditText)findViewById(R.id.regno);
        fname= (EditText)findViewById(R.id.Fname);
        Mname= (EditText)findViewById(R.id.Sname);
        lname= (EditText)findViewById(R.id.Lname);
        passowrd= (EditText) findViewById(R.id.pwd);



    }
// register button

    public void Register(View view) {
        String reg = regno.getText().toString();
        String firstname = fname.getText().toString();
        String secname = Mname.getText().toString();
        String lastname = lname.getText().toString();
        String pwd = passowrd.getText().toString();


        if (
                reg.equals("")
                        || firstname.equals("")
                        || secname.equals("")
                        || lastname.equals("")
                        || pwd.equals("")

                      )
        {
            Toast.makeText(this, "Fill the Empty Space", Toast.LENGTH_SHORT).show();
        }
        else {
            boolean isInserted = mydb.insertData(reg,firstname, secname, lastname, pwd);

            if (isInserted == true)
            {
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
        }



    }

}
