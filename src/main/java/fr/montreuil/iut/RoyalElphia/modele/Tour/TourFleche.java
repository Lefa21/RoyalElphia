package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.AttaqueRecharge;

public class TourFleche extends Tour {

    public TourFleche() {
        super(5,4,500, new AttaqueRecharge());
        setCoutAchat(20);
        setCoutVente(10);
        setCoutAmelioration(5);
        setNiveauMaxAmelioration(5);
    }
}
