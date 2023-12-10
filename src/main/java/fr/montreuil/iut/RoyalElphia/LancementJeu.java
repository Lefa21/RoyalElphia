package fr.montreuil.iut.RoyalElphia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/*
Cette classe à pour but de lancer la page d'accueil.
 */
public class LancementJeu extends Application {
    @Override
    public void start(Stage newWindow) throws IOException {
        newWindow.setTitle("Acceuil");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/Acceuil.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
