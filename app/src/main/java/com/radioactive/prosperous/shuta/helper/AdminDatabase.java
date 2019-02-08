package com.radioactive.prosperous.shuta.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class AdminDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Admin_db";
    public static final String DATABASE_TABLE="admin_table";

    public static final String col_1="admin_id";
    public static final String col_2="FirstName";
    public static final String col_3="MiddleName";
    public static final String col_4="LastName";
    public static final String col_5="Password";



    public AdminDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_TABLE +"  (" +
                "admin_id TEXT PRIMARY KEY NOT NULL," +
                "FirstName TEXT NOT NULL," +
                "MiddleName TEXT NOT NULL," +
                "LastName TEXT NOT NULL," +
                "Password TEXT  NOT NULL) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ DATABASE_TABLE);
        onCreate(db);
    }

    public boolean addAdmin(String id,String fName,String sName, String lName,String pwd)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues value = new ContentValues();

        value.put(col_1,id);
        value.put(col_2,fName);
        value.put(col_3,sName);
        value.put(col_4,lName);
        value.put(col_5,pwd);


        Long results=db.insert(DATABASE_TABLE,null,value);
        if(results==-1)
        {return false;}
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ DATABASE_TABLE,null);
        return res;
    }
    public  boolean verifyAdmin(String id, String password)
    {   SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" select * from "+DATABASE_TABLE+" where "+col_1+"=? and " +col_5 +"=? ", new String[]{id, password});
        if(cursor.getCount() > 0) {return  true;}
        else{return false;}
    }
}
