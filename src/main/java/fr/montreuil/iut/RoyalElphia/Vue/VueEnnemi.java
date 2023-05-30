package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public  class VueEnnemi {

    private Ennemis ennemis;
    protected Pane pane;

    public VueEnnemi(Pane pane) {
        this.pane = pane;
    }

    public void créerSprite(Ennemis ennemis) {
        Circle circle = new Circle(10);
        circle.translateXProperty().set(ennemis.getX());
        circle.translateYProperty().set(ennemis.getY());
        circle.setId(ennemis.getId());
        circle.translateXProperty().bind(ennemis.getxProperty());
        circle.translateYProperty().bind(ennemis.getyProperty());

        if (ennemis instanceof gobelins) {
            circle.setFill(Color.GREEN);
        }

        else if (ennemis instanceof Sorcières) {
            circle.setFill(Color.VIOLET);
        }

        else if (ennemis instanceof GéantRoyal) {
            circle.setFill(Color.BLACK);
        }

        else if (ennemis instanceof Géant) {
            circle.setFill(Color.BROWN);
        }

        else if (ennemis instanceof Squelette) {
            circle.setFill(Color.GREY);
        }
        this.pane.getChildren().add(circle);

    }
}