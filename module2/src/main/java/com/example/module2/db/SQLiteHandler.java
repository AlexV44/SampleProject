package com.example.module2.db;

import static com.example.module2.db.Config.*;

import android.view.View;
import android.widget.TextView;

import java.sql.*;
import java.util.Scanner;

public class SQLiteHandler {

    Connection con;

    public static void main(String[] args) {

    }

        public void open() {
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(URL);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    public void insert(TextView email, TextView password, TextView firstname, TextView lastname) {

        String query = null;

        try {
            query = "INSERT INTO program (email, password, firstname, lastname) " +
                    "VALUES ('"+ email.getText().toString() + "', '" + password.getText().toString() + "', '" +
                    firstname.getText().toString() + "', '" + lastname.getText().toString() + "')";
            Statement statement = con.createStatement();
            statement.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
