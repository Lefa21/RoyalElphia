package fr.montreuil.iut.RoyalElphia.modele.Tour;

public class TourLaser extends Tour {

    public TourLaser() {
        super(2, 5,1800);
        setCoutAchat(50);
        setCoutVente(40);
        setCoutAmelioration(35);
        setNiveauMaxAmelioration(3);
    }
}
