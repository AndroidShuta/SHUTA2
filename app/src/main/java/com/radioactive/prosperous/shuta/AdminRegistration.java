package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.radioactive.prosperous.shuta.helper.AdminDatabase;
import com.radioactive.prosperous.shuta.helper.studentDatabase;

public class AdminRegistration extends AppCompatActivity {
   // studentDatabase mydb;
    EditText admin_id;
    EditText fname;
    EditText Mname;
    EditText lname;
    EditText passowrd;

    AdminDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration);

       // mydb= new studentDatabase(this);

        db= new AdminDatabase(this);

        admin_id= (EditText)findViewById(R.id.txtAdminRegID);
        fname= (EditText)findViewById(R.id.txtAdminFname);
        Mname= (EditText)findViewById(R.id.txtAdminSname);
        lname= (EditText)findViewById(R.id.txtAdminLname);
        passowrd= (EditText)findViewById(R.id.txtAdminPwd);
    }

    public void Register(View view) {
        String id = admin_id.getText().toString();
        String firstname = fname.getText().toString();
        String secname = Mname.getText().toString();
        String lastname = lname.getText().toString();
        String pwd = passowrd.getText().toString();


        if (
                id.equals("")
                        || firstname.equals("")
                        || secname.equals("")
                        || lastname.equals("")
                        || pwd.equals("")

        ) {
            Toast.makeText(this, "Fill the Empty Space", Toast.LENGTH_SHORT).show();
        } else {
            boolean isInserted = db.addAdmin(id, firstname, secname, lastname, pwd);

            if (isInserted == true) {
                Intent intent = new Intent(this, AdminHome.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
        }
    }
}
