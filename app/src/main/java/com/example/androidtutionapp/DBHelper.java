package com.example.androidtutionapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "login.db";

    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table login(name  TEXT primary key,email String ,pass TEXT,cpass TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop table if exists login");

    }

    public Boolean insertData(String name, String email,String pass,String cpass) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("pass",pass);
        contentValues.put("cpass",cpass);

        long result = MyDB.insert("login", null, contentValues);
        if (result == -1) return false;
        else
            return true;

    }

    public Boolean checknameuser(String name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from login where name = ?", new String[] {name});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public Boolean checkemailpass( String email,String pass ) {
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from login where email = ? and pass = ? ", new String[]{email,pass});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


}
