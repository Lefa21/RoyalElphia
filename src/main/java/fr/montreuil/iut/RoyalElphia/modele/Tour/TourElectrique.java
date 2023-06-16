package fr.montreuil.iut.RoyalElphia.modele.Tour;

public class TourElectrique extends Tour {

    public TourElectrique() {
       super(3,3,15);
        setCoutAchat(40);
        setCoutVente(30);
        setCoutAmelioration(35);
        setNiveauMaxAmelioration(3);
    }

}
