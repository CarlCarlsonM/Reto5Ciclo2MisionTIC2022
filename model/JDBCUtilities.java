package model;

import java.sql.*;

public class JDBCUtilities {
    private static final String DB_FILE = "resources/ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:" + DB_FILE;
        return DriverManager.getConnection(url);
    }
}
