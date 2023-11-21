package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import fr.montreuil.iut.RoyalElphia.modele.FabriqueEnnemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import java.util.LinkedList;

public class Vague {
    protected LinkedList<Ennemis> listeEnnemis;
    protected VagueStrategy vagueStrategy;

    public Vague(VagueStrategy vagueStrategy) {
        this.listeEnnemis = new LinkedList<>();
        this.vagueStrategy = vagueStrategy;
    }

    public LinkedList<Ennemis> getListeEnnemis() {
        return listeEnnemis;
    }

    public void créerVague(int nbEnnemi, Terrain terrain) {
        vagueStrategy.créerEnnemis(this, nbEnnemi, terrain);
    }
}