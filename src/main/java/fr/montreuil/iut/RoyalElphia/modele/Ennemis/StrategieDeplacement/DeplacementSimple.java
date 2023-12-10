package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesParcourues;

import java.util.LinkedList;

public class DeplacementSimple implements StrategieDeplacement{
    @Override
    public int[] deplacement(CasesParcourues casesParcourues, LinkedList<Cases> chemin) {
        int[] tab = new int[2];
        Cases cases = chemin.pollLast();
        tab[0] = (cases.getY()*32)+16;
        tab[1] = (cases.getX()*32)+16;
        casesParcourues.ajouterCase(new Cases(tab[0],tab[1]));
        return tab;
    }

    @Override
    public String toString() {
        return "DeplacementSimple";
    }
}
