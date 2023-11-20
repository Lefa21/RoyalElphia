package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class MoyenneStrategy implements VagueStrategy {
    public void creerEnnemis(Vague vague, int nbEnnemi, Terrain terrain) {
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
            vague.getListeEnnemis().addFirst(e);
        }
    }
}

