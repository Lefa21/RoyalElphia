package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesParcourues;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

import java.util.LinkedList;

public interface StrategieDeplacement {
    public int[] deplacement(CasesParcourues casesParcourues, LinkedList<Cases> chemin, Terrain terrain);
}
