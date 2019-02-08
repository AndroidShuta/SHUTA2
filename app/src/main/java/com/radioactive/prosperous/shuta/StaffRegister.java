package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaffRegister extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1;
    StaffDataBaseHelper mydb;
    TextView text,text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydb= new StaffDataBaseHelper(this);
        setContentView(R.layout.activity_staff_register);
        e1= findViewById(R.id.etName);
        e2= findViewById(R.id.etEmail);
        e3= findViewById(R.id.etPwd);
        b1= findViewById(R.id.btReg);
        text=findViewById(R.id.textMessage);
        text2=findViewById(R.id.textMessagePwd);

                //registering candidates
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_id= e1.getText().toString();
                String s_email=e2.getText().toString().trim();
                String s_pwd= e3.getText().toString();

                if(s_id.equals("")||s_email.equals("")||s_pwd.equals("")){
                    Toast.makeText(getApplicationContext(),"fill empty",Toast.LENGTH_LONG).show();

                }
                else if(!isValidEmailId(s_email)){
                    text.setText("INVALID EMAIL");

                }
                else if(s_pwd.length()<6){
                    text2.setText("week password");
                                }
                else{
                    boolean isInserted = mydb.insert(s_id,s_email,s_pwd);

                    if (isInserted == true)
                    {
                        Intent intent = new Intent(StaffRegister.this, StaffLogin.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(StaffRegister.this, "Data not inserted", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    // email validation patten
    private boolean isValidEmailId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
}
