package com.example.kalpeshsoni.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Login(Uname text primary key, Email text , Password text)");
        db.execSQL("CREATE TABLE Data(Price text ,Purpose text , Date date, Description text,Payment text )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Login");
        db.execSQL("drop table if exists Data");


    }

    public boolean insData(String Price, String Purpose, String Date, String Description, String Payement)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Price",Price);
        contentValues.put("Purpose",Purpose);
        contentValues.put("Date",Date);
        contentValues.put("Payment",Payement);
        long ins = db.insert("Data",null,contentValues);
        if(ins == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean insert(String Uname,String Email,String Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",Uname);
        contentValues.put("Email",Email);
        contentValues.put("Password",Password);
        long ins = db.insert("Login",null,contentValues);
        if(ins == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Boolean chkemail(String Email)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Login where Email =?",new String[]{Email});
        if(cursor.getCount() > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }



    //checking the email and password
    public Boolean emailPwd(String email, String pwd)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Login where Email =? and Password=?",new String[]{email,pwd});
        if(cursor.getCount() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
