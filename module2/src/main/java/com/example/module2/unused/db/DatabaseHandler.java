package com.example.module2.unused.db;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler extends DataCon{
    public static void main(String[] args) throws ClassNotFoundException, SQLException , IOException, ParserConfigurationException {
    }

    public void dbConnecton() throws ClassNotFoundException, SQLException , IOException, ParserConfigurationException {
        String url = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Connection dbConnection = DriverManager.getConnection(url, dbUser, dbPass);

        Statement statement = dbConnection.createStatement();

        ResultSet result = statement.executeQuery("SELECT * FROM users");

        while(result.next()) {
            System.out.println(result.getString("id") + "\n");
        }
    }
}
