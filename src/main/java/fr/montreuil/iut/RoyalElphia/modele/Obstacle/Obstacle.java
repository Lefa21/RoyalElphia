package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Obstacle extends Items {

    private int Materiaux;
    private IntegerProperty  PointDeVie;
    private int ID;

    private IntegerProperty posX,posY;

    public Obstacle(int materiaux,int PointDeVie,int posX,int posY) {
        super(0,0,0,0,0);
        this.Materiaux = materiaux;
        this.PointDeVie = new SimpleIntegerProperty(PointDeVie);
        this.posX = new SimpleIntegerProperty(posX);
        this.posY = new SimpleIntegerProperty(posY);
    }

    public final IntegerProperty getPosXProperty(){
        return this.posX;
    }

    public final int getPosX(){
       return  this.posX.getValue();
    }

    public final void setPosX(int posX){
        this.posX.setValue(posX);
    }

    public final IntegerProperty getPosYProperty(){
        return this.posY;
    }

    public final int getPosY(){
        return  this.posY.getValue();
    }

    public final void setPosy(int posy){
        this.posY.setValue(posy);
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
                ", ID=" + ID +
                ", PointDeVie=" + PointDeVie +
                ", ID=" + ID +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
