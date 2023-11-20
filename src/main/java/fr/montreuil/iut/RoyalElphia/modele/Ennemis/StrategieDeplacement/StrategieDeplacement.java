package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesParcourues;

import java.util.LinkedList;

public interface StrategieDeplacement {
    int[] deplacement(CasesParcourues casesParcourues, LinkedList<Cases> chemin);
}
