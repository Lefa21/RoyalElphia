package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;
import javafx.beans.property.SimpleIntegerProperty;

public class TourABombe extends Tour {
    public TourABombe(){
        super(1,1,3,15,7,20);
        setCoutAchat(40);
        setCoutVente(20);
        setCoutAmelioration(15);
        setNiveauMaxAmelioration(6);
    }
}
