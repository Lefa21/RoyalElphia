package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VueEnnemi {

    private Ennemis ennemis;
    protected Pane pane;

    public VueEnnemi(Pane pane) {
        this.pane = pane;
    }

    public void créerSprite(Ennemis en) {
        Circle circle = new Circle(10);
        circle.setId(en.getId());
        circle.translateXProperty().bind(en.getxProperty());
        circle.translateYProperty().bind(en.getyProperty());
        circle.setOnMouseClicked(e -> System.out.println(en.affichageImmunité()));

        Label label = new Label();
        label.textProperty().bind(en.getPvProperty().asString());
        label.setId(en.getId() + "L");
        label.translateXProperty().bind(en.getxProperty().add(-8));
        label.translateYProperty().bind(en.getyProperty().add(-32));
        label.setBackground(Background.fill(Color.WHITE));


        if (en instanceof gobelins) {
            circle.setFill(Color.GREEN);
        } else if (en instanceof Sorcières) {
            circle.setFill(Color.VIOLET);
        } else if (en instanceof GéantRoyal) {
            circle.setFill(Color.BLACK);
        } else if (en instanceof Géant) {
            circle.setFill(Color.BROWN);
        } else if (en instanceof Squelette) {
            circle.setFill(Color.GREY);
        }
        this.pane.getChildren().add(circle);
        this.pane.getChildren().add(label);
    }
}