package com.radioactive.prosperous.shuta;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class studentDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Students_datbase";
    public static final String DATABASE_TABLE="Students_table";
    public static final String col_1="Regislation_Number";
    public static final String col_2="FirstName";
    public static final String col_3="MiddleName";
    public static final String col_4="LastName";
    public static final String col_5="Password";
    public static final String col_6="Department";


    public studentDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DATABASE_TABLE +"  (" +
                "Regislation_Number TEXT PRIMARY KEY NOT NULL," +
                "FirstName TEXT NOT NULL," +
                "MiddleName TEXT NOT NULL," +
                "LastName TEXT NOT NULL," +
                "Password TEXT NOT NULL," +
                "Department TEXT NOT NULL) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ DATABASE_TABLE);
        onCreate(db);
    }

    public boolean insertData(String regno,String fName,String sName, String lName,String pwd,String derp)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(col_1,regno);
        value.put(col_2,fName);
        value.put(col_3,sName);
        value.put(col_4,lName);
        value.put(col_5,pwd);
        value.put(col_6,derp);

        Long results=db.insert(DATABASE_TABLE,null,value);
        if(results==-1)
        {return false;}
        else
            return true;
    }
}
