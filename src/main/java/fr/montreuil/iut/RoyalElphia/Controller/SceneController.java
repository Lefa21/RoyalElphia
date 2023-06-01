package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.HelloApplication;
import fr.montreuil.iut.RoyalElphia.modele.Map.Map2;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Difficile;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Facile;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Niveau;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Normal;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    private jeu jeu;

    private Terrain terrain;

    private Niveau niveau;


    @FXML
    private RadioButton buttonFacile,buttonNormal,buttonDifficile;

@FXML
    public void LancerJeu(ActionEvent event) throws IOException {
    fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/ChoixMap.fxml"));
    scene = new Scene(fxmlLoader.load(), 1920,1080);
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
    }

    /*
    @FXML
    public void CliqueMap2(MouseEvent mouseEvent) {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Niveau.fxml"));
        scene = new Scene(fxmlLoader.load(), 1920,1080);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    */

    public Niveau choixNiveau(){
        if(buttonFacile.isSelected()){
            this.niveau = new Facile();
        }
        else if(buttonNormal.isSelected()){
            this.niveau = new Normal();
        }
        else if(buttonDifficile.isSelected()){
            this.niveau = new Difficile();
        }
        return this.niveau;
    }




    public void CliqueMap1(MouseEvent mouseEvent) throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/Terrain.fxml"));
        scene = new Scene(fxmlLoader.load(), 1920,1080);
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
