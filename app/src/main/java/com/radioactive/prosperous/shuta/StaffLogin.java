package com.radioactive.prosperous.shuta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.radioactive.prosperous.shuta.helper.StaffDataBaseHelper;

public class StaffLogin extends AppCompatActivity {
    StaffDataBaseHelper mydb;
    private Button login;
    private EditText name,pwdy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        login= (Button)findViewById(R.id.b_login);
        name= (EditText) findViewById(R.id.et_ID);
        pwdy= (EditText) findViewById(R.id.et_pass);


         login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb= new StaffDataBaseHelper(StaffLogin.this);


                String s_id= name.getText().toString();
                String s_pwd= pwdy.getText().toString();

                if(s_id.isEmpty()||s_pwd.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Fill Empty",Toast.LENGTH_LONG).show();
                }else
                {
                    boolean verfy = mydb.verfing(s_id,s_pwd);
                        verfy = true;
                        if(verfy==true){
                          Intent intent = new Intent(StaffLogin.this,StaffHome.class);
                          intent.putExtra("staff_id", s_id);
                          startActivity(intent);
                        }else{
                         Toast.makeText(getApplicationContext(),"Invalid ID/Password",Toast.LENGTH_LONG).show();
                        }
                }
            }
        });

    }

    public void adminLogin(View view)
    {
        Intent intent = new Intent( this, AdminLogin.class);
        startActivity( intent );
    }

    public void staffRegister(View view)
    {
        Intent intent = new Intent( this, StaffRegister.class);
        startActivity( intent );
    }

}

