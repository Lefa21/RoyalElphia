package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;

public class TourFleche extends Tour {

    public TourFleche() {
        super(6,4,3,9,5,25);
        setCoutAchat(20);
        setCoutVente(13);
        setCoutAmelioration(6);
        setNiveauMaxAmelioration(4);

    }
}
