package fr.montreuil.iut.RoyalElphia.Vue;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import java.util.ArrayList;

public abstract class VueEnnemi {

    private Ennemis ennemis;
    protected Pane pane;
    public VueEnnemi(Pane pane) {
        this.pane = pane;
    }

    public abstract void créerSprite(Ennemis ennemis);
    }
