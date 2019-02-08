package com.radioactive.prosperous.shuta;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.radioactive.prosperous.shuta.helper.AdminDatabase;
import com.radioactive.prosperous.shuta.helper.DatabaseHelper;
import com.radioactive.prosperous.shuta.helper.studentDatabase;
import com.radioactive.prosperous.shuta.model.Admin;

public class AdminLogin extends AppCompatActivity {
    EditText txtAdminID;
    EditText txtAdminPwd;
    Button btnAdminLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        txtAdminID = (EditText)findViewById(R.id.txtAdminID);
        txtAdminPwd = (EditText)findViewById(R.id.txtAdminPwd);
        btnAdminLogin = (Button)findViewById(R.id.btnAdminLogin);

    }

    private class AdminLoginTask extends AsyncTask<String, Void, String> {
        String id, pwd;
        @Override
        protected void onPreExecute(){
            super.onPreExecute();

            id = txtAdminID.getText().toString();
            pwd = txtAdminPwd.getText().toString();
        }

        @Override
        protected String doInBackground(String... args) {
            AdminDatabase db = new AdminDatabase(AdminLogin.this);

                boolean verify = db.verifyAdmin(id, pwd);
                if (verify)
                    return id;
                else
                    return null;

        }

        protected void onPostExecute(String id){
            if (id != null )
                success(id);
            else
                failure();
        }
    }

    private void success(String id){
        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
        Intent intent = new Intent( this, AdminHome.class);
        startActivity( intent );
    }

    private void failure(){
        Toast.makeText(getApplicationContext(),"Invalid ID/Password",Toast.LENGTH_LONG).show();
    }

    public void adminLogin(View view)
    {

        String id = txtAdminID.getText().toString();
        String pwd = txtAdminPwd.getText().toString();

        if(id.isEmpty() || pwd.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Fill Empty",Toast.LENGTH_LONG).show();
        }
        else {
            new AdminLoginTask().execute();
        }


    }

    public void newAdmin(View view){
        Intent intent = new Intent(this, AdminRegistration.class);
        startActivity(intent);
    }




}
