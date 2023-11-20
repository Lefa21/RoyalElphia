package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque;

import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public class AttaqueEnFonctionDeLaBase implements StrategieAttaque{


        public void AttaqueEnnemi( int dx, int dy, Obstacle obstacle) {
            int x = dx / 32;
            int y = dy / 32;
            int obX = obstacle.getPosX();
            int obY = obstacle.getPosY();
            //Coordonnes base
            int baseX = 39;
            int baseY = 3;

            // Plus l'ennemi est proche de la base, plus il inflige de dégâts à l'obstacle
            if ((((baseX - x) <= 10) && ((baseY - y) >= -6)) && ((x + 6 >= obX && y == obY) || (x == obX && y + 6 >= obY) || (x == obX && y - 6 <= obY) || (x - 6 <= obX && y == obY))) {
                int degat = 5;
                obstacle.setPointDeVie(obstacle.getPointDeVie() - degat);
            } else if ((x + 6 >= obX && y == obY) || (x == obX && y + 6 >= obY) || (x == obX && y - 6 <= obY) || (x - 6 <= obX && y == obY)) {
                int degat = 3; // Dégâts normaux à l'obstacle dans les autres cas
                obstacle.setPointDeVie(obstacle.getPointDeVie() - degat);
            }
        }

}
