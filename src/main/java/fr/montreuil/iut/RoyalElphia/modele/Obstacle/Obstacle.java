package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Obstacle extends Items {

    private int Materiaux;
    private IntegerProperty  PointDeVie;
    private int ID;

    private IntegerProperty posX,posY;

    public Obstacle(int materiaux,int PointDeVie) {
        super(0,0,0,0,0,0,0);
        this.Materiaux = materiaux;
        this.PointDeVie = new SimpleIntegerProperty(PointDeVie);
    }

    public int getMateriaux() {
        return Materiaux;
    }

    public void setMateriaux(int materiaux) {
        Materiaux = materiaux;
    }

    public int getPointDeVie() {
        return this.PointDeVie.getValue();
    }

    public IntegerProperty getPvProperty() {
        return this.PointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.PointDeVie.setValue(pointDeVie);
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                ", ID=" + super.getID() +
                ", PointDeVie=" + PointDeVie +
                ", ID=" + super.getID() +
                ", posX=" + super.getPosX() +
                ", posY=" + super.getPosY() +
                '}';
    }
}
