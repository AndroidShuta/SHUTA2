package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    studentDatabase mydb;
    EditText username, pass;
    private RadioButton sButton1,stButton2;
        private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.userName);
        pass = (EditText) findViewById(R.id.pwd);
        mydb = new studentDatabase(this);
        radioGroup = (RadioGroup) findViewById(R.id.rgb);
        sButton1 = (RadioButton) findViewById(R.id.staffradio);
        stButton2 = (RadioButton) findViewById(R.id.registerbtn);

    }
    public void raddionbtn(View view)
    {        //radio buttons checking
                if (sButton1.isChecked()) {
                    Intent intent = new Intent(LoginActivity.this, StaffRegister.class);
                    startActivity(intent);
                } else if (stButton2.isChecked()) {
                    Intent intent = new Intent(LoginActivity.this, StudentRegisterActivity.class);
                    startActivity(intent);
                }

    }

    public void Login(View v){
        String s_id= username.getText().toString();
        String s_password=pass.getText().toString();

        if(s_id.isEmpty()||s_password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Fill Empty",Toast.LENGTH_LONG).show();
        }else
        {
            boolean verfy = mydb.verfing(s_id,s_password);
            if(verfy==true){
              Intent intent= new Intent(this,studentProfile.class);
              startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"please register",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void ToCreateAcc(View view)
    {
        Intent intent = new Intent(this, StudentRegisterActivity.class);
    startActivity(intent);
    }
    public void ToStaffProf(View v){
        Intent intent = new Intent(this, StaffRegister.class);
        startActivity(intent);
    }
}
