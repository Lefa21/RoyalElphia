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
        /*
        Circle circle = new Circle(10);
        circle.setId(ennemis.getId());
        circle.translateXProperty().bind(ennemis.getxProperty());
        circle.translateYProperty().bind(ennemis.getyProperty());
         */
        Label label = new Label();
        label.textProperty().bind(ennemis.getPvProperty().asString());
        label.setId(ennemis.getId() + "L");
        label.translateXProperty().bind(ennemis.getxProperty().add(-8));
        label.translateYProperty().bind(ennemis.getyProperty().add(-32));
        label.setBackground(Background.fill(Color.WHITE));

        if (ennemis instanceof gobelins) {
           // circle.setFill(Color.GREEN);
        } else if (ennemis instanceof Sorcières) {
           // circle.setFill(Color.VIOLET);
        } else if (ennemis instanceof GéantRoyal) {
            Image golem = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/Golem(1).png"));
            ImageView Golem = new ImageView(golem);
            Golem.setId(ennemis.getId());
            Golem.translateXProperty().bind(ennemis.getxProperty());
            Golem.translateYProperty().bind(ennemis.getyProperty());
            //circle.setFill(Color.BLACK);
            this.pane.getChildren().add(Golem);

        } else if (ennemis instanceof Géant) {
          //  circle.setFill(Color.BROWN);
        } else if (ennemis instanceof Squelette) {
            Image squelette = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/Golem(1).png"));
            ImageView Squelette = new ImageView(squelette);
            Squelette.setId(ennemis.getId());
            Squelette.translateXProperty().bind(ennemis.getxProperty());
            Squelette.translateYProperty().bind(ennemis.getyProperty());
            //circle.setFill(Color.BLACK);
            this.pane.getChildren().add(Squelette);
           // circle.setFill(Color.GREY);
        }
      //  this.pane.getChildren().add(circle);
        this.pane.getChildren().add(label);
    }
}