package com.radioactive.prosperous.shuta.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class studentDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="shutaManager";

    //tables
    public static final String STUDENT_TABLE="Students";
    public static final String ADMIN_TABLE="Admin";

    //common columns
    public static final String FNAME="FirstName";
    public static final String MNAME="MiddleName";
    public static final String LNAME="LastName";
    public static final String PWD="Password";

    //student table columns
    public static final String REG_NO="RegNo";
    public static final String FORM="Form";

    //admin table columns
    public static final String ADMIN_ID="AdminID";



    public studentDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + STUDENT_TABLE +"  (" +
                "RegNo TEXT PRIMARY KEY NOT NULL," +
                "FirstName TEXT NOT NULL," +
                "MiddleName TEXT NOT NULL," +
                "LastName TEXT NOT NULL," +
                "Form TEXT NOT NULL," +
                "Password TEXT  NOT NULL) ");

        db.execSQL("create table " + ADMIN_TABLE +"  (" +
                "AdminID TEXT PRIMARY KEY NOT NULL," +
                "FirstName TEXT NOT NULL," +
                "MiddleName TEXT NOT NULL," +
                "LastName TEXT NOT NULL," +
                "Password TEXT  NOT NULL) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ STUDENT_TABLE);
        db.execSQL(" DROP TABLE IF EXISTS "+ ADMIN_TABLE);

        onCreate(db);
    }

    //student handling
    public boolean addStudent(String regno,String fName,String sName, String lName, String form, String pwd)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues value = new ContentValues();

        value.put(REG_NO,regno);
        value.put(FNAME,fName);
        value.put(MNAME,sName);
        value.put(LNAME,lName);
        value.put(FORM,form);
        value.put(PWD,pwd);


        Long results=db.insert(STUDENT_TABLE,null,value);
        if(results==-1)
        {return false;}
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ STUDENT_TABLE,null);
        return res;
    }
    public  boolean verifyStudent(String id, String password)
    {   SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" select * from "+STUDENT_TABLE+" where "+REG_NO+"=? and " +PWD +"=? ", new String[]{id, password});
        if(cursor.getCount() > 0) {return  true;}
        else{return false;}
    }


    //admin handling
    public boolean addAdmin(String id,String fName,String sName, String lName,String pwd)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues value = new ContentValues();

        value.put(ADMIN_ID,id);
        value.put(FNAME,fName);
        value.put(MNAME,sName);
        value.put(LNAME,lName);
        value.put(PWD,pwd);


        Long results=db.insert(ADMIN_TABLE,null,value);
        if(results==-1)
        {return false;}
        else
            return true;
    }

    public  boolean verifyAdmin(String id, String password)
    {   SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" select * from "+ADMIN_TABLE+" where "+ADMIN_ID+"=? and " +PWD +"=? ", new String[]{id, password});
        if(cursor.getCount() > 0) {return  true;}
        else{return false;}
    }
}
