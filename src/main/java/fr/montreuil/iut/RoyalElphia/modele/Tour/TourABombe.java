package fr.montreuil.iut.RoyalElphia.modele.Tour;




public class TourABombe extends Tour {

    public TourABombe(){
        super(1,1,25, null);
        setCoutAchat(60);
        setCoutVente(40);
        setCoutAmelioration(30);
        setNiveauMaxAmelioration(3);
    }

    public String getChemin() {
        return "src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTour/TourBombeM.png";
    }
}


