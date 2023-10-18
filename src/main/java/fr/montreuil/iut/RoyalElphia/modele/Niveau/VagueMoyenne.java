package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import java.util.LinkedList;

public class VagueMoyenne extends Vague {

    public VagueMoyenne(int nbEnnemi, Terrain terrain) {
        super();
        for (int i = 0; i < nbEnnemi; i++) {
            FabriqueEnnemis fabriqueEnnemis = new FabriqueSorcieres();
            Ennemis e = fabriqueEnnemis.creerEnnemi(terrain);
            this.listeEnnemis.addFirst(e);
        }
    }
}
