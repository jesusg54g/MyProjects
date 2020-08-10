package com.jesus.amazonviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;

import static com.jesus.amazonviewer.db.DataBase.*;

public interface IDBConnection {

    default Connection connectToDB() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB, USER, PASSWORD);

            if (connection != null) {
                System.out.println("••••••••••••••••");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
