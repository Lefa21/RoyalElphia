package fr.montreuil.iut.RoyalElphia.modele;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

import java.util.ArrayList;
import java.util.LinkedList;


public class Vague {

    private LinkedList<Ennemis> listeEnnemis;
    private Terrain terrain;

    public Vague(int nbEnnemi, Terrain terrain) {
        this.listeEnnemis = new LinkedList<Ennemis>();
        this.terrain = terrain;
        for (int i = 0; i < nbEnnemi; i++) {
            int ran = ((int) (Math.random() * 101));
            Ennemis ennemis;
            if (ran < 21) {
                ennemis = new Sorcières(terrain);
            } else if (ran < 49) {
                ennemis = new Géant(terrain);
            } else if (ran < 61) {
                ennemis = new gobelins(terrain);
            } else if (ran < 71) {
                ennemis = new GéantRoyal(terrain);
            } else {
                ennemis = new Squelette(terrain);
            }
            this.listeEnnemis.addFirst(ennemis);
        }
    }

    public LinkedList<Ennemis> getListeEnnemis() {
        return listeEnnemis;
    }
}
