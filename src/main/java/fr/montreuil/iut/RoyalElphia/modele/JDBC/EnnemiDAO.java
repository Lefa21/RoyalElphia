package fr.montreuil.iut.RoyalElphia.modele.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnnemiDAO extends ConnexionJDBC{

    public boolean envoieDonner(String requete) {
        try {
            Statement statement = getConnection().createStatement();
            if (statement != null) {
                ResultSet resultat = statement.executeQuery(requete);
                System.out.println("resultset ok");
                while (resultat.next()) {
                    String nom = resultat.getString("nom");
                    System.out.println(nom);
                    return true;
                }
            } else {
                System.out.println("La connexion n'a pas pu être établie.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean typeEnnemiExists(String type_ennemi) {
        String selectQuery = "SELECT 1 FROM ennemi WHERE type_ennemi = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(selectQuery)) {
            preparedStatement.setString(1, type_ennemi);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Retourne true si des résultats sont trouvés
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void envoieDonnerDebut(String type_ennemi, int pv, int point_defense, int degat_base, int degat_obstacle, int butin, String immunite, int capacite_obstacle, String strategie_attaque, String strategie_deplacement) {
        // Vérifier si le type d'ennemi existe déjà
        if (typeEnnemiExists(type_ennemi)) {
            System.out.println("Le type d'ennemi existe déjà dans la table. Effectuer une mise à jour.");

            // Si le type d'ennemi existe, effectuer la mise à jour
            String requete = "UPDATE ennemi SET pv = ?, point_defense = ?, degat_base = ?, degat_obstacle = ?, " +
                    "butin = ?, immunite = ?, capacite_obstacle = ?, strategie_attaque = ?, " +
                    "strategie_deplacement = ? WHERE type_ennemi = ?";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(requete)) {
                preparedStatement.setInt(1, pv);
                preparedStatement.setInt(2, point_defense);
                preparedStatement.setInt(3, degat_base);
                preparedStatement.setInt(4, degat_obstacle);
                preparedStatement.setInt(5, butin);
                preparedStatement.setString(6, immunite);
                preparedStatement.setInt(7, capacite_obstacle);
                preparedStatement.setString(8, strategie_attaque);
                preparedStatement.setString(9, strategie_deplacement);
                preparedStatement.setString(10, type_ennemi);

                // Exécuter la requête de mise à jour
                int rowsAffected = preparedStatement.executeUpdate();

                // Vérifier si la mise à jour a réussi
                if (rowsAffected > 0) {
                    System.out.println("Mise à jour réussie.");
                } else {
                    System.out.println("Échec de la mise à jour.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            // Si le type d'ennemi n'existe pas, effectuer l'insertion
            System.out.println("Le type d'ennemi n'existe pas. Effectuer une insertion.");

            String insertQuery = "INSERT INTO ennemi (type_ennemi, pv, point_defense, degat_base, degat_obstacle, butin, immunite, capacite_obstacle, strategie_attaque, strategie_deplacement) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(insertQuery)) {
                preparedStatement.setString(1, type_ennemi);
                preparedStatement.setInt(2, pv);
                preparedStatement.setInt(3, point_defense);
                preparedStatement.setInt(4, degat_base);
                preparedStatement.setInt(5, degat_obstacle);
                preparedStatement.setInt(6, butin);
                preparedStatement.setString(7, immunite);
                preparedStatement.setInt(8, capacite_obstacle);
                preparedStatement.setString(9, strategie_attaque);
                preparedStatement.setString(10, strategie_deplacement);

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
    }

    public static void main(String[] args) {
        DefenseDAO c = new DefenseDAO();
        c.envoieDonner("Select * from listeJoueur");
        c.envoieDonner("Select * from listeJoueur");

    }
}
