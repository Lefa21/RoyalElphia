package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

import java.util.ArrayList;

public class StrategieChangeante implements StrategieAttaque{

    private int nbTour;
    private ArrayList<StrategieAttaque> listeStrat;


    public StrategieChangeante() {
        this.listeStrat = new ArrayList<>();
        listeStrat.add(new AttaqueEnFonctionDeLaBase());
        listeStrat.add(new AttaqueDistance());
    }

    @Override
    public void AttaqueEnnemi(int capacite, int dx, int dy, Obstacle obstacle) {    //Sa strategie évolue au fil du nombre de tour
        if (nbTour <= 75){
            listeStrat.get(1).AttaqueEnnemi(capacite,dx,dy,obstacle);
        System.out.println("distance");}
        if (nbTour > 75) {
            listeStrat.get(0).AttaqueEnnemi(capacite,dx,dy,obstacle);
            System.out.println("base");
        }
    }

    public void setNbTour(int nb){this.nbTour = nb;}

}
