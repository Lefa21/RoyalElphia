package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Jeu;

public abstract class TourDecorator extends Tour {
    protected Tour tour;

    public TourDecorator(Tour tour) {
        super();
        this.tour = tour;
    }

    public String getChemin() {
        return null;
    }
    public abstract void ameliorationTour(Jeu jeu);
}

