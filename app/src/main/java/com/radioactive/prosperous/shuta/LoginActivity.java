package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    studentDatabase mydb;
    private  TextView text;
    EditText username, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.userName);
        pass = (EditText) findViewById(R.id.pwd);
        mydb = new studentDatabase(this);
        text= (TextView)findViewById(R.id.creat_acc);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentRegisterActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.optionbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.staff:
                Intent intent = new Intent(this, StaffLogin.class);
                startActivity(intent);
                return true;
            case R.id.admin:
                Intent intent1 = new Intent(this, Admin.class);
                startActivity(intent1);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
              }
        }

    //Login button
    public void Login (View v){
        String s_id = username.getText().toString();
        String s_password = pass.getText().toString();

        if (s_id.isEmpty() || s_password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill Empty", Toast.LENGTH_LONG).show();
        } else {

            boolean verfy = mydb.verfing(s_id, s_password);
            if (verfy == true) {
                Intent intent = new Intent(this, studentProfile.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "please register", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void ToCreateAcc (View view)
    {
        Intent intent = new Intent(this, StudentRegisterActivity.class);
        startActivity(intent);
    }
    public void ToStaffProf (View v){
        Intent intent = new Intent(this, StaffLogin.class);
        startActivity(intent);
    }


}