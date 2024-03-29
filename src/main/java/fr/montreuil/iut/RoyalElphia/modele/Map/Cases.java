package fr.montreuil.iut.RoyalElphia.modele.Map;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Cases {
    /*
    Classe permettant de gérer les positions en fontion du tableau terrain ou de la map
    */
    private IntegerProperty x, y;
    private int valeur;

    public Cases(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public Cases(int x, int y,int valeur) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.valeur = valeur;
    }

    public boolean compare(Cases c) {
        return this.getX()==c.getX() && this.getY()==c.getY();
    }

    public int getX() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public int getValeur() {return this.valeur;}

    //@Override
    public String toString() {
        return "Cases " +
                " x = " + getX() +
                ", y = " + getY();
    }
}