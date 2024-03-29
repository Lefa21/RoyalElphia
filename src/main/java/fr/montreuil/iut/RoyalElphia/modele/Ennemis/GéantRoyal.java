package fr.montreuil.iut.RoyalElphia.modele.Ennemis;


import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.StrategieChangeante;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.DeplacementSimple;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class GéantRoyal extends Ennemis {

    public GéantRoyal(Terrain terrain) {

        super(terrain, 200, 80, 5, 1, 150,4,20, new DeplacementSimple(),new StrategieChangeante());

    }
    // Immunité 5 -->  Immunisé face au tour laser

    public void strategieAttaque(Obstacle o) {
        sa.AttaqueEnnemi(getX(),getY(),o);
    }

    public String getChemin() {
        return "src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/Golem(1).png";
    }
}
