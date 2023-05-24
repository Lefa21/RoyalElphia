package fr.montreuil.iut.RoyalElphia.Vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import java.util.ArrayList;

public class VueEnnemi {

    private Ennemis ennemis;
    private Pane pane;

    /*
      public VueEnnemi(Ennemis ennemis, Pane pane) {
            Circle circle = new Circle(10);
            circle.translateXProperty().set(ennemis.getx());
            circle.translateYProperty().set(ennemis.gety());
            circle.setFill(Color.RED);
            circle.translateXProperty().bind(ennemis.getxProperty());
            circle.translateYProperty().bind(ennemis.getyProperty());
            pane.getChildren().add(circle);
        }

     */

    public VueEnnemi(Pane pane) {
        this.pane = pane;
    }

    public void créerSprite(Ennemis ennemis){
        Circle circle = new Circle(10);
        circle.translateXProperty().set(ennemis.getX());
        circle.translateYProperty().set(ennemis.getY());
        circle.setFill(Color.RED);
        circle.translateXProperty().bind(ennemis.getxProperty());
        circle.translateYProperty().bind(ennemis.getyProperty());
        this.pane.getChildren().add(circle);
    }

    }
