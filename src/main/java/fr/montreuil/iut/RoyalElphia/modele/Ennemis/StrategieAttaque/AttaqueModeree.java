package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class AttaqueModeree implements StrategieAttaque{
    @Override
    public void AttaqueEnnemi(int capacite, int dx, int dy, Obstacle obstacle, Ennemis e) {
        int capObstacle = capacite;
        int x = dx / 32;
        int y = dy / 32;
        int obX = obstacle.getPosX();
        int obY = obstacle.getPosY();

        if (capObstacle >= obstacle.getMateriaux() && (x + 1 == obX && y == obY) || (x == obX && y + 1 == obY) || (x == obX && y - 1 == obY) || (x - 1 == obX && y == obY)) {
            int degat = 7;
            int vieObstacle = obstacle.getPointDeVie() - degat;
            obstacle.setPointDeVie(vieObstacle);
        }
    }
}
