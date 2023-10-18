package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque;

import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;

public interface StrategieAttaque {
    public void AttaqueEnnemi(int capacite, int dx, int dy, Obstacle obstacle);

}
