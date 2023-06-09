package fr.montreuil.iut.RoyalElphia.modele.Tour;

import javafx.scene.layout.Pane;

public class TourElectrique extends Tour {

    public TourElectrique() {
       super(2,3,2,8,7,15);
        setCoutAchat(60);
        setCoutVente(30);
        setCoutAmelioration(25);
        setNiveauMaxAmelioration(8);
    }

}
