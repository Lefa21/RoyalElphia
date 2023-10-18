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

        Label label = new Label();
        label.textProperty().bind(ennemis.getPvProperty().asString());
        label.setId(ennemis.getId() + "L");
        label.translateXProperty().bind(ennemis.getxProperty().add(-8));
        label.translateYProperty().bind(ennemis.getyProperty().add(-32));
        label.setBackground(Background.fill(Color.WHITE));
        Image image = null;


        if (ennemis instanceof gobelins) {
            image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/gobelin.png"));
        } else if (ennemis instanceof Sorcières) {
            image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/sorcière.png"));
        } else if (ennemis instanceof GéantRoyal) {
            image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/Golem(1).png"));
        } else if (ennemis instanceof Géant) {
            image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/Geant.png"));
        } else if (ennemis instanceof Squelette) {
            image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/squelette.png"));
        }

        ImageView imV = new ImageView(image);
        imV.setId(ennemis.getId());
        imV.translateXProperty().bind(ennemis.getxProperty().subtract(16));
        imV.translateYProperty().bind(ennemis.getyProperty().subtract(16));

        this.pane.getChildren().add(imV);
        this.pane.getChildren().add(label);
    }
}