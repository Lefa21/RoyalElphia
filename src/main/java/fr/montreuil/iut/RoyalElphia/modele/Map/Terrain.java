package fr.montreuil.iut.RoyalElphia.modele.Map;

import java.util.ArrayList;

public abstract class Terrain {
    private int hauteur;
    private int largeur;
    private int[][] Tabterrain;
    private Cases pointDep, pointArv;

    private ArrayList<CasesDégats> casesDégats;

    public Terrain() {
        this.casesDégats = new ArrayList<CasesDégats>();
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

    public int getWidth() {
        return largeur;
    }

    public int getHeight() {
        return hauteur;
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

    public Cases getPointArv() {
        return this.pointArv;
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
        if (x == pointArv.getX() * 32 + 16 && y == pointArv.getY() * 32 + 16)
            verif = true;
        return verif;
    }
}