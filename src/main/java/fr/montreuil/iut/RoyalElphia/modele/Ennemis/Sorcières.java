package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.AttaqueDistance;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.AttaqueFaible;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.AttaqueModeree;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.AttaquePuissante;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class Sorcières extends Ennemis {

    public Sorcières(Terrain terrain) {
        super(terrain, 100, 35, 1, 2, 55,2,10, new AttaqueDistance());
        // Immunité 1 -->  Immunisé face au tour à bombe
    }

    public void strategieAttaque(Obstacle o) {
        sa.AttaqueEnnemi(getCapaciteObstacle(),getX(),getY(),o,(this));
    }
}
