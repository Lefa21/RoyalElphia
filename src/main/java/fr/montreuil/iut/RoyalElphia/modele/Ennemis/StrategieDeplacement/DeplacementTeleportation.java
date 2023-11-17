package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesParcourues;

import java.util.LinkedList;

public class DeplacementTeleportation implements StrategieDeplacement{

    // Se déplacement permet à l'ennemi de sauter une seul fois 10 cases après qu'il ce soit déplacer 20 fois sur la map

    private boolean use = false;
    private int compteur = 0;
    @Override
    public int[] deplacement(CasesParcourues casesParcourues, LinkedList<Cases> chemin) {
        int[] tab = new int[2];
        Cases cases = null;
        if (!use && compteur==20) {
            for (int i = 0; i <= 10; i++) {
                cases = chemin.pollLast();
                casesParcourues.ajouterCase(cases);
            }
            use = true;
        }
        else {
            cases = chemin.pollLast();
            casesParcourues.ajouterCase(cases);
        }

        tab[0] = (cases.getY()*32)+16;
        tab[1] = (cases.getX()*32)+16;

        if (compteur<20) {
            compteur++;
        }
        return tab;
    }
}
