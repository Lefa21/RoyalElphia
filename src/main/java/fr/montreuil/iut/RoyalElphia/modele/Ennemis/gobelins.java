package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.AttaquePuissante;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.StrategieAttaque;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class gobelins extends Ennemis {

    private StrategieAttaque sa;

    public gobelins(Terrain terrain) {
        super(terrain, 75, 20, 3, 3, 35,1,5);
        this.sa = new AttaquePuissante();
    }

    @Override
    public void strategieAttaque(Obstacle o) {
        sa.AttaqueEnnemi(getCapaciteObstacle(),getX(),getY(),o);
    }

    // Immunité 3 -->  Immunisé face au tour électrique
    /*public void attaqueEnnemi(Obstacle obstacle){
        if ((getCapaciteObstacle() >= obstacle.getMateriaux() && (getX() / 32 + 1 == obstacle.getPosX() && getY() / 32 == obstacle.getPosY()) || (getX() / 32 == obstacle.getPosX() && getY() / 32 + 1 == obstacle.getPosY()) || (getX() / 32 == obstacle.getPosX() && getY() / 32 - 1 == obstacle.getPosY()) || (getX() / 32 - 1 == obstacle.getPosX() && getY() / 32 == obstacle.getPosY()))) {
            int degat = getDegatObstacle();
            int vieObstacle = obstacle.getPointDeVie() - degat;
            obstacle.setPointDeVie(vieObstacle);
        }
    }
    public void attaqueEnnemis(Obstacle obstacle) {
        int capObstacle = getCapaciteObstacle();
        int x = getX() / 32;
        int y = getY() / 32;
        int obX = obstacle.getPosX();
        int obY = obstacle.getPosY();

        if (capObstacle >= obstacle.getMateriaux() && (x + 1 == obX && y == obY) || (x == obX && y + 1 == obY) || (x == obX && y - 1 == obY) || (x - 1 == obX && y == obY)) {
            int degat = getDegatObstacle();
            int vieObstacle = obstacle.getPointDeVie() - degat;
            obstacle.setPointDeVie(vieObstacle);
        }
    }*/

}
