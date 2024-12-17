package org.example;

import jakarta.xml.ws.Endpoint;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Créer l'implémentation du service
        TestImp testImp = new TestImp();

        // Publier le service Web à l'URL spécifiée
        Endpoint.publish("http://127.0.0.1:8077/ws/test", testImp);

        // Afficher l'URL du WSDL
        System.out.println("Service publié. Vous pouvez accéder au WSDL à l'adresse suivante :");
        System.out.println("http://127.0.0.1:8077/ws/test?wsdl");

        // Utiliser Scanner pour demander les données à l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander combien d'utilisateurs l'utilisateur veut ajouter
        System.out.print("Combien d'utilisateurs voulez-vous ajouter ? ");
        int numberOfUsers = scanner.nextInt();
        scanner.nextLine();  // Consommer le saut de ligne

        // Ajouter les utilisateurs
        for (int i = 0; i < numberOfUsers; i++) {
            System.out.println("\n---- Ajout de l'utilisateur " + (i + 1) + " ----");
            System.out.print("Entrez l'ID de l'utilisateur : ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consommer le saut de ligne
            System.out.print("Entrez le nom de l'utilisateur : ");
            String name = scanner.nextLine();
            System.out.print("Entrez l'email de l'utilisateur : ");
            String email = scanner.nextLine();

            // Créer un objet utilisateur
            user newUser = new user(id, name, email);

            // Tester l'ajout d'un utilisateur via la méthode ajouterUser
            String resultatAjout = testImp.ajouterUser(newUser);
            System.out.println(resultatAjout);  // Affiche le résultat de l'ajout
        }

        // Mise à jour d'un utilisateur
        System.out.println("\n---- Mise à jour d'un utilisateur ----");
        System.out.print("Entrez l'ID de l'utilisateur à mettre à jour : ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); // Consommer le saut de ligne
        System.out.print("Entrez le nouveau nom : ");
        String newName = scanner.nextLine();
        System.out.print("Entrez le nouvel email : ");
        String newEmail = scanner.nextLine();

        user userToUpdate = new user(idToUpdate, newName, newEmail);
        String resultatUpdate = testImp.updateUser(userToUpdate);
        System.out.println(resultatUpdate);  // Cela va afficher "Utilisateur mis à jour avec succès!"

        // Suppression d'un utilisateur
        System.out.println("\n---- Suppression d'un utilisateur ----");
        System.out.print("Entrez l'ID de l'utilisateur à supprimer : ");
        int idToDelete = scanner.nextInt();

        String resultatDelete = testImp.deleteUser(idToDelete);
        System.out.println(resultatDelete);  // Cela va afficher "Utilisateur supprimé avec succès!"
    }
}
