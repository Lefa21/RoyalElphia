package fr.montreuil.iut.RoyalElphia.modele.Map;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.Inet4Address;

public class CasesDégats extends Cases {
    private IntegerProperty degat;
    static int compt = 0;
    private int typeAttaque; // Permet de savoir sur quel ennemi la tour va faire des dégâts

    public CasesDégats(int x, int y, int degat, int typeAttaque, String direction, int multi, Pane pane) {
        super(x, y);
        // Le paramètre multi sert à calculer la portée de la tour
        Circle c = new Circle(12, Color.BLACK);
        if (direction.equals("H")) {
            this.setX((x * 32) + 16);
            this.setY((y * 32) - (32 * multi) + 16);
            c.setTranslateX(x * 32 + 16);
            c.setTranslateY(y * 32 + 16 - 32 * multi);
        } else if (direction.equals("D")) {
            this.setX((x * 32) + (32 * multi) + 16);
            this.setY((y * 32) + 16);
            c.setTranslateX(x * 32 + 16 + 32 * multi);
            c.setTranslateY(y * 32 + 16);
        } else if (direction.equals("B")) {
            this.setX((x * 32) + 16);
            this.setY((y * 32) + (32 * multi) + 16);
            c.setTranslateX(x * 32 + 16);
            c.setTranslateY(y * 32 + 16 + 32 * multi);
        } else if (direction.equals("G")) {
            this.setX((x * 32) - (32 * multi) + 16);
            this.setY((y * 32) + 16);
            c.setTranslateX(x * 32 + 16 - 32 * multi);
            c.setTranslateY(y * 32 + 16);
        }
        c.setId("A"+compt);
        compt++;
        pane.getChildren().add(c);
        c.setVisible(false);
        this.degat = new SimpleIntegerProperty(degat);
        this.typeAttaque = typeAttaque;
    }



    public int getDegat() {
        return this.degat.getValue();
    }

    public IntegerProperty getDegatProperty() {
        return this.degat;
    }

    public int getTypeAttaque() {
        return this.typeAttaque;
    }

    public boolean verifDegat(Ennemis e) {

        // Méthode qui permet de vérifier si l'ennemi se trouve sur une case ou il subit des dégâts et de vérifier son immunité
        boolean verif = false;
        if (e.getX() == this.getX() && e.getY() == this.getY() && e.getImmunite() != this.getTypeAttaque())
            verif = true;
        return verif;
    }

}

