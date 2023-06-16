package fr.montreuil.iut.RoyalElphia.modele.Tour;


public class TourBouleDeFeu extends Tour {

    public TourBouleDeFeu() {
        super(3,2,10);
        setCoutAchat(30);
        setCoutVente(20);
        setCoutAmelioration(15);
        setNiveauMaxAmelioration(4);
    }
}
