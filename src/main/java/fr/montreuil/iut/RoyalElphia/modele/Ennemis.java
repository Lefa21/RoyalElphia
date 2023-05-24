package fr.montreuil.iut.RoyalElphia.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Ennemis {

    private IntegerProperty xProperty, yProperty;
    private int vitesse; // vitesse de deplacement

   // private int dx,dy ;// direction
    protected Terrain terrain;
    public static int compteur=0;
    private String id;
    private int pv, ptsDefense,Immunité,dégatBase;

    private CasesParcourues casesParcourues;

    public Ennemis (Terrain terrain, int x, int y){
        compteur++;
        this.terrain = terrain;
        this.xProperty = new SimpleIntegerProperty(x);
        this.yProperty = new SimpleIntegerProperty(y);
        this.id = "" + compteur;
        this.casesParcourues = new CasesParcourues();
    }

    public final int getX() {
        return xProperty.getValue();
    }

    public final IntegerProperty getxProperty() {
        return xProperty;
    }


    public final void setX(int n){
        xProperty.setValue(n);
    }

    public final int getY() {
        return yProperty.getValue();
    }

    public final IntegerProperty getyProperty() {
        return yProperty;
    }


    public final void setY(int n){
        yProperty.setValue(n);
    }

    public String getId() {
        return id;
    }

    public void seDeplace(){
        int tab[][] = terrain.getTabTerrain();

        casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));

        if (!casesParcourues.verif(this.getX()+32,this.getY()) && tab[this.getY()/32][(this.getX()/32)+1] == 0){
            this.setX(this.getX()+32);
            casesParcourues.ajouterCase(new Cases(this.getX(),this.getY()));
        }
        else if (!casesParcourues.verif(this.getX(),this.getY()+32) && tab[(this.getY()/32)+1][(this.getX()/32)] == 0) {
            this.setY(this.getY()+32);
            casesParcourues.ajouterCase(new Cases(this.getX(),this.getY()));
        }
        else if (!casesParcourues.verif(this.getX()-32,this.getY()) && tab[(this.getY()/32)][(this.getX()/32)-1] == 0) {
            this.setX(this.getX()-32);
            casesParcourues.ajouterCase(new Cases(this.getX(),this.getY()));
        }
        else if (!casesParcourues.verif(this.getX(),this.getY()-32) && tab[(this.getY()/32)-1][this.getX()/32] == 0) {
            this.setY(this.getY()-32);
            casesParcourues.ajouterCase(new Cases(this.getX(),this.getY()));
        }

    }
}


