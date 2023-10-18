package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import java.util.LinkedList;


public class Vague {

    protected LinkedList<Ennemis> listeEnnemis;
    private FabriqueEnnemis fabriqueEnnemis;

    public Vague(int nbEnnemi, Terrain terrain) {
        this.listeEnnemis = new LinkedList<>();
        for (int i = 0; i < nbEnnemi; i++) {
            Ennemis e = null;
            if (i % 5 == 0){
                fabriqueEnnemis = new FabriqueSquelette();
            } else if (i % 4 == 0) {
                fabriqueEnnemis = new FabriqueGobelins();
            }
            else if (i % 3 == 0) {
                fabriqueEnnemis = new FabriqueSorcieres();
            }
            else if (i % 2 == 0) {
                fabriqueEnnemis = new FabriqueGeant();
            }
            else {
                fabriqueEnnemis = new FabriqueGeantRoyal();
            }
            e = fabriqueEnnemis.creerEnnemi(terrain);
            this.listeEnnemis.addFirst(e);
        }
    }

    public LinkedList<Ennemis> getListeEnnemis() {
        return listeEnnemis;
    }
}