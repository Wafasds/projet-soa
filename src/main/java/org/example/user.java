package org.example;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class user {
    private static int id;
    private static String name;
    private static String email;

    // Constructeur
    public user(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters et Setters
    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
/*
    // Méthode pour créer la table `user`
    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS user (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) NOT NULL" +
                ");";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {

            statement.execute(createTableSQL);
            System.out.println("Table 'user' créée avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la création de la table : " + e.getMessage());
        }
    }*/
}
