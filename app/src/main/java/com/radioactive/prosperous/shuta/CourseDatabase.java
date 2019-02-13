package com.radioactive.prosperous.shuta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class CourseDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Course_db";

    public static final String COURSE_TABLE="course_table";
    public static final String STUDENT_COURSE_TABLE="student_course_table";

    //course table columns
    public static final String COURSE_ID="course_id";
    public static final String COURSE_NAME="course_name";
    public static final String COURSE_YR="course_yr";
    public static final String STAFF_ID="staff_id";
    public static final String DESC="description";

    //student_course table columns
    public static final String REG_NO="regNo";




    public CourseDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + COURSE_TABLE +"  (" +
                "course_id TEXT PRIMARY KEY NOT NULL," +
                "course_name TEXT NOT NULL," +
                "course_yr TEXT NOT NULL," +
                "staff_id TEXT," +
                "description TEXT ) ");
        Log.d("Database", "course table created");

        db.execSQL("create table " + STUDENT_COURSE_TABLE +" (" +
                "regNo TEXT NOT NULL," +
                "course_id TEXT NOT NULL," +
                "PRIMARY KEY(regNo, course_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+ COURSE_TABLE);
        db.execSQL(" DROP TABLE IF EXISTS "+ STUDENT_COURSE_TABLE);

        onCreate(db);
    }

    public boolean addCourse(String id,String name,String year, String staff,String desc)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues value = new ContentValues();

        value.put(COURSE_ID,id);
        value.put(COURSE_NAME,name);
        value.put(COURSE_YR,year);
        value.put(STAFF_ID,staff);
        value.put(DESC,desc);


        Long results=db.insert(COURSE_TABLE,null,value);

        Log.d("Database:", "insert in course table");

        if(results==-1)
        {return false;}
        else
            return true;
    }

    public boolean addStudentCourse(String stu_id,String course_id)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues value = new ContentValues();

        value.put(REG_NO,stu_id);
        value.put(COURSE_ID,course_id);


        Long results=db.insert(STUDENT_COURSE_TABLE,null,value);
        if(results==-1)
        {return false;}
        else
            return true;
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ COURSE_TABLE,null);
        return res;
    }

    public String[] getCourse(){
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "select distinct course_id from " + COURSE_TABLE;

        Cursor cursor = db.rawQuery(query, null);
        String[] array = new String[cursor.getCount()];

        if( cursor != null ){
            int i = 0;
            while(cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex(COURSE_ID));
                array[i] = name;
                i++;
            }

        }
        else
            Log.d("CourseDatabase: ", "failed to get course list");

        return array;

    }

    public boolean updateStaffCourse(String course_id, String staff_id){
        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(STAFF_ID, staff_id);

        long res = db.update(COURSE_TABLE, values, COURSE_ID + " = " + course_id , null);
        if(res==-1)
        {return false;}
        else
            return true;
    }

public Cursor getinfo(SQLiteDatabase db)
{

    String[] projection={COURSE_ID,COURSE_NAME,COURSE_YR};
    Cursor cursor= db.query(COURSE_TABLE,projection,null,null,null,null,null);


    return  cursor;
}

    }
