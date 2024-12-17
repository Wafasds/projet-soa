package ws;


import jakarta.jws.*;
import org.example.dbconnection;
import org.example.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebService(endpointInterface = "ws.Test")
public class TestImp implements Test {
    @Override
    public String Helloworld() {
        return "Hello World";
    }

    @Override
    public String Hellot(@WebParam(name = "name") String name) {
        System.out.println("Received name: " + name); // Check what the service receives

        return "Hello " + name;
    }

    public String sayHello(user user1) {
        // Retourner un message personnalisé avec le nom de l'utilisateur
        if (user1 != null && user1.getName() != null) {
            return "Hello " + user1.getName();
        } else {
            return "User information is incomplete.";
        }
    }
    @Override
    public String ajouterUser(user User1) {
        // SQL d'insertion
        String sql = "INSERT INTO utilisateurs (id, name, email) VALUES (?, ?, ?)";

        try (Connection connection = dbconnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Remplir les paramètres de la requête
            statement.setInt(1, User1.getId());
            statement.setString(2, User1.getName());
            statement.setString(3, User1.getEmail());

            // Exécuter la requête d'insertion
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return "Utilisateur ajouté avec succès!";
            } else {
                return "Erreur lors de l'ajout de l'utilisateur.";
            }
        } catch (SQLException e) {
            return "Erreur SQL : " + e.getMessage();
        }
    }
}
