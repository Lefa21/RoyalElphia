package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.LancementJeu;
import fr.montreuil.iut.RoyalElphia.modele.JDBC.ConnexionJDBC;
import javafx.application.Platform;
import javafx.stage.Stage;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ConnexionControlleur implements Initializable {
    @FXML
    private Button connexionBouton;

    @FXML
    private TextField loginLabel;

    @FXML
    private TextField mdpLabel;
    public static String login;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    public void Lancer(ActionEvent event) throws IOException, SQLException {
        ConnexionJDBC connexionJDBC = new ConnexionJDBC();
        if(connexionJDBC.connexionJoueur(loginLabel.getText(), mdpLabel.getText())) {
            login = loginLabel.getText();
            Stage newWindow = (Stage) this.connexionBouton.getScene().getWindow();
            newWindow.setTitle("Paramètres de ma partie");
            FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/ChoixMap.fxml"));
            newWindow.setScene(new Scene(loader.load()));
        }else{
            afficherMessageErreur("Login ou mot de passe incorrect.");

        }
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
        Stage newWindow =    (Stage) this.connexionBouton.getScene().getWindow();
        newWindow.setTitle("Acceuil");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/Acceuil.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();    }
}


