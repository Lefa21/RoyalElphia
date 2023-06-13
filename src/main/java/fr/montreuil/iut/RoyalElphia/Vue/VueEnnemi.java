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
    //circle.setOnMouseClicked(e -> System.out.println(en.affichageImmunité()));

    public void créerSprite(Ennemis ennemis) throws FileNotFoundException {

        Label label = new Label();
        label.textProperty().bind(ennemis.getPvProperty().asString());
        label.setId(ennemis.getId() + "L");
        label.translateXProperty().bind(ennemis.getxProperty().add(-8));
        label.translateYProperty().bind(ennemis.getyProperty().add(-32));
        label.setBackground(Background.fill(Color.WHITE));
        ImageView imV = null;

        if (ennemis instanceof gobelins) {

            Image gobelin = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/gobelin.jpg"));
            imV = new ImageView(gobelin);
            imV.setId(ennemis.getId());
            imV.translateXProperty().bind(ennemis.getxProperty().subtract(16));
            imV.translateYProperty().bind(ennemis.getyProperty().subtract(16));
            this.pane.getChildren().add(imV);
        } else if (ennemis instanceof Sorcières) {
            Image sorciere = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/sorcière.png"));
            imV = new ImageView(sorciere);
            imV.setId(ennemis.getId());
            imV.translateXProperty().bind(ennemis.getxProperty().subtract(16));
            imV.translateYProperty().bind(ennemis.getyProperty().subtract(16));
            this.pane.getChildren().add(imV);}

        else if (ennemis instanceof GéantRoyal) {
            Image golem = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/Golem(1).png"));
            imV = new ImageView(golem);
            imV.setId(ennemis.getId());
            imV.translateXProperty().bind(ennemis.getxProperty().subtract(16));
            imV.translateYProperty().bind(ennemis.getyProperty().subtract(16));
            //circle.setFill(Color.BLACK);
            this.pane.getChildren().add(imV);
        } else if (ennemis instanceof Géant) {
            Image Geant = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/Geant.jpg"));
            imV = new ImageView(Geant);
            imV.setId(ennemis.getId());
            imV.translateXProperty().bind(ennemis.getxProperty().subtract(16));
            imV.translateYProperty().bind(ennemis.getyProperty().subtract(16));
            this.pane.getChildren().add(imV);
        } else if (ennemis instanceof Squelette) {
            Image squelette = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/squelette.png"));
            imV = new ImageView(squelette);
            imV.setId(ennemis.getId());
            imV.translateXProperty().bind(ennemis.getxProperty().subtract(16));
            imV.translateYProperty().bind(ennemis.getyProperty().subtract(16));
            //circle.setFill(Color.BLACK);
            this.pane.getChildren().add(imV);
           // circle.setFill(Color.GREY);
        }

        imV.setOnMouseClicked(e -> System.out.println(ennemis.affichageImmunité()));
      //  this.pane.getChildren().add(circle);



        this.pane.getChildren().add(label);
    }
}