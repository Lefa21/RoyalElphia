package fr.montreuil.iut.RoyalElphia.modele.Tour;


import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.AttaqueEvolutive;

public class TourBouleDeFeu extends Tour {

    public TourBouleDeFeu() {
        super(3,2,10, new AttaqueEvolutive());
        setCoutAchat(30);
        setCoutVente(20);
        setCoutAmelioration(15);
        setNiveauMaxAmelioration(4);
    }
}
