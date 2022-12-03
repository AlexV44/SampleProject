package com.example.module2.util;

public interface Constants {
    interface DB {
        String NAME = "newDB.db";
        int VERSION = 1;

        interface Table {
            String CLIENT = "client";
        }

        interface Column {
            String FIRST_NAME = "firstname";
            String PASSWORD = "password";
        }

        interface Query {
            String CREATE_TABLE_CLIENT = "CREATE Table " + Table.CLIENT + " (" + Column.FIRST_NAME +
                            " TEXT primary key, " + Column.PASSWORD + " TEXT)";

            String SELECT_CLIENT_BY_FIRST_NAME = "SELECT * FROM " + Table.CLIENT + " WHERE " +
                    Column.FIRST_NAME + " = ?";

            String SELECT_CLIENT_BY_FIRST_NAME_AND_PASSWORD = "SELECT * FROM " + Table.CLIENT + " WHERE " +
                    Column.FIRST_NAME + " = ? and " + Column.PASSWORD + " = ?";
        }
    }
}
