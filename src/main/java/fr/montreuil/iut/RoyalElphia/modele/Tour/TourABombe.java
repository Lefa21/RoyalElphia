package fr.montreuil.iut.RoyalElphia.modele.Tour;


import fr.montreuil.iut.RoyalElphia.modele.jeu;

public class TourABombe extends Tour {

    private int nbTourEnCours;
    public TourABombe(int nbTourEnCours){
        super(1,1,25);
        setCoutAchat(60);
        setCoutVente(40);
        setCoutAmelioration(30);
        setNiveauMaxAmelioration(3);
        this.nbTourEnCours = nbTourEnCours;
    }

    public void tourTemporaire(int nbTour){
        if (nbTour == nbTourEnCours + 25)
        setDegat(0);
    }
}


