package fr.montreuil.iut.RoyalElphia.modele.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NiveauDAO extends ConnexionJDBC{

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

    private boolean typeEnnemiExists(String niveau) {
        String selectQuery = "SELECT COUNT(*) FROM niveau WHERE niveau = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(selectQuery)) {
            preparedStatement.setString(1, niveau);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    System.out.println("Nombre de lignes trouvées : " + count);
                    return count > 0; // Retourne true si des résultats sont trouvés
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void envoieDonnerDebut(String niveau, int nb_ennemi) {
        // Vérifier si le type d'ennemi existe déjà
        if (typeEnnemiExists(niveau)) {
            System.out.println("Le niveau existe déjà dans la table. Effectuer une mise à jour.");

            // Si le type d'ennemi existe, effectuer la mise à jour
            String requete = "UPDATE niveau SET niveau = ?, nb_ennemi = ? WHERE niveau = ?";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(requete)) {
                preparedStatement.setString(1, niveau);
                preparedStatement.setInt(2, nb_ennemi);
                preparedStatement.setString(3, niveau);

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
            System.out.println("Le type Niveau n'existe pas. Effectuer une insertion.");

            String insertQuery = "INSERT INTO niveau (niveau, nb_ennemi) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(insertQuery)) {
                preparedStatement.setString(1, niveau);
                preparedStatement.setInt(2, nb_ennemi);

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
