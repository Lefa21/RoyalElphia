package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.LancementJeu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// La classe ChoixMap controller nous permet de récuperer d'afficher la page de choix de map.
// Celle ci va proposer au joueur de choisir le choix de sa map ainsi que son niveau et de lancer le jeu.

public class ChoixMapController implements Initializable {

    private static int niveau;
    private static int terrain;

    @FXML
    private RadioButton buttonFacile, buttonNormal, buttonDifficile, buttonMap1, buttonMap2;


    // La méthode choixNiveau nous permet de récupérer le choix du niveau de la map par rapport au choix du joueur.
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

    // La méthode choixMap récupère le choix de map du joueur

    public int choixMap() {
        int map = 0;
        if (buttonMap1.isSelected()) {
            map = 1;
        } else if (buttonMap2.isSelected()) {
            map = 2;
        }
        return map;
    }

    // La méthode getNiveau permet de retourner le niveau choisi par l'utilisateur au controller du jeu.
    public static int getNiveau() {
        return ChoixMapController.niveau;
    }
    // La méthode getTerrain permet de retourner le terrain choisi par l'utilisateur au controller du jeu.

    public static int getTerrain() {
        return ChoixMapController.terrain;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    // La méthode jouer permet de charger la page du jeu et d'attribuer le niveau ainsi que le terrain
    public void Jouer(ActionEvent actionEvent) throws IOException {
            this.niveau = choixNiveau();
            this.terrain = choixMap();
            Stage newWindow = new Stage();
            newWindow.setTitle("Royale Elphia");
            FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/Terrain.fxml"));
            newWindow.setScene(new Scene(loader.load(),1920, 1080));
            newWindow.show();
        ((Stage)  buttonFacile.getScene().getWindow()).close();
    }

    // La méthode RetourMenu permet de revenir au menu du jeu

    public void RetourMenu(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Royale Elphia");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/Acceuil.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
        ((Stage)  buttonFacile.getScene().getWindow()).close();
    }
}
