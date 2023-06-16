package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.LancementJeu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/*
Cette classe est le controller de la page d'accueil et a pour but de lancer la page ChoixMap où bien la page règle du jeu à partir de la page d'accueil.
 */
public class AccueilController implements Initializable {
    @FXML
    private Button lancer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    public void LancerJeu(ActionEvent event) throws IOException {
        Stage newWindow =    (Stage) this.lancer.getScene().getWindow();
        newWindow.setTitle("Paramètres de ma partie");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/ChoixMap.fxml"));
        newWindow.setScene(new Scene(loader.load()));
    }

    public void Quitter(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void Regle(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Les règles");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/RegleDeJeu.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }
}
