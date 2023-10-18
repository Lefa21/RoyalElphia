package fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Sorcières;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.gobelins;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public class FabriqueGobelins implements FabriqueEnnemis{
    @Override
    public Ennemis creerEnnemi(Terrain terrain) {
        return new gobelins(terrain);
    }
}
