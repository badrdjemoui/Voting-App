package com.example.programmingknowledge.votingapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDb extends SQLiteOpenHelper {
    public MyDb(Context context) {
        super(context, "voting.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table users (username varchar(20) ,password varchar(20)) ;");
        db.execSQL("insert into users values ('badr','123') ;");
        db.execSQL("create table artist(id number(2),name varchar(50),votes number(4));");
        db.execSQL("create table voting(id number(2),mobile varchar(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
