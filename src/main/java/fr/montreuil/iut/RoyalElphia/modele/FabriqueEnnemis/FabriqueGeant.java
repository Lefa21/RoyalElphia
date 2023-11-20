package fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Geant;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class FabriqueGeant implements FabriqueEnnemis{
    @Override
    public Ennemis creerEnnemi(Terrain terrain) {
        return new Geant(terrain);
    }
}
