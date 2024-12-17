package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
    public static Connection getConnection() throws SQLException {
        // Remplacez ces paramètres par les informations de votre propre base de données
        String url = "jdbc:mysql://localhost:3306/dbconnection";
        String username = "root";
        String password = "";  // Remplacez par votre mot de passe MySQL

        // Charger le driver MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL non trouvé", e);
        }
    }
}
