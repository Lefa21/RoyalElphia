package fr.montreuil.iut.RoyalElphia.modele.Tour;

public class TourFleche extends Tour {

    public TourFleche() {
        super(5,4,5);
        setCoutAchat(20);
        setCoutVente(10);
        setCoutAmelioration(10);
        setNiveauMaxAmelioration(5);

        // a chaque amélioration augmenter cout vente de 1.5
    }
}
