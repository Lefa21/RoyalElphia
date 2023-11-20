package fr.montreuil.iut.RoyalElphia.modele.Map;

import fr.montreuil.iut.RoyalElphia.modele.Direction;

import java.util.ArrayList;
import java.util.LinkedList;

public class Terrain {
    protected int[][] Tabterrain;
    private Cases pointDep, pointArv;

    private ArrayList<CasesDegats> casesDegats;
    private CasesParcourues casesParcourues;


    public Terrain() {
        this.casesDegats = new ArrayList<>();
        this.casesParcourues = new CasesParcourues();
    }

    public void ajouterCaseDegat(CasesDegats c) {
        this.casesDegats.add(c);
    }

    public ArrayList<CasesDegats> getCasesDegats() {
        return this.casesDegats;
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

        // Méthode qui permet de vérifier si l'ennemi est arrivé à la base du joueur
        /*
        On multiplie par 32 pour faire correspondre la position sur le tableau terrain à celle sur la map
        et on ajout 16 pour atteindre le centre
        */
        return x >= pointArv.getX() * 32 + 16 && y >= pointArv.getY() * 32 + 16;
    }


    public void calculChemin() {
        int i = this.pointDep.getY();
        int j = this.pointDep.getX();

        while (Tabterrain[i][j] != 2) {

            if (verifDimension(i, Direction.Bas)) {
                Cases c = creerCase(i, j, Direction.Bas);
                if (verifCasesParcEtValeur(c)) {
                    i = ajoutCase(c,Direction.Bas,i);
                }
            }
            if (verifDimension(i, Direction.Haut)) {
                Cases c = creerCase(i, j, Direction.Haut);
                if (verifCasesParcEtValeur(c)) {
                    i = ajoutCase(c,Direction.Haut,i);
                }
            }
            if (verifDimension(j, Direction.Droite)) {
                Cases c = creerCase(i, j, Direction.Droite);
                if (verifCasesParcEtValeur(c)) {
                    j = ajoutCase(c,Direction.Droite,j);
                }
            }
            if (verifDimension(j, Direction.Gauche)) {
                Cases c = creerCase(i, j, Direction.Gauche);
                if (verifCasesParcEtValeur(c)) {
                    j = ajoutCase(c,Direction.Gauche,j);
                }
            }
        }
    }

    // Méthode qui permet de créer une case en fonction de la case
    public Cases creerCase(int i, int j, Direction d) {
        Cases c;
        if (d == Direction.Droite) {
            c = new Cases(i, j + 1, Tabterrain[i][j + 1]);
        } else if (d == Direction.Bas) {
            c = new Cases(i + 1, j, Tabterrain[i + 1][j]);
        } else if (d == Direction.Gauche) {
            c = new Cases(i, j - 1, Tabterrain[i][j - 1]);
        } else {
            c = new Cases(i - 1, j, Tabterrain[i - 1][j]);
        }
        return c;
    }

    // Méthode qui permet de vérifier si les indices ne sortent pas des limites du tableau
    public boolean verifDimension(int x, Direction d) {
        boolean verif = false;
        if (d == Direction.Droite) {
            if (x + 1 < 40)
                verif = true;
        } else if (d == Direction.Bas) {
            if (x + 1 < 30)
                verif = true;
        } else if (d == Direction.Gauche || d == Direction.Haut) {
            if (x - 1 > -1)
                verif = true;
        }
        return verif;
    }

    public boolean verifCasesParcEtValeur(Cases c) {
        return !casesParcourues.verif(c) && (c.getValeur() == 9) || (c.getValeur() == 2);
    }

    // Méthode qui s'occupe d'ajouter une case au chemin en fonction de sa direction
    public int ajoutCase(Cases c, Direction d, int x) {
        int retour;
        casesParcourues.ajouterCase(c);
        if (d==Direction.Bas || d==Direction.Droite)
            retour = x+1;
        else
            retour = x-1;
        return retour;
    }

    public LinkedList<Cases> getChemin() {
        return this.casesParcourues.getCasesParcourues();
    }

    public void setChemin() {
        calculChemin();
    }
}