package com.radioactive.prosperous.shuta;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Admin extends AppCompatActivity {
    studentDatabase myDb;
    StaffDataBaseHelper mydb;
    EditText editName,editSurname,editMarks ,editTextId;
    Button btnAddData;
    Button StudbtnviewAll,staffbtnviewall;
    Button btnDelete;
    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        myDb = new studentDatabase(this);
        mydb= new StaffDataBaseHelper(this);


       // btnAddData = (Button)findViewById(R.id.btn_Add);
        //VIEW DATA
        staffbtnviewall = (Button)findViewById(R.id.staff_view);
        StudbtnviewAll = (Button)findViewById(R.id.btn_viewAll);
       // btnviewUpdate= (Button)findViewById(R.id.button_update);
       // btnDelete= (Button)findViewById(R.id.button_delete);

    }
 /*    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData();
                        if(deletedRows > 0)
                            Toast.makeText(getApplicationContext(),"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(),"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
   public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editSurname.getText().toString(),editMarks.getText().toString()editMarks.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(getApplicationContext(),"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(),"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(),"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*/


 // student view from the database
    public void Student_viewAll(View view){
                        Cursor res = mydb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showStaffMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();


                            buffer.append("ID \t\t");
                            buffer.append("E-MAIL \t\t");
                            buffer.append("password \n\n");

        while (res.moveToNext()) {
                            buffer.append(res.getString(0) + "\t\t");
                            buffer.append(res.getString(1) + "\t\t");
                            buffer.append(res.getString(2) + "\n");
                }
                        // Show all data
        showStaffMessage("Data",buffer.toString());
    }

    public void showStaffMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    // staff view from the database
    public void Staff_viewAll(View view){
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();


        buffer.append("regNo \t\t");
        buffer.append("FirstName \t\t");
        buffer.append("MiddleName\t \t");
        buffer.append("LastName \n\n");
        buffer.append("password \n\n");

        while (res.moveToNext()) {
            buffer.append(res.getString(0) + "\t\t");
            buffer.append(res.getString(1) + "\t\t");
            buffer.append(res.getString(2) + "\t\t");
            buffer.append(res.getString(3) + "\t\t");
            buffer.append(res.getString(4) + "\t\t");
            buffer.append(res.getString(5) + "\n");
        }
        // Show all data
        showMessage("Data",buffer.toString());
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}