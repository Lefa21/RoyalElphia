package fr.montreuil.iut.RoyalElphia.modele.Tour;


public class TourABombe extends Tour {
    public TourABombe(){
        super(1,1,3,15,7,20);
        setCoutAchat(40);
        setCoutVente(20);
        setCoutAmelioration(15);
        setNiveauMaxAmelioration(6);

    }
}
