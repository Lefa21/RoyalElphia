package fr.montreuil.iut.RoyalElphia.modele.JDBC;

import java.sql.*;

public class PartieDAO extends ConnexionJDBC{

    public void envoieDonner(String requete) {
        try {
            Statement statement = getConnection().createStatement();
            if (statement != null) {
                ResultSet resultat = statement.executeQuery(requete);
                System.out.println("resultset ok");
                while (resultat.next()) {
                    String nom = resultat.getString("nom");
                    System.out.println(nom);
                }
            } else {
                System.out.println("La connexion n'a pas pu être établie.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void envoieDonnerDebut(String requete, String nom, String description) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(requete)){
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, description);

            // Execute the insertion query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                System.out.println("Insertion successful.");
            } else {
                System.out.println("Insertion failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PartieDAO c = new PartieDAO();
        c.envoieDonner("Select * from listeJoueur");
        c.envoieDonnerDebut("INSERT INTO listeJoueur (nom, description) VALUES (?, ?)" , "Alaa", "Joueur");
        c.envoieDonner("Select * from listeJoueur");

    }
}
