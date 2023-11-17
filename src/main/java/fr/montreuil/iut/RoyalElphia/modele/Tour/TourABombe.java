package fr.montreuil.iut.RoyalElphia.modele.Tour;

public class TourABombe extends Tour {

    public TourABombe(){
        super(1,1,25, null); //La strategie ici est null puisque nos strategie existante ne permettent pas l'amélioration des tours
        setCoutAchat(60);                                    //hors nous avions besoin de les tester
        setCoutVente(40);
        setCoutAmelioration(30);
        setNiveauMaxAmelioration(3);
    }

    public String getChemin() {
        return "src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTour/TourBombeM.png";
    }

    @Override
    public void strategieAttaque(Tour T) {

    }
}


