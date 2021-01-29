package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/app.properties")) {
            property.load(fis);
            Class.forName("org.postgresql.Driver");
            String url = property.getProperty("db.url");
            String login = property.getProperty("db.login");
            String password = property.getProperty("db.password");
            try (Connection connection = DriverManager.getConnection(url, login, password)) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}