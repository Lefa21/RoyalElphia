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

    public void envoieDonnerFin(int nb_ennemis_tues, int argent_restant, int vague_atteinte, int pv_base, String status, int id_map, int id_joueur, int id_niveau) {
        String requete = "INSERT INTO partie (nb_ennemis_tues, argent_restant, vague_atteinte, pv_base, status, id_map, id_joueur, id_niveau) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(requete)){
            preparedStatement.setInt(1, nb_ennemis_tues);
            preparedStatement.setInt(2, argent_restant);
            preparedStatement.setInt(3, vague_atteinte);
            preparedStatement.setInt(4, pv_base);
            preparedStatement.setString(5, status);
            preparedStatement.setInt(6, id_map);
            preparedStatement.setInt(7, id_joueur);
            preparedStatement.setInt(8, id_niveau);

                // Exécuter la requête d'insertion
            int rowsAffected = preparedStatement.executeUpdate();

                // Vérifier si l'insertion a réussi
            if (rowsAffected > 0) {
                System.out.println("Insertion réussie.");
            } else {
                System.out.println("Échec de l'insertion.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PartieDAO c = new PartieDAO();
        c.envoieDonner("Select * from listeJoueur");
        c.envoieDonner("Select * from listeJoueur");

    }
}
