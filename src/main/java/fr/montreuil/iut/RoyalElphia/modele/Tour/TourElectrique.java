package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.AttaqueRecharge;
import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.StrategieTour;

public class TourElectrique extends Tour {

    public TourElectrique() {
       super(3,3,15, new AttaqueRecharge());
        setCoutAchat(30);
        setCoutVente(20);
        setCoutAmelioration(15);
        setNiveauMaxAmelioration(3);
    }

}
