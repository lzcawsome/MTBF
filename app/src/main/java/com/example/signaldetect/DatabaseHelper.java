package com.example.signaldetect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //表名为logtable
    public static final String TB_NAME = "logtable";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                TB_NAME + " ( _id integer primary key autoincrement," +//
                "time varchar," +
                "sim varchar," +
                "type varchar"+
                ") ");

//        db.execSQL("CREATE TABLE IF NOT EXISTS " +
//                TB_NAME + " ( _id integer primary key autoincrement," +//
//                "name varchar," +
//                "age integer" +
//                ") ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
