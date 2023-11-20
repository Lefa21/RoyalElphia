package fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.GeantRoyal;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class FabriqueGeantRoyal implements FabriqueEnnemis{
    @Override
    public Ennemis creerEnnemi(Terrain terrain) {
        return new GeantRoyal(terrain);
    }
}
