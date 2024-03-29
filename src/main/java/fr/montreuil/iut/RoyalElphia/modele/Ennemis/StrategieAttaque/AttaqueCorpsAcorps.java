package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque;

import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class AttaqueCorpsAcorps implements StrategieAttaque{
    @Override
    public void AttaqueEnnemi( int dx, int dy, Obstacle obstacle) {
        int x = dx / 32;
        int y = dy / 32;
        int obX = obstacle.getPosX();
        int obY = obstacle.getPosY();

        if ( (x + 1 == obX && y == obY) || (x == obX && y + 1 == obY) || (x == obX && y - 1 == obY) || (x - 1 == obX && y == obY)) {
            int degat = 1;
            int vieObstacle = obstacle.getPointDeVie() - degat;
            obstacle.setPointDeVie(vieObstacle);
        }
    }
}
