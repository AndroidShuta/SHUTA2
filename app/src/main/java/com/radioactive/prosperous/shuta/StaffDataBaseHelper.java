package com.radioactive.prosperous.shuta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class StaffDataBaseHelper extends SQLiteOpenHelper {
    public StaffDataBaseHelper(Context context) {

        super(context,"staff_members.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table staffMembers(ID text primary key not null,email text not null,password text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS staffMembers");
    }
//inserting values to the data base;
    public boolean insert(String id, String Email, String Password)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues value= new ContentValues();

        value.put("ID",id);
        value.put("email",Email);
        value.put("password",Password);

        Long ans= db.insert("staffMembers",null,value);
            if(ans==-1){return false;}
            else{return  true;}

    }

   public  boolean verfing(String id, String password)
    {   SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(" select * from staffMembers where ID=? and password=? ", new String[]{id, password});
        if (cursor.getCount() > 0) {
                return true;
            }
        return false;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from staffMembers",null);
        return res;
    }


    }
