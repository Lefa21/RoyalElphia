package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;

public class TourLaser extends Tour {

    public TourLaser() {
        super(2,5,2,4,8,40);
        setCoutAchat(60);
        setCoutVente(35);
        setCoutAmelioration(15);
        setNiveauMaxAmelioration(6);
    }


}
