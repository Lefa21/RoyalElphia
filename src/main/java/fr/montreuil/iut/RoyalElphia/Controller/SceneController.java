package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

@FXML
    public void LancerJeu(ActionEvent event) throws IOException {
    System.out.println("click sur le bouton ");
    fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ChoixMap.fxml"));
    scene = new Scene(fxmlLoader.load(), 1920,1080);
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }
}
