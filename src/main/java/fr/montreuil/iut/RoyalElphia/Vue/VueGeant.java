package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VueGeant extends VueEnnemi {


    public VueGeant(Pane pane) {
        super(pane);
    }


    public void créerSprite(Ennemis ennemis) {
        Circle circle = new Circle(10);
        circle.translateXProperty().set(ennemis.getX());
        circle.translateYProperty().set(ennemis.getY());
        circle.setFill(Color.BROWN);
        circle.setId(ennemis.getId());
        circle.translateXProperty().bind(ennemis.getxProperty());
        circle.translateYProperty().bind(ennemis.getyProperty());
        this.pane.getChildren().add(circle);
    }
}
