package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChoixMapController implements Initializable {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;


    private static int niveau;
    private static int terrain;

    @FXML
    private RadioButton buttonFacile, buttonNormal, buttonDifficile, buttonMap1, buttonMap2;


    public int choixNiveau() {
        int niveau = 0;
        if (buttonFacile.isSelected()) {
            niveau = 1;
        } else if (buttonNormal.isSelected()) {
            niveau = 2;
        } else if (buttonDifficile.isSelected()) {
            niveau = 3;
        }
        return niveau;
    }

    public int choixMap() {
        int map = 0;
        if (buttonMap1.isSelected()) {
            map = 1;
        } else if (buttonMap2.isSelected()) {
            map = 2;
        }
        return map;
    }

    public static int getNiveau() {
        return ChoixMapController.niveau;
    }

    /*
    public  Stage fermetureStage(){
        return this.stage;
    }


     */
    public static int getTerrain() {
        return ChoixMapController.terrain;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void Jouer(ActionEvent actionEvent) throws IOException {
            this.niveau = choixNiveau();
            this.terrain = choixMap();
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/Terrain.fxml"));
            scene = new Scene(fxmlLoader.load(), 1920, 1080);
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
}
