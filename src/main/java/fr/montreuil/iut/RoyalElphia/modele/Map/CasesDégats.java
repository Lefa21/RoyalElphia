package fr.montreuil.iut.RoyalElphia.modele.Map;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.net.Inet4Address;

public class CasesDégats extends Cases {
    private IntegerProperty degat;
    private int  typeAttaque; // Permet de savoir sur quel ennemi la tour va faire des dégâts
    private String direction; // Permet une construction de la case dégât en fonction de sa direction

    public CasesDégats(int x, int y, int degat, int typeAttaque, String direction, int multi) {
        super(x, y);
        // Le paramètre multi sert à calculer la portée de la tour
        if (direction.equals("H")) {
            this.setX((this.getX() * 32) + 16);
            this.setY((this.getY() * 32) - (32 * multi) + 16);
        } else if (direction.equals("D")) {
            this.setX((this.getX() * 32) + (32 * multi) + 16);
            this.setY((this.getY() * 32) + 16);
        } else if (direction.equals("B")) {
            this.setX((this.getX() * 32) + 16);
            this.setY((this.getY() * 32) + (32 * multi) + 16);
        } else if (direction.equals("G")) {
            this.setX((this.getX() * 32) - (32 * multi) + 16);
            this.setY((this.getY() * 32) + 16);
        }
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


    public void setDegat(int i){
        this.degat.setValue( getDegat() + i);
    }
}

