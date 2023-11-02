package fr.montreuil.iut.RoyalElphia.modele.Tour;


import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.AttaqueRecharge;
import fr.montreuil.iut.RoyalElphia.modele.jeu;

public class TourABombe extends Tour {

    private int nbTourEnCours;
    public TourABombe(int nbTourEnCours){
        super(1,1,25, new AttaqueRecharge());
        setCoutAchat(60);
        setCoutVente(40);
        setCoutAmelioration(30);
        setNiveauMaxAmelioration(3);
        this.nbTourEnCours = nbTourEnCours;
    }
}


