package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class Sorcières extends Ennemis {

    public Sorcières(Terrain terrain) {
        super(terrain, 100, 35, 1, 2, 55,2,10);
        // Immunité 1 -->  Immunisé face au tour à bombe
    }

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
