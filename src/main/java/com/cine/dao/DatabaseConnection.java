package com.cine.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static String url;
    private static String user;
    private static String password;

    static {
        loadDatabaseProperties();
    }

    private static void loadDatabaseProperties() {
        try (InputStream input = DatabaseConnection.class.getClassLoader()
                .getResourceAsStream("database.properties")) {

            if (input == null) {
                throw new RuntimeException("No se pudo encontrar database.properties");
            }

            Properties properties = new Properties();
            properties.load(input);

            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");

        } catch (IOException e) {
            throw new RuntimeException("Error cargando configuración de BD", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Método para probar la conexión
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("✅ Conexión a MySQL exitosa!");
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Error conectando a MySQL: " + e.getMessage());
            return false;
        }
    }
}