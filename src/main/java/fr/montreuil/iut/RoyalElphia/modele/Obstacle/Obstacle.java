package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import javafx.beans.property.SimpleIntegerProperty;

public class Obstacle extends Items {

    private int Materiaux;
    private int PointDeVie;
    private int ID;

    private int posX,posY;

    public Obstacle(int materiaux,int PointDeVie,int posX,int posY) {
        super(0,0,0,0,0);
        this.Materiaux = materiaux;
        this.PointDeVie = PointDeVie;
        this.posX = posX;
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


    public int getMateriaux() {
        return Materiaux;
    }

    public void setMateriaux(int materiaux) {
        Materiaux = materiaux;
    }

    public int getPointDeVie() {
        return this.PointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        PointDeVie = pointDeVie;
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                ", ID=" + ID +
                ", PointDeVie=" + PointDeVie +
                ", ID=" + ID +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
