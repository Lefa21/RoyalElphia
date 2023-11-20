package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class AttaqueDistance implements StrategieAttaque{

    public void AttaqueEnnemi(int capacite, int dx, int dy, Obstacle obstacle) {
        int capObstacle = capacite;
        int x = dx / 32;
        int y = dy / 32;
        int obX = obstacle.getPosX();
        int obY = obstacle.getPosY();

        if (capObstacle >= obstacle.getMateriaux() && (x + 3 >= obX && y == obY) || (x == obX && y + 3 >= obY) || (x == obX && y - 3 <= obY) || (x - 3 <= obX && y == obY)) {
            int degat = 2;
            int vieObstacle = obstacle.getPointDeVie() - degat;
            obstacle.setPointDeVie(vieObstacle);
        }
    }
}


