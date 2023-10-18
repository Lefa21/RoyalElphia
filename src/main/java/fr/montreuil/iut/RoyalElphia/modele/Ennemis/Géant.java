package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class Géant extends Ennemis {

    public Géant(Terrain terrain){
        super(terrain,150,65,2,1,100,3,15);
    }

    // Immunité 2 -->  Immunisé face au tour boule de feu
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
