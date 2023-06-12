package fr.montreuil.iut.RoyalElphia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Acceuil");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/Acceuil.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    public static void main(String[] args) {
        launch();
    }
}