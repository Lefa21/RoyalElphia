package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class AttaqueEnFonctionDeLaBase implements StrategieAttaque{

        private Cases base;

        public void AttaqueEnnemi(int capacite, int dx, int dy, Obstacle obstacle) {
            int capObstacle = capacite;
            int x = dx / 32;
            int y = dy / 32;
            int obX = obstacle.getPosX();
            int obY = obstacle.getPosY();
            //Coordonnes base
            int baseX = base.getX();
            int baseY = base.getY();

            // Plus l'ennemi est proche de la base, plus il inflige de dégâts à l'obstacle
            if ((((baseX - x) <= 10) && ((baseY - y) >= -6)) && ((x + 6 >= obX && y == obY) || (x == obX && y + 6 >= obY) || (x == obX && y - 6 <= obY) || (x - 6 <= obX && y == obY))) {
                int degat = 8;
                obstacle.setPointDeVie(obstacle.getPointDeVie() - degat);
            } else if (capObstacle >= obstacle.getMateriaux() && (x + 6 >= obX && y == obY) || (x == obX && y + 6 >= obY) || (x == obX && y - 6 <= obY) || (x - 6 <= obX && y == obY)) {
                int degat = 5; // Dégâts normaux à l'obstacle dans les autres cas
                obstacle.setPointDeVie(obstacle.getPointDeVie() - degat);
            }
        }

    public void setBase(Cases base) {
        this.base = base;
    }
}
