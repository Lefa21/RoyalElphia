package fr.montreuil.iut.RoyalElphia.modele;

import java.util.ArrayList;

public  class Terrain {
    private int hauteur;
    private int largeur;
    private int[][] Tabterrain;
    private Cases pointDep, pointArv;

    public Terrain(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.Tabterrain  = new int[][]{
                {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
                {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
                {4,4,4,4,4,4,4,4,4,4,7,7,7,7,7,7,7,7,7,7,7,7,7,7,4,4,4,4,4,7,7,7,7,7,7,7,7,7,4,4},
                {4,4,4,4,4,4,4,4,4,4,9,9,9,9,9,9,9,9,9,9,9,9,9,7,4,4,4,4,4,7,9,9,9,9,9,9,9,7,4,4},
                {4,4,4,4,4,4,4,4,4,4,9,7,7,7,7,7,7,7,7,7,7,7,9,7,4,4,4,4,4,7,9,7,7,7,7,7,9,7,4,4},
                {3,3,3,3,4,4,8,8,8,8,9,7,4,4,4,4,4,4,4,4,4,7,9,7,4,4,4,4,4,7,9,7,4,4,4,7,9,7,4,4},
                {3,3,3,3,4,4,8,8,8,8,9,7,4,4,4,4,4,4,4,4,4,7,9,4,4,4,4,4,4,7,9,7,4,4,4,7,9,7,4,4},
                {3,10,3,3,4,4,8,8,8,8,9,7,4,4,4,4,4,4,4,4,4,7,9,7,4,4,4,4,4,7,9,7,4,4,4,7,9,7,4,4},
                {1,9,9,9,9,9,9,9,9,9,9,7,4,4,4,4,4,4,4,4,4,7,9,7,7,7,7,7,7,7,9,7,4,4,4,7,9,7,4,4},
                {7,7,7,7,7,7,7,7,7,7,7,7,4,4,4,4,4,4,4,4,4,7,9,9,9,9,9,9,9,9,9,7,4,4,4,7,9,7,4,4},
                {7,7,7,7,7,7,7,7,7,7,4,5,4,4,4,4,4,4,4,4,4,7,7,7,7,7,7,7,7,7,7,7,4,4,4,7,9,7,4,4},
                {5,5,5,5,5,5,5,5,5,5,4,5,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,7,9,7,4,4},
                {3,3,3,3,8,8,3,3,3,3,9,5,4,4,4,4,4,4,7,7,7,7,7,7,7,7,4,4,4,7,7,7,7,7,7,7,9,7,4,4},
                {3,3,3,3,8,8,3,3,3,3,9,5,4,4,4,4,4,4,7,9,9,9,9,9,9,7,4,4,4,7,9,9,9,9,9,9,9,7,4,4},
                {3,3,3,3,8,8,3,3,10,3,9,5,4,4,4,4,4,4,7,9,7,7,7,7,9,7,4,4,4,7,9,7,7,7,7,7,7,7,4,4},
                {3,3,3,3,8,8,3,3,3,3,9,5,4,4,4,4,4,4,7,9,7,4,4,4,9,7,7,7,7,7,9,7,4,4,4,4,4,4,4,4},
                {5,5,5,5,4,4,5,5,5,5,4,4,4,4,4,4,4,4,7,9,7,4,4,7,9,9,9,9,9,9,9,7,4,4,4,4,4,4,4,4},
                {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,7,9,7,4,4,7,7,7,7,7,7,7,7,7,4,4,4,4,4,4,4,4},
                {4,4,4,4,4,4,4,4,7,7,7,7,7,7,7,7,7,7,7,9,7,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},
                {4,4,4,4,4,4,4,4,7,9,9,9,9,9,9,9,9,9,9,9,7,4,4,4,4,4,4,4,4,4,4,4,4,7,7,7,7,7,7,7},
                {4,4,4,4,4,4,4,4,7,9,7,7,7,7,7,7,7,7,7,7,7,4,4,4,4,4,4,4,4,4,4,4,4,7,9,9,9,9,9,7},
                {4,4,4,4,4,4,4,4,7,9,7,4,4,4,4,4,4,4,4,4,4,4,4,4,4,7,7,7,7,7,7,7,4,7,9,7,7,7,9,7},
                { 4,4,7,7,7,7,7,7,7,9,7,4,4,4,4,4,4,4,4,4,4,4,4,4,4,7,9,9,9,9,9,7,4,7,9,7,4,7,9,7},
                {4,4,7,9,9,9,9,9,9,9,7,4,4,4,4,7,7,7,7,7,7,7,7,4,4,7,9,7,7,7,9,7,4,7,9,7,4,7,9,7},
                {4,4,7,9,7,7,7,7,7,7,7,4,4,4,4,7,9,9,9,9,9,9,7,4,4,7,9,7,4,7,9,7,4,7,9,7,4,7,9,7},
                {4,4,7,9,7,4,4,4,4,4,4,4,4,4,4,7,9,7,7,7,7,9,7,4,4,7,9,7,4,7,9,7,4,7,9,7,4,7,9,7},
                {4,4,7,9,7,7,7,7,7,7,7,7,7,7,7,7,9,7,4,4,7,9,7,7,7,7,9,7,4,7,9,7,7,7,9,7,4,7,9,7},
                {4,4,7,9,9,9,9,9,9,9,9,9,9,9,9,9,9,7,4,4,7,9,9,9,9,9,9,7,4,7,9,9,9,9,9,7,4,7,9,4},
                {4,4,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,4,4,7,7,7,7,7,7,7,7,4,7,7,7,7,7,7,7,4,7,9,7},
                {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,7,2,7}};


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
                if (this.getTabTerrain()[i][j]==1)
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
                if (this.getTabTerrain()[i][j]==2)
                    // On inverse le i et le j pour mettre en relation la position du tableau et la positon sur la map
                    c = new Cases(j,i);
            }
        }
        System.out.println(c.getX()+" "+c.getY());
        return c;
    }




}