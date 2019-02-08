package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.radioactive.prosperous.shuta.helper.studentDatabase;

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
        pass = (EditText) findViewById(R.id.txtAdminPwd);

    }


    public void Login(View v){
        mydb = new studentDatabase(this);

        String s_id= username.getText().toString();
        String s_password=pass.getText().toString();

        if(s_id.isEmpty()||s_password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Fill Empty",Toast.LENGTH_LONG).show();
        }else
        {
            boolean verfy = mydb.verifyStudent(s_id,s_password);
            if(verfy==true){
              Intent intent= new Intent(this,StudentHome.class);
              startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Invalid StudentID/Password",Toast.LENGTH_LONG).show();
            }
        }
    }


    public void ToCreateAcc(View view)
    {
        Intent intent = new Intent(this, StudentRegisterActivity.class);
    startActivity(intent);
    }


    public void staffAdminLogin(View view)
    {
        Intent intent = new Intent( this, StaffLogin.class);
        startActivity( intent );
    }

}
