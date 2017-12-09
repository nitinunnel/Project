package com.example.acer.project.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.*;

/**
 * Created by acer on 12/9/2017.
 */

public class DBHelper {
    private final String TAG = getClass().getSimpleName();
    private static final String DATABASE_NAME = "potter.db";
    private static final int DATABASE_VERSION = 1;


    public static final String TABLE_NAME = "HARRY";
    public static final String COL_COUNT = "COUNT";
    public static final String COL_ID = "ID";


    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_COUNT + " INTEGER, ";

        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
    }


    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
