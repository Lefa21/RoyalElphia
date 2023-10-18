package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class GéantRoyal extends Ennemis {

    public GéantRoyal(Terrain terrain) {
        super(terrain, 200, 80, 5, 1, 150,4,20);
    }
    // Immunité 5 -->  Immunisé face au tour laser

    public void attaqueEnnemi(Obstacle obstacle){
        if ((getCapaciteObstacle() >= obstacle.getMateriaux() && (getX() / 32 + 1 == obstacle.getPosX() && getY() / 32 == obstacle.getPosY()) || (getX() / 32 == obstacle.getPosX() && getY() / 32 + 1 == obstacle.getPosY()) || (getX() / 32 == obstacle.getPosX() && getY() / 32 - 1 == obstacle.getPosY()) || (getX() / 32 - 1 == obstacle.getPosX() && getY() / 32 == obstacle.getPosY()))) {
            int degat = getDegatObstacle();
            int vieObstacle = obstacle.getPointDeVie() - degat;
            obstacle.setPointDeVie(vieObstacle);
        }
    }

    public void strategieAttaque(Obstacle o) {

    }
}
