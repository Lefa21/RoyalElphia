package fr.montreuil.iut.RoyalElphia.modele.Ennemis;


import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.StrategieDeplacement;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.StrategieAttaque;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesParcourues;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.LinkedList;

public abstract class Ennemis {

    private int pvMax;
    private IntegerProperty xProperty, yProperty;

    protected Terrain terrain;
    public static int compteur = 0;
    private String id;
    private int ptsDefense, Immunite, degatBase, butin, capaciteObstacle;
    private IntegerProperty pv;
    private CasesParcourues casesParcourues;
    private int degatObstacle;

    private LinkedList<Cases> chemin;
    private StrategieDeplacement strategieDeplacement;

    protected StrategieAttaque sa;

    private BarreDeVie barreDeVie;

    private boolean estBloque = false;



    public Ennemis(Terrain terrain, int pv, int ptsDefense, int immunite, int degatBase, int butin, int capaciteObstacle, int degatObstacle, StrategieDeplacement strategieDeplacement, StrategieAttaque s) {

        this.id = "" + compteur;
        this.casesParcourues = new CasesParcourues();
        this.Immunite = immunite;
        this.degatBase = degatBase;
        this.ptsDefense = ptsDefense;
        this.pv = new SimpleIntegerProperty(pv);
        this.butin = butin;
        this.capaciteObstacle = capaciteObstacle;
        this.degatObstacle = degatObstacle;
        compteur++;
        this.terrain = terrain;
        this.chemin  = new LinkedList<Cases>(this.terrain.getChemin());
        this.pvMax = this.pv.getValue();
        this.strategieDeplacement = strategieDeplacement;

        for (int i = chemin.size()-1; i > 105; i--) {
            System.out.println(chemin.get(i).toString());
        }



        this.sa = s;


        /* On multiplie par 32 la case de départ du terrain, pour adapter les dimensions du tableau aux dimensions du
         terrains et on ajoute 16 pour mettre l'ennemi au centre de la case*/
        this.xProperty = new SimpleIntegerProperty(terrain.getPointDep().getX() * 32 + 16);
        this.yProperty = new SimpleIntegerProperty(terrain.getPointDep().getY() * 32 + 16);

        this.barreDeVie = new BarreDeVie(getPv(), getPvMax(), getId(), getX(), getY());

    }

    public BarreDeVie getBarreDeVie() {
        return barreDeVie;
    }


    private int getPvMax() {
        return this.pvMax;
    }


    public String getId() {
        return id;
    }

    public final int getPv() {
        return pv.getValue();
    }

    public int getPtsDefense() {
        return ptsDefense;
    }

    public void setPv(int degat) {

        // Variable permettant de gérer le taux de dégat que l'ennemi va subir
        double multiplicateur = 1;

        // Si l'attaque de la tour est inférieur à la défense de l'ennemi il subit la moitié des dégats de la tour
        if (degat < this.getPtsDefense())
            multiplicateur = 0.5;

        // On vérifie si les pv de l'ennemi après avoir subit une attaque sont inférieurs à 0
        if (getPv() - (degat * multiplicateur) < 0) {
            this.pv.setValue(0);
        } else {
            this.pv.setValue(this.getPv() - (degat * multiplicateur));
        }
    }

    public void améliorationPv(int pv) {
        this.pv.setValue(pv);
    }

    public int getDegatObstacle() {
        return degatObstacle;
    }

    public IntegerProperty getPvProperty() {
        return this.pv;
    }

    public int getImmunite() {
        return Immunite;
    }

    public int getDegatBase() {
        return degatBase;
    }

    public int getButin() {
        return butin;
    }

    public final int getX() {
        return xProperty.getValue();
    }

    public final IntegerProperty getxProperty() {
        return xProperty;
    }

    public final void setX(int n) {
        xProperty.setValue(n);
    }

    public final int getY() {
        return yProperty.getValue();
    }

    public final IntegerProperty getyProperty() {
        return yProperty;
    }

    public int getCapaciteObstacle() {
        return capaciteObstacle;
    }

    public final void setY(int n) {
        yProperty.setValue(n);
    }

    public void setDegatBase(int degatBase) {
        this.degatBase = degatBase;
    }

    public void setDegatObstacle(int degatObstacle) {
        this.degatObstacle = degatObstacle;
    }

    public void seDeplace() {
        int[] tab = strategieDeplacement.deplacement(this.casesParcourues,this.chemin);
        this.setX(tab[0]);
        this.setY(tab[1]);
    }

    // Méthode permettant de gérer l'affichage de l'immunité aux tours de l'ennemi
    public String affichageImmunité() {
        String affichage = "Cet ennemi est immunisé face aux tours";
        switch (this.Immunite) {
            case 1:
                affichage += " à bombes";
                break;
            case 2:
                affichage += " boule de feu";
                break;
            case 3:
                affichage += " électriques";
                break;
            case 4:
                affichage += " à flèches";
                break;
            case 5:
                affichage += " laser";
                break;
        }
        return affichage;
    }


    public void setPvZero() {
        this.pv.setValue(0);
    }


    public abstract void strategieAttaque(Obstacle o);

    //faire un composite deplacement avec par exemple la teleportation et le fait que l'ennemi est bloque par les obstacles (voir méthode en bas :)
    public void jeSuisBloque(Obstacle obstacle) {
        int x = getX() / 32;
        int y = getY() / 32;
        int obX = obstacle.getPosX();
        int obY = obstacle.getPosY();

            if (obstacle.getPointDeVie() > 0 && (x + 1 == obX && y == obY) || (x == obX && y + 1 == obY) || (x == obX && y - 1 == obY) || (x - 1 == obX && y == obY)) {
                this.estBloque = true;
        }
    }

    public boolean isEstBloque(){
        return estBloque;
    }
    public void setEstBloque(boolean b){
        this.estBloque = b;
    }

    public StrategieAttaque getSt() {
        return sa;
    }
    public abstract String getChemin();

}


