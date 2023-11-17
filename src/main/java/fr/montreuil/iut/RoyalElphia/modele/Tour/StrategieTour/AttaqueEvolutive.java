package fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour;

import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;

import java.util.ArrayList;

public class AttaqueEvolutive implements StrategieTour {

    private int nbEnnemis;
    private Terrain t;

    private ArrayList<CasesDégats> newCasesDegats = new ArrayList<>();

    public void setNbEnnemis(int nbEnnemis) {
        this.nbEnnemis = nbEnnemis;
    }

    public void setT(Terrain t) {
        this.t = t;
    }

    @Override
    public void attaque(Tour T) {
        if (nbEnnemis > 5 && T.getListeCasesDegats() != null) {
            for (CasesDégats caseDegat : T.getListeCasesDegats()) {
                int x = caseDegat.getX() / 32;
                int y = caseDegat.getY() / 32;

                // Créez de nouvelles cases autour de la case actuelle (ajout d'une case en haut, en bas, à gauche et à droite)
                int portee = 1; // Portée des nouvelles cases
                if (T.getListeCasesDegats().size() < 30) {
                    if ((y - portee) > -1 && (t.getTabTerrain()[y - portee][x] == 9 || t.getTabTerrain()[y - portee][x] == 8)) {
                        CasesDégats c1 = new CasesDégats(x, y - (portee), T.getDegat(), T.getTypeAttaque(), "H", portee);
                        t.ajouterCaseDegat(c1);
                        newCasesDegats.add(c1);
                        c1.getDegatProperty().bind(T.getDegatProperty());
                    }
                    if ((x + portee) < 40 && (t.getTabTerrain()[y][x + (portee)] == 9 || t.getTabTerrain()[y][x + (portee)] == 8)) {
                        CasesDégats c2 = new CasesDégats(x + (portee), y, T.getDegat(), T.getTypeAttaque(), "D", portee);
                        t.ajouterCaseDegat(c2);
                        newCasesDegats.add(c2);
                        c2.getDegatProperty().bind(T.getDegatProperty());
                    }
                    if ((y + portee) < 30 && (t.getTabTerrain()[y + (portee)][x] == 9 || t.getTabTerrain()[y + (portee)][x] == 8)) {
                        CasesDégats c3 = new CasesDégats(x, y + (portee), T.getDegat(), T.getTypeAttaque(), "B", portee);
                        t.ajouterCaseDegat(c3);
                        newCasesDegats.add(c3);
                        c3.getDegatProperty().bind(T.getDegatProperty());
                    }
                    if ((x - portee) > -1 && (t.getTabTerrain()[y][x - (portee)] == 9 || t.getTabTerrain()[y][x - (portee)] == 8)) {
                        CasesDégats c4 = new CasesDégats(x - (portee), y, T.getDegat(), T.getTypeAttaque(), "G", portee);
                        t.ajouterCaseDegat(c4);
                        newCasesDegats.add(c4);
                        c4.getDegatProperty().bind(T.getDegatProperty());
                    }
                }
            }
            // Ajoutez les nouvelles cases créées à la liste existante
            T.getListeCasesDegats().addAll(newCasesDegats);
            T.setDegat(5);
        }
    }
}

