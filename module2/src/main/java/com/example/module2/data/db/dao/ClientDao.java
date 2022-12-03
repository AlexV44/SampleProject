package com.example.module2.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.module2.data.db.MyDatabaseHelper;
import com.example.module2.data.model.Client;
import com.example.module2.util.Constants;

public class ClientDao extends BaseDao<Client> {
    public ClientDao(MyDatabaseHelper dbHelper) {
        super(dbHelper);
    }

    public boolean create(Client client) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Constants.DB.Column.FIRST_NAME, client.getFirstName());
        contentValues.put(Constants.DB.Column.PASSWORD, client.getPassword());

        long result = writableDB.insert(
                Constants.DB.Table.CLIENT,
                null,
                contentValues
        );

        return result != -1;
    }

    @Override
    public Client getById(String id) {
        Cursor cursor = readableDB.rawQuery(
                Constants.DB.Query.SELECT_CLIENT_BY_FIRST_NAME,
                new String[] {id}
        );
        Client client = null;
        if (cursor.getCount() > 0) {
            client = new Client(
                    cursor.getString(0),
                    cursor.getString(1)
            );
        }
        cursor.close();
        return client;
    }

    @Override
    public boolean update(Client object) {
        return false;
    }

    @Override
    public boolean delete(Client object) {
        return false;
    }

    @Override
    public boolean exists(String id) {
        Cursor cursor = readableDB.rawQuery(
                Constants.DB.Query.SELECT_CLIENT_BY_FIRST_NAME,
                new String[] {id}
        );
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }

    public Boolean exists(String firstName, String password) {
        Cursor cursor = readableDB.rawQuery(
                Constants.DB.Query.SELECT_CLIENT_BY_FIRST_NAME_AND_PASSWORD,
                new String[] {firstName, password}
        );
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }
}
