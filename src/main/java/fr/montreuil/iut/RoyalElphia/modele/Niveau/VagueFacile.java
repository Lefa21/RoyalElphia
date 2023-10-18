package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import java.util.LinkedList;

public class VagueFacile extends Vague {

    public VagueFacile(int nbEnnemi, Terrain terrain) {
        super(nbEnnemi, terrain);
        this.listeEnnemis = new LinkedList<>();
        for (int i = 0; i < nbEnnemi; i++) {
            FabriqueEnnemis fabriqueEnnemis = new FabriqueGobelins();
            Ennemis e = fabriqueEnnemis.creerEnnemi(terrain);
            this.listeEnnemis.addFirst(e);
        }
    }
}
