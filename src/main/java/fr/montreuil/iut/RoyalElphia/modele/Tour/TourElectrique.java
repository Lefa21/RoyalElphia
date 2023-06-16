package fr.montreuil.iut.RoyalElphia.modele.Tour;

public class TourElectrique extends Tour {

    public TourElectrique() {
       super(3,3,15);
        setCoutAchat(30);
        setCoutVente(20);
        setCoutAmelioration(15);
        setNiveauMaxAmelioration(3);
    }

}
