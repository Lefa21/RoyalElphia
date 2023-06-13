package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.HelloApplication;
import fr.montreuil.iut.RoyalElphia.Vue.TerrainVue;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Map.Map2;
import fr.montreuil.iut.RoyalElphia.modele.Map.Map_1;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Difficile;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Facile;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Niveau;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Normal;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController implements Initializable{
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;


    private static int  niveau;
    private static  int terrain;

    @FXML
    private Button lancer;

    @FXML
    private RadioButton buttonFacile,buttonNormal,buttonDifficile,buttonMap1,buttonMap2;


@FXML
    public void LancerJeu(ActionEvent event) throws IOException {
    Stage newWindow =    (Stage) this.lancer.getScene().getWindow();
    newWindow.setTitle("Paramètres de ma partie");
    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/ChoixMap.fxml"));
    newWindow.setScene(new Scene(loader.load()));
    //newWindow.show();
    }



    public int choixNiveau(){
    int niveau = 0;
        if(buttonFacile.isSelected()){
            niveau =  1;
        }
        else if(buttonNormal.isSelected()){
            niveau =  2;
        }
        else if(buttonDifficile.isSelected()){
           niveau =  3;
        }
        return niveau;
    }

    public int choixMap(){
        int map = 0;
        if(buttonMap1.isSelected()){
            map =  1;
        }
        else if(buttonMap2.isSelected()){
            map =  2;
        }
        return map;
    }

    public static int getNiveau() {
        return SceneController.niveau;
    }

    /*
    public  Stage fermetureStage(){
        return this.stage;
    }


     */
    public static int getTerrain() {
        return SceneController.terrain;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void Jouer(ActionEvent actionEvent) throws IOException {


    if(choixMap()== 1){
        this.niveau = choixNiveau();
        this.terrain = choixMap();
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/Terrain.fxml"));
        scene = new Scene(fxmlLoader.load(), 1920,1080);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //((HelloController)fxmlLoader.getController()).créationPartie();
        stage.setScene(scene);
        stage.show();

    }
    else{
        this.niveau = choixNiveau();
        this.terrain = choixMap();
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/Terrain.fxml"));
        scene = new Scene(fxmlLoader.load(), 1920,1080);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        //((HelloController)fxmlLoader.getController()).test();
        stage.setScene(scene);
        stage.show();
    }
    }

    public void Quitter(ActionEvent actionEvent) {
        Platform.exit();
    }
}
