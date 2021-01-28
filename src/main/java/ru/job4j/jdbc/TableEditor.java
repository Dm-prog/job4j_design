package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws ClassNotFoundException, SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password"));
    }

    public void createTable(String tableName) {
        String createTable = "create table " + tableName + "()";
    }

    public void dropTable(String tableName) {
        String dropTable = "drop table " + tableName;
    }

    public void addColumn(String tableName, String columnName, String type) {
        String addColumn = "alter table " + tableName + " add column " + columnName + " " + type;
    }

    public void dropColumn(String tableName, String columnName) {
        String dropColumn = "alter table " + tableName + " drop column " + columnName;
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String renameColumn = "alter table " + tableName + " rename column " + columnName
                + " to " + newColumnName;
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
