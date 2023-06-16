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

public class GagnéControlleur implements Initializable {

    @FXML
    private Button Buttonrejouer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    public void rejoue(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Paramètres de ma partie");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/ChoixMap.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
        ((Stage)  Buttonrejouer.getScene().getWindow()).close();
        JeuController.stage.close();
    }

    public void Quitter(ActionEvent actionEvent) {
        Platform.exit();
    }
}
