package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class Squelette extends Ennemis {
    public Squelette(Terrain terrain) {
        super(terrain, 50, 0, 4, 4, 20,0,0);
    }
    // Immunité 4 -->  Immunisé face au tour flèche

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