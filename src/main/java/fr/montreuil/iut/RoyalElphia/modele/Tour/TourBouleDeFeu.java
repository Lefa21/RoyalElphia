package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.scene.layout.Pane;


public class TourBouleDeFeu extends Tour {

    public TourBouleDeFeu() {
        super(4,0,3,4,7,50);
        setCoutAchat(22);
        setCoutVente(10);
        setCoutAmelioration(7);
        setNiveauMaxAmelioration(6);
    }
}
