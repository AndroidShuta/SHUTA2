package com.radioactive.prosperous.shuta.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.radioactive.prosperous.shuta.model.Admin;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "shutaManager";

    //table names
    private static final String TABLE_ADMIN = "admin";

    //admin table columns
    private static final String KEY_ADMIN_ID = "admin_id";
    private static final String KEY_ADMIN_NAME = "admin_name";
    private static final String KEY_ADMIN_PWD = "admin_pwd";



    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_ADMIN);
        Log.d("android:", "admin table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN);

        onCreate(db);
    }

    public void close(){
        SQLiteDatabase db = this.getReadableDatabase();
        if(db != null && db.isOpen())
            db.close();
    }

    //create admin table
    private static final String CREATE_TABLE_ADMIN = "CREATE TABLE " + TABLE_ADMIN
            + "(" + KEY_ADMIN_ID + " INTEGER PRIMARY KEY,"
            + KEY_ADMIN_NAME + " TEXT,"
            + KEY_ADMIN_PWD + " TEXT" + ")";
    /*
     *CRUD (Create, Read, Update and Delete) Operations
     */

    //adding new admin
    //public long addAdmin(Admin admin){
      public long addAdmin(String name, String pwd){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
       // values.put(KEY_ADMIN_NAME, admin.getAdmin_name());
       // values.put(KEY_ADMIN_PWD, admin.getAdmin_pwd());
          values.put(KEY_ADMIN_NAME, name);
          values.put(KEY_ADMIN_PWD, pwd);

          long admin_id = db.insert(TABLE_ADMIN, null, values);

        return admin_id;
    }


   // public boolean adminLogin(Admin admin){
    public boolean adminLogin(int id, String pwd){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_ADMIN + " WHERE "
              //  + KEY_ADMIN_ID + " = " + admin.getAdmin_id() + " AND "
                //+ KEY_ADMIN_PWD + " = " + admin.getAdmin_pwd();
                + KEY_ADMIN_ID + " = " + id + " AND "
                + KEY_ADMIN_PWD + " = " + pwd;

        Cursor c = db.rawQuery(selectQuery, null);

        if( c != null ){
            if(c.getCount() > 0){
                return true;
            }
        }
        return false;
    }



}
