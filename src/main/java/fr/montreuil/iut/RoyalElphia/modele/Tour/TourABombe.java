package fr.montreuil.iut.RoyalElphia.modele.Tour;


public class TourABombe extends Tour {
    public TourABombe(){
        super(1,1,25);
        setCoutAchat(100);
        setCoutVente(80);
        setCoutAmelioration(50);
        setNiveauMaxAmelioration(3);
    }
}
