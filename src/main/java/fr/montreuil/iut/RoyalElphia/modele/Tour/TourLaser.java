package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.AttaqueEvolutive;

public class TourLaser extends Tour {

    public TourLaser() {

        super(2, 5,18, new AttaqueEvolutive());
        setCoutAchat(2);
        setCoutVente(40);
        setCoutAmelioration(35);
        setNiveauMaxAmelioration(3);
    }

    public String getChemin() {
        return "src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTour/TourLaserView.png";
    }
}
