package com.example.module2.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.module2.util.Constants;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public MyDatabaseHelper(Context context)  {
        super(context, Constants.DB.NAME, null, Constants.DB.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL(Constants.DB.Query.CREATE_TABLE_CLIENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {}
}
