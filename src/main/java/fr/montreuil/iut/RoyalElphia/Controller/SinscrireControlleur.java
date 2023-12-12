package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.LancementJeu;
import fr.montreuil.iut.RoyalElphia.modele.JDBC.ConnexionJDBC;
import fr.montreuil.iut.RoyalElphia.modele.JDBC.UtilisateurDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class SinscrireControlleur implements Initializable {

    @FXML
    private Button inscriptionBouton;
    @FXML
    private TextField loginLabel;
    @FXML
    private TextField mdpLabel;
    @FXML
    private TextField pseudoLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    public void Inscription(ActionEvent event) throws IOException, SQLException {
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        if(utilisateurDAO.trouverIDJoueur(loginLabel.getText(), pseudoLabel.getText())==-1) {
            utilisateurDAO.insertJoueur(pseudoLabel.getText(), loginLabel.getText(), mdpLabel.getText());
            Stage newWindow = (Stage) this.inscriptionBouton.getScene().getWindow();
            newWindow.setTitle("Paramètres de ma partie");
            FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/Connexion.fxml"));
            newWindow.setScene(new Scene(loader.load()));
            afficherMessageReussit("Inscription réussite");
        }else{
            afficherMessageErreur("Login ou Pseudo déjà existant.");

        }
    }

    private void afficherMessageReussit(String message) {
        Stage reussitStage = new Stage();
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label labelReussite = new Label(message);
        labelReussite.setStyle("-fx-text-fill: green;");
        root.getChildren().add(labelReussite);

        Scene scene = new Scene(root, 300, 200);
        reussitStage.setTitle("Inscription Réussite");
        reussitStage.setScene(scene);
        reussitStage.show();
    }

    private void afficherMessageErreur(String message) {
        Stage erreurStage = new Stage();
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Label labelErreur = new Label(message);
        labelErreur.setStyle("-fx-text-fill: red;");
        root.getChildren().add(labelErreur);

        Scene scene = new Scene(root, 300, 200);
        erreurStage.setTitle("Message d'Erreur");
        erreurStage.setScene(scene);
        erreurStage.show();
    }

    public void Retour(ActionEvent actionEvent) throws IOException {
        Stage newWindow =    (Stage) this.inscriptionBouton.getScene().getWindow();
        newWindow.setTitle("Acceuil");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/Controlleur.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();    }

}


