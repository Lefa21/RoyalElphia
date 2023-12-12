package fr.montreuil.iut.RoyalElphia.modele.JDBC;

import java.sql.*;

public class UtilisateurDAO extends ConnexionJDBC{

    public boolean connexionJoueur(String loginAVerifier, String mdpAVerifier) {
        String requete = "SELECT * FROM joueur WHERE login = ? AND mdp = md5(?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(requete)) {
            preparedStatement.setString(1, loginAVerifier);
            preparedStatement.setString(2, mdpAVerifier);

            // Exécuter la requête
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Les informations de connexion sont correctes
                    System.out.println("Connexion réussie !");
                    return true;
                } else {
                    // Aucune correspondance trouvée
                    System.out.println("Login ou mot de passe incorrect.");
                }
            }
        } catch (SQLException e) {
            // Gérer les exceptions liées à la connexion ou à la requête SQL
            e.printStackTrace();
        }
        return false;
    }

    public void insertJoueur(String pseudo, String login, String mdp) {
        String requete = "INSERT INTO joueur (pseudo, login, mdp) VALUES (?, ?, MD5(?))";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(requete)) {
            preparedStatement.setString(1, pseudo);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, mdp);


            // Exécuter la requête d'insertion
            int rowsAffected = preparedStatement.executeUpdate();

            // Vérifier si l'insertion a réussi
            if (rowsAffected > 0) {
                System.out.println("Insertion réussie pour le joueur " + pseudo);
            } else {
                System.out.println("Échec de l'insertion pour le joueur " + pseudo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int trouverIDJoueur(String login, String pseudo) throws SQLException {
        Connection connexion = getConnection(); // Assurez-vous d'avoir une méthode obtenirConnexion()

        String query = "SELECT id_joueur FROM joueur WHERE login = ? or pseudo = ?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(query)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, pseudo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id_joueur");
                } else {
                    // Ajustez le comportement en cas de joueur non trouvé (par exemple, renvoyer -1)
                    return -1;
                }
            }
        }
    }
}
