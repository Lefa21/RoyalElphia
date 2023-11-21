package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Jeu;

public class AmeliorationDegatTour extends TourDecorator {
    public AmeliorationDegatTour(Tour tour) {
        super(tour);
    }
    public void ameliorationTour(Jeu jeu) {
        tour.ameliorationTour(jeu);
        if (tour.isPoison()){
            tour.ameliorerDegat();
        }
        if (!tour.isPoison()){
            tour.activerPoison();
        }
        jeu.miseAJourCasesDegats();

    }

    @Override
    public void strategieAttaque(Tour T) {

    }

}