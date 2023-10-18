package fr.montreuil.iut.RoyalElphia.modele.Map;

import java.util.ArrayList;

public class Terrain {
    protected int[][] Tabterrain;
    private Cases pointDep, pointArv;

    private ArrayList<CasesDégats> casesDégats;

    public Terrain() {
        this.casesDégats = new ArrayList<>();
    }

    public void ajouterCaseDegat(CasesDégats c) {
        this.casesDégats.add(c);
    }

    public ArrayList<CasesDégats> getCasesDégats() {
        return this.casesDégats;
    }

    public int[][] getTabTerrain() {
        return this.Tabterrain;
    }

    public Cases getPointDep() {
        return this.pointDep;
    }

    public void setPointDep(Cases pointDep) {
        this.pointDep = pointDep;
    }

    public void setTabterrain(int[][] tabterrain) {
        Tabterrain = tabterrain;
    }

    public void setPointArv(Cases pointArv) {
        this.pointArv = pointArv;
    }

    public Cases calculPointDep() {
        // On créé une première case pour faire fonctionner la boucle
        Cases c = new Cases(0, 0);

        // On cherche à l'aide d'une boucle la case du tableau qui correspond au point de départ
        for (int i = 0; i < this.getTabTerrain().length; i++) {
            for (int j = 0; j < this.getTabTerrain()[i].length; j++) {
                // Dans le tableau terrain la valeur de la case de départ est 1
                if (this.getTabTerrain()[i][j] == 1)
                    // On inverse le i et le j pour mettre en relation la position du tableau et la positon sur la map
                    c = new Cases(j, i);
            }
        }
        return c;
    }

    public Cases calculPointArv() {
        // On créé une première case pour faire fonctionner la boucle
        Cases c = new Cases(0, 0);

        // On cherche à l'aide d'une boucle la case du tableau qui correspond au point de départ
        for (int i = 0; i < this.getTabTerrain().length; i++) {
            for (int j = 0; j < this.getTabTerrain()[i].length; j++) {
                // Dans le tableau terrain la valeur de la case d'arrivée est 2
                if (this.getTabTerrain()[i][j] == 2)
                    // On inverse le i et le j pour mettre en relation la position du tableau et la positon sur la map
                    c = new Cases(j, i);
            }
        }
        return c;
    }

    public boolean verifPArv(int x, int y) {
        boolean verif = false;

        // Méthode qui permet de vérifier si l'ennemi est arrivé à la base du joueur
        /*
        On multiplie par 32 pour faire correspondre la position sur le tableau terrain à celle sur la map
        et on ajout 16 pour atteindre le centre
        */
        if (x >= pointArv.getX() * 32 + 16 && y >= pointArv.getY() * 32 + 16)
            verif = true;
        return verif;
    }
}