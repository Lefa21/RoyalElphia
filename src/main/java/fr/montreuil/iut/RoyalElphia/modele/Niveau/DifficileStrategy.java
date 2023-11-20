package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class DifficileStrategy implements VagueStrategy {
    public void creerEnnemis(Vague vague, int nbEnnemi, Terrain terrain) {
        for (int i = 0; i < nbEnnemi; i++) {
            FabriqueEnnemis fabriqueEnnemis = new FabriqueGeantRoyal();
            Ennemis e = fabriqueEnnemis.creerEnnemi(terrain);
            vague.getListeEnnemis().addFirst(e);
        }
    }
}
