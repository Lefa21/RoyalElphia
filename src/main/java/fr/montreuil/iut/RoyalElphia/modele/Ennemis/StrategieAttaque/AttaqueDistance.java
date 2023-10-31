package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class AttaqueDistance implements StrategieAttaque{

    public void AttaqueEnnemi(int capacite, int dx, int dy, Obstacle obstacle, Ennemis e) {
        int capObstacle = capacite;
        int x = dx / 32;
        int y = dy / 32;
        int obX = obstacle.getPosX();
        int obY = obstacle.getPosY();

        if (capObstacle >= obstacle.getMateriaux() && (x + 6 >= obX && y == obY) || (x == obX && y + 6 >= obY) || (x == obX && y - 6 <= obY) || (x - 6 <= obX && y == obY)) {
            int degat = 5;
            int vieObstacle = obstacle.getPointDeVie() - degat;
            obstacle.setPointDeVie(vieObstacle);
        }
    }
}


