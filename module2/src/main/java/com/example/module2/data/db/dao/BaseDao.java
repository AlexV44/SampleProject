package com.example.module2.data.db.dao;

import android.database.sqlite.SQLiteDatabase;

import com.example.module2.data.db.MyDatabaseHelper;

public abstract class BaseDao<T> {
    protected SQLiteDatabase readableDB;
    protected SQLiteDatabase writableDB;

    public BaseDao(MyDatabaseHelper dbHelper) {
        readableDB = dbHelper.getReadableDatabase();
        writableDB = dbHelper.getWritableDatabase();
    }

    public abstract boolean create(T object);
    public abstract T getById(String id);
    public abstract boolean update(T object);
    public abstract boolean delete(T object);
    public abstract boolean exists(String id);
}
