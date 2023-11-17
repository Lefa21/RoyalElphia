package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

import fr.montreuil.iut.RoyalElphia.modele.Jeu;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;

public class AmeliorationPVObstacle extends ObstacleDecorateur {
    public AmeliorationPVObstacle(Obstacle obstacle) {
        super(obstacle);
    }
    public void ameliorationObstacle(Jeu jeu) {
        obstacle.ameliotation(jeu);
    }
    @Override
    public void strategieAttaque(Tour T) {

    }
}