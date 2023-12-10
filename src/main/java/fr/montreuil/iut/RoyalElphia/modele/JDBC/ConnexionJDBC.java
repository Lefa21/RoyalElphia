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
}
