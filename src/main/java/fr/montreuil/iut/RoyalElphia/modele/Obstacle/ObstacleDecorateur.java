package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

import fr.montreuil.iut.RoyalElphia.modele.Jeu;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;

public abstract class ObstacleDecorateur extends Obstacle {
    protected Obstacle obstacle;

    public ObstacleDecorateur(Obstacle obstacle) {
        super();
        this.obstacle = obstacle;
    }

    public String getChemin() {
        return null;
    }
    public abstract void ameliorationObstacle(Jeu jeu);

    public abstract void strategieAttaque(Tour T);
}

