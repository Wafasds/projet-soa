package org.example;

import jakarta.jws.WebService;
import jakarta.jws.WebParam;

import java.sql.*;

@WebService(endpointInterface = "org.example.Test")
public class TestImp implements Test {

    @Override
    public String sayHello(@WebParam(name = "user")user User) {
        return "Hello " + user.getName();
    }

    @Override

    public String ajouterUser(@WebParam(name = "user") user Users) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnection", "root", "");
            String sql = "INSERT INTO utilisateurs (name, email) VALUES ('"
                    + user.getName() + "', '"
                    + user.getEmail() + "')";

            stmt = conn.createStatement();
            int rowsInserted = stmt.executeUpdate(sql);
            return (rowsInserted > 0) ? "Utilisateur ajouté avec succès!" : "Échec de l'ajout de l'utilisateur.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de l'ajout de l'utilisateur : " + e.getMessage();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String updateUser(@WebParam(name = "user") user User) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnection", "root", "");
            String sql = "UPDATE utilisateurs SET name = ?, email = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setInt(3, user.getId());
            int rowsUpdated = pstmt.executeUpdate();
            return (rowsUpdated > 0) ? "Utilisateur mis à jour avec succès!" : "Échec de la mise à jour de l'utilisateur.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String deleteUser(@WebParam(name = "id") int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbconnection", "root", "");
            String sql = "DELETE FROM utilisateurs WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            return (rowsDeleted > 0) ? "Utilisateur supprimé avec succès!" : "Échec de la suppression de l'utilisateur.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erreur lors de la suppression de l'utilisateur : " + e.getMessage();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
