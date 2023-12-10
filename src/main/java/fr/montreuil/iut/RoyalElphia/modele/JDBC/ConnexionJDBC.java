package fr.montreuil.iut.RoyalElphia.modele.JDBC;

import java.sql.*;

public class ConnexionJDBC {
    private static String url = "jdbc:mysql://database-etudiants.iut.univ-paris8.fr/dutinfopw201641";
    private static String usr = "dutinfopw201641";
    private static String mdp = "teraqagu";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection==null) {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url, usr, mdp);
                System.out.println("Vous êtes connecté");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            // Rethrow the exception or handle it according to your needs
            throw new RuntimeException("Erreur lors de la connexion à la base de données", e);
        }
        return connection;
    }

    public boolean connexionJoueur(String loginAVerifier, String mdpAVerifier) throws SQLException {
        String requete = "SELECT * FROM joueur WHERE login = ? AND mdp = ?";
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

    public int trouverIDJoueur(String login) throws SQLException {
        Connection connexion = getConnection(); // Assurez-vous d'avoir une méthode obtenirConnexion()

        String query = "SELECT id_joueur FROM joueur WHERE login = ?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(query)) {
            preparedStatement.setString(1, login);

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
