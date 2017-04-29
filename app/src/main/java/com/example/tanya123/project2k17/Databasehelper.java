package com.example.tanya123.project2k17;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;


public class Databasehelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "NOTE ME UP";
    private static final int DB_VERSION = 2;



    Databasehelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MYDIARY(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"DATE1 TEXT,"
                +"DEAR_DIARY TEXT);");
        db.execSQL("CREATE TABLE T(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"URG_n_IMP TEXT,"
                +"NOTURG_n_IMP TEXT,"
                +"URG_n_NOTIMP TEXT,"
                +"NOTURG_n_NOTIMP TEXT);");
        db.execSQL( "CREATE TABLE SHOPPING(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ITEMS TEXT,"+
                "DATE3 TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 2)
            onCreate(db);
    }

    public void insertmydiary(SQLiteDatabase db, String date,String diary) {
        ContentValues a = new ContentValues();
        a.put("DATE1",date);
        a.put("DEAR_DIARY", diary);

        db.insert("MYDIARY", null, a);
    }

    public void inserttodo(SQLiteDatabase db, String U_n_I, String NU_n_I, String U_n_NI, String NU_n_NI) {
        ContentValues b = new ContentValues();
        b.put("URG_n_IMP", U_n_I);
        b.put("NOTURG_n_IMP", NU_n_I);
        b.put("URG_n_NOTIMP", U_n_NI);
        b.put("NOTURG_n_NOTIMP", NU_n_NI);


        db.insert("T", null, b);
    }

    public void removemydiary(SQLiteDatabase db,int id)
    {

        //String string =String.valueOf(id);
        db.delete("MYDIARY","_id=?",new String[]{Integer.toString(id)});
    }
    public void insertshopping(SQLiteDatabase db, String shop,String date) {
        ContentValues c = new ContentValues();
        c.put("ITEMS", shop);
        c.put("DATE",date);
        db.insert("SHOPPING", null, c);
    }

}