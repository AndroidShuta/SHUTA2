package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
EditText username,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        username= findViewById(R.id.adm_name);
        pass= findViewById(R.id.adm_pwd);
    }
    public void Login (View v){
        String s_id = username.getText().toString();
        String s_password = pass.getText().toString();
String name= "admin";
String pwd= "1111";
        if (s_id.isEmpty() || s_password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill Empty", Toast.LENGTH_LONG).show();
        } else {

            if (s_id.equals(name) && s_password.equals(pwd)) {
                Intent intent = new Intent(this, AdminHome.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "your not the admin", Toast.LENGTH_LONG).show();
            }
        }
    }
}
