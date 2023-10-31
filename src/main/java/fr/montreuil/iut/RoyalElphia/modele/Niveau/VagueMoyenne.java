package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import java.util.LinkedList;

public class VagueMoyenne extends Vague {

    public VagueMoyenne(int nbEnnemi, Terrain terrain) {
        super();
        for (int i = 0; i < nbEnnemi; i++) {
            FabriqueEnnemis fabriqueEnnemis;
            // Utilisez un compteur pour alterner entre les types d'ennemis
            int compteur = i % 3;
            if (compteur == 0) {
                fabriqueEnnemis = new FabriqueSorcieres();
            } else if (compteur == 1) {
                fabriqueEnnemis = new FabriqueGobelins();
            } else {
                fabriqueEnnemis = new FabriqueGeant();
            }

            Ennemis e = fabriqueEnnemis.creerEnnemi(terrain);
            this.listeEnnemis.addFirst(e);
        }
    }
}

