package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import java.util.LinkedList;

public class VagueDifficile extends Vague {

    public VagueDifficile(int nbEnnemi, Terrain terrain) {
        super();
        for (int i = 0; i < nbEnnemi; i++) {
            FabriqueEnnemis fabriqueEnnemis = new FabriqueGeantRoyal();
            Ennemis e = fabriqueEnnemis.creerEnnemi(terrain);
            this.listeEnnemis.addFirst(e);
        }
    }
}
