package com.example.vinson_chen.week5_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vinson_Chen on 2015/12/16.
 */
public class SQLliteHelper extends SQLiteOpenHelper {

    public final static int _DBVersion = 1;
    public final static String _DBName = "SampleList.db";
    public final static String _TableName = "MySample";


    public SQLliteHelper(Context context) {
        super(context, _DBName, null, _DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL = "CREATE TABLE IF NOT EXISTS " + _TableName + "( " +
        "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "_NAME VARCHAR(50), " +
        "_PHONE VARCHAR(50)" +
        ");";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String SQL = "DROP TABLE " + _TableName;
        db.execSQL(SQL);
    }
}
