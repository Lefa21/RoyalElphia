package fr.montreuil.iut.RoyalElphia.modele.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DefenseDAO extends ConnexionJDBC{

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

    private boolean typeDefenseExists(String type_defense) {
        String selectQuery = "SELECT 1 FROM defense WHERE type_defense = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(selectQuery)) {
            preparedStatement.setString(1, type_defense);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Retourne true si des résultats sont trouvés
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void envoieDonnerDebut(String type_defense, int cout_achat, int cout_vente, int niveau_amelioration, int niveau_max_amelioration, String strategie_defense) {
        // ... (autres parties de la méthode)

        // Vérifier si le type d'ennemi existe déjà
        if (typeDefenseExists(type_defense)) {
            System.out.println("Le type d'ennemi existe déjà dans la table. Effectuer une mise à jour.");

            // Si le type d'ennemi existe, effectuer la mise à jour
            String updateQuery = "UPDATE defense SET cout_achat = ?, cout_vente = ?, niveau_amelioration = ?, " +
                    "niveau_max_amelioration = ?, strategie_defense = ? WHERE type_defense = ?";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, cout_achat);
                preparedStatement.setInt(2, cout_vente);
                preparedStatement.setInt(3, niveau_amelioration);
                preparedStatement.setInt(4, niveau_max_amelioration);
                preparedStatement.setString(5, strategie_defense);
                preparedStatement.setString(6, type_defense);

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
            System.out.println("Le type de defense n'existe pas. Effectuer une insertion.");

            // ... (vérifier la longueur des chaînes, si nécessaire)

            String insertQuery = "INSERT INTO defense (type_defense, cout_achat, cout_vente, niveau_amelioration, niveau_max_amelioration, strategie_defense) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(insertQuery)) {
                preparedStatement.setString(1, type_defense);
                preparedStatement.setInt(2, cout_achat);
                preparedStatement.setInt(3, cout_vente);
                preparedStatement.setInt(4, niveau_amelioration);
                preparedStatement.setInt(5, niveau_max_amelioration);
                preparedStatement.setString(6, strategie_defense);

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
