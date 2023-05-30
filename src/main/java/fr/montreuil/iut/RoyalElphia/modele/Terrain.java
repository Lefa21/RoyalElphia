package fr.montreuil.iut.RoyalElphia.modele;

import java.util.ArrayList;

public class Terrain {
    private int hauteur;
    private int largeur;
    private int[][] Tabterrain;
    private Cases pointDep, pointArv;

    public Terrain(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.Tabterrain = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1}
        };
        this.pointDep = calculPointDep();
        this.pointArv = calculPointArv();
    }

    public int[][] getTabTerrain(){
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
    public Cases getPointArv() {
        return this.pointArv;
    }

    private Cases calculPointDep() {
        // On créé une première case pour faire fonctionner la boucle
        Cases c = new Cases(0,0);

        // On cherche à l'aide d'une boucle la case du tableau qui correspond au point de départ
        for (int i = 0; i < this.getTabTerrain().length ; i++) {
            for (int j = 0; j < this.getTabTerrain()[i].length ; j++) {
                if (this.getTabTerrain()[i][j]==2)
                    // On inverse le i et le j pour mettre en relation la position du tableau et la positon sur la map
                    c = new Cases(j,i);
            }
        }
        return c;
    }

    private Cases calculPointArv() {
        // On créé une première case pour faire fonctionner la boucle
        Cases c = new Cases(0,0);

        // On cherche à l'aide d'une boucle la case du tableau qui correspond au point de départ
        for (int i = 0; i < this.getTabTerrain().length ; i++) {
            for (int j = 0; j < this.getTabTerrain()[i].length ; j++) {
                if (this.getTabTerrain()[i][j]==3)
                    // On inverse le i et le j pour mettre en relation la position du tableau et la positon sur la map
                    c = new Cases(j,i);
            }
        }
        System.out.println(c.getX()+" "+c.getY());
        return c;
    }

    /*private Cases calculPointDep() {
        int i = 0; int j = 0;
        Cases c = new Cases(0,0);
        while (i < this.getTabTerrain().length) {
            while (j < this.getTabTerrain()[i].length) {
                if (this.getTabTerrain()[i][j] == 2)
                    c = new Cases(j, i);
                j++;
            }
            i++;
        }
        return c;
    }*/


}