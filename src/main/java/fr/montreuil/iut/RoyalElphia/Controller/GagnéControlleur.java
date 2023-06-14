package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.modele.HelloApplication;
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
    private Button Buttonquitter,Buttonrejouer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void Quitter(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Royale Elphia");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/Accueil.fxml"));
        newWindow.setScene(new Scene(loader.load()));

        newWindow.show();
        ((Stage)  Buttonquitter.getScene().getWindow()).close();
      // ((Stage) HelloController.getLabelPV().getScene().getWindow()).close();
    }

    public void rejoue(ActionEvent actionEvent) throws IOException {

        // Stage stage =  SceneController.fermetureStage();
        //stage.close();
        Stage newWindow = new Stage();
        newWindow.setTitle("Paramètres de ma partie");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/ChoixMap.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
        ((Stage)  Buttonrejouer.getScene().getWindow()).close();
        //((Stage) HelloController.().getScene().getWindow()).close();
    }
}
