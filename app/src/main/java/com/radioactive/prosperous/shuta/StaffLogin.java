package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StaffLogin extends AppCompatActivity {
    StaffDataBaseHelper mydb;
    private Button login;
    private EditText name,pwdy;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        login=findViewById(R.id.b_login);
        name= findViewById(R.id.et_ID);
        pwdy= findViewById(R.id.et_pass);
        text=findViewById(R.id.creat_acc);


//login onClick listener
mydb= new StaffDataBaseHelper(this);
         login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String s_id= name.getText().toString();
                String s_pwd= pwdy.getText().toString();

                if(s_id.isEmpty()||s_pwd.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fill Empty",Toast.LENGTH_LONG).show();
                }else
                {
                    boolean verfy = mydb.verfing(s_id,s_pwd);
                        if(verfy==true){
                          Intent intent = new Intent(StaffLogin.this,StaffProfile.class);
                          startActivity(intent);
                        }else{
                         Toast.makeText(getApplicationContext(),"please register",Toast.LENGTH_LONG).show();
                        }
                }
            }
        });

//b clickable text
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StaffRegister.class);
                startActivity(intent);
            }
        });
    }

    public  void createAcc(View view){
        Intent intent = new Intent(getApplicationContext(),StaffRegister.class);
        startActivity(intent);
    }

}
