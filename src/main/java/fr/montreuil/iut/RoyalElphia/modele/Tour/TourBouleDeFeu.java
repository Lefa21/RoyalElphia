package fr.montreuil.iut.RoyalElphia.modele.Tour;


public class TourBouleDeFeu extends Tour {

    public TourBouleDeFeu() {
        super(3,2,10);
        setCoutAchat(30);
        setCoutVente(35);
        setCoutAmelioration(25);
        setNiveauMaxAmelioration(4);
    }
}
