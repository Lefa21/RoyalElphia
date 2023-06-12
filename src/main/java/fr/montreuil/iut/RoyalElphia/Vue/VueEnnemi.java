package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueEnnemi {

    private Ennemis ennemis;
    protected Pane pane;

    public VueEnnemi(Pane pane) {
        this.pane = pane;
    }

    public void créerSprite(Ennemis ennemis) throws FileNotFoundException {
        Circle circle = new Circle(10);
        circle.setId(ennemis.getId());
        circle.translateXProperty().bind(ennemis.getxProperty());
        circle.translateYProperty().bind(ennemis.getyProperty());

        Label label = new Label();
        label.textProperty().bind(ennemis.getPvProperty().asString());
        label.setId(ennemis.getId() + "L");
        label.translateXProperty().bind(ennemis.getxProperty().add(-8));
        label.translateYProperty().bind(ennemis.getyProperty().add(-32));
        label.setBackground(Background.fill(Color.WHITE));


        if (ennemis instanceof gobelins) {
            Image gobelin = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/gobelin.jpg"));
            ImageView gobelinView = new ImageView(gobelin);
            gobelinView.setId(ennemis.getId());
            gobelinView.translateXProperty().bind(ennemis.getxProperty());
            gobelinView.translateYProperty().bind(ennemis.getyProperty().subtract(20));
            this.pane.getChildren().add(gobelinView);
        } else if (ennemis instanceof Sorcières) {
            Image sorciere = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/sorcière.png"));
            ImageView sorciereView = new ImageView(sorciere);
            sorciereView.setId(ennemis.getId());
            sorciereView.translateXProperty().bind(ennemis.getxProperty());
            sorciereView.translateYProperty().bind(ennemis.getyProperty().subtract(20));
            this.pane.getChildren().add(sorciereView);
        } else if (ennemis instanceof GéantRoyal) {
            circle.setFill(Color.BLACK);
        } else if (ennemis instanceof Géant) {
            Image Geant = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/Geant.jpg"));
            ImageView geantView = new ImageView(Geant);
            geantView.setId(ennemis.getId());
            geantView.translateXProperty().bind(ennemis.getxProperty());
            geantView.translateYProperty().bind(ennemis.getyProperty().subtract(20));
            this.pane.getChildren().add(geantView);
        } else if (ennemis instanceof Squelette) {
            circle.setFill(Color.GREY);
        }
        this.pane.getChildren().add(circle);
        this.pane.getChildren().add(label);
    }
}