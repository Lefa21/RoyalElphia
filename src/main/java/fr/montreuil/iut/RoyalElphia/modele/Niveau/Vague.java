package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import java.util.LinkedList;


public class Vague {

    protected LinkedList<Ennemis> listeEnnemis;

    public Vague() {
        this.listeEnnemis = new LinkedList<>();
    }
    public LinkedList<Ennemis> getListeEnnemis() {
        return listeEnnemis;
    }
}