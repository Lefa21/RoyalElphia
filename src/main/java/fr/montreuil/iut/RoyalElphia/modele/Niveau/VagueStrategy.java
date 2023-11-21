package fr.montreuil.iut.RoyalElphia.modele.Niveau;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

public interface VagueStrategy {
    void créerEnnemis(Vague vague, int nbEnnemi, Terrain terrain);
}