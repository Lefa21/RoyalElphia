package fr.montreuil.iut.RoyalElphia.modele.Ennemis;


import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.StrategieChangeante;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement.DeplacementSimple;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class Sorciere extends Ennemis {

    public Sorciere(Terrain terrain) {

        super(terrain, 100, 35, 1, 2, 55,2,10, new DeplacementSimple(), new StrategieChangeante());

        // Immunité 1 -->  Immunisé face au tour à bombe
    }

    public void strategieAttaque(Obstacle o) {
        sa.AttaqueEnnemi(getX(),getY(),o);
    }

    public String getChemin() {
        return "src/main/resources/fr/montreuil/iut/RoyalElphia/ImageEnnemis/sorcière.png";
    }

}
