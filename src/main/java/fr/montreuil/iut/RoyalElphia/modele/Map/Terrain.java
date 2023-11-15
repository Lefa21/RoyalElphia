package fr.montreuil.iut.RoyalElphia.modele.Map;

import java.util.ArrayList;
import java.util.LinkedList;

public class Terrain {
    protected int[][] Tabterrain;
    private Cases pointDep, pointArv;

    private ArrayList<CasesDégats> casesDégats;
    private CasesParcourues casesParcourues;


    public Terrain() {
        this.casesDégats = new ArrayList<>();
        this.casesParcourues = new CasesParcourues();
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

    public Cases getPointArv() {
        return pointArv;
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
    /*
    public void testChemin() {
        for (int i = 0; i < chemin.size(); i++) {
            System.out.println("Case :" + (i + 1));
            System.out.println("X = " + chemin.get(i).getX());
            System.out.println("Y = " + chemin.get(i).getY() + "\n");
        }
    }
     */



    public LinkedList<Cases> calculChemin() {
        LinkedList<Cases> chemin = new LinkedList<Cases>();
        int i = this.pointDep.getY();
        int j = this.pointDep.getX();
        while (Tabterrain[i][j] != 2) {
            if ((i + 1 < 30) && !casesParcourues.verif(new Cases(i+1,j,Tabterrain[i+1][j])) && ((Tabterrain[i + 1][j] == 9) || (Tabterrain[i + 1][j] == 2))) {
                Cases c = new Cases(i+1,j,Tabterrain[i+1][j]);
                chemin.addFirst(c);
                casesParcourues.ajouterCase(c);
                i = i + 1;
            } else if ( (i - 1 > -1)  && !casesParcourues.verif(new Cases(i-1,j,Tabterrain[i-1][j])) && ((Tabterrain[i - 1][j] == 9) || (Tabterrain[i - 1][j] == 2))) {
                Cases c = new Cases(i-1,j,Tabterrain[i-1][j]);
                chemin.addFirst(c);
                casesParcourues.ajouterCase(c);
                i = i - 1;
            } else if ((j + 1 < 40) && !casesParcourues.verif(new Cases(i,j+1,Tabterrain[i][j+1])) && ((Tabterrain[i][j + 1] == 9) || (Tabterrain[i][j + 1] == 2))) {
                Cases c = new Cases(i,j+1,Tabterrain[i][j+1]);
                chemin.addFirst(c);
                casesParcourues.ajouterCase(c);
                j = j + 1;
            } else if ((j - 1 > -1) && !casesParcourues.verif(new Cases(i,j-1,Tabterrain[i][j-1])) && ((Tabterrain[i][j - 1] == 9) || ((Tabterrain[i][j - 1] == 2)))) {
                Cases c = new Cases(i,j-1,Tabterrain[i][j-1]);
                chemin.addFirst(c);
                casesParcourues.ajouterCase(c);
                j = j - 1;
            }
        }
        return chemin;
    }


   /* public LinkedList<Cases> calculChemin() {
        LinkedList<Cases> chemin = new LinkedList<Cases>();
        int i = this.pointDep.getY();
        int j = this.pointDep.getX();
        while (Tabterrain[i][j] != 2) {
            if (peutSeDeplacer(1,"BAS",i,j) || peutSeDeplacer(1,"BAS",i,j))  {
                chemin.addFirst(new Cases(i + 1, j));
                i = i + 1;
            } else if (peutSeDeplacer(1,"HAUT",i,j) || peutSeDeplacer(1,"HAUT",i,j)) {
                chemin.addFirst(new Cases(i - 1, j));
                i = i - 1;
            } else if (peutSeDeplacer(1,"DROITE",i,j) || peutSeDeplacer(1,"DROITE",i,j)) {
                chemin.addFirst(new Cases(i, (j + 1)));
                j = j + 1;
            } else if (peutSeDeplacer(1,"GAUCHE",i,j) || peutSeDeplacer(1,"GAUCHE",i,j)) {
                chemin.addFirst(new Cases(i, j - 1));
                j = j - 1;
            }
        }
        return chemin;
    }
*/

    /*
    public boolean peutSeDeplacer(int i, String s, int x, int y) {
        boolean retour = false;
        if (i==1) {
            if (!casesParcourues.verif(CaseDirection(s,x,y)) && tabDirection(s,x,y) == 9)
                retour = true;
        } else if (i == 2) {
            if (!casesParcourues.verif(CaseDirection(s,x,y)) && tabDirection(s,x,y) == 2)
                retour = true;
        }
        return retour;
    }

    public Cases CaseDirection (String s, int x, int y) {
        Cases c = null;
        if (s.equals("DROITE"))
            c = new Cases(x+1,y);
        else if (s.equals("GAUCHE"))
            c = new Cases(x-1,y);
        else if (s.equals("HAUT"))
            c = new Cases(x,y-1);
        else if (s.equals("BAS"))
            c = new Cases(x,y+1);
        return c;
    }

    public int tabDirection(String s, int x,int y) {
        int retour = 0;
        if (s.equals("DROITE") && ((y+1)<30)) {
            retour = Tabterrain[x][y+1];
        } else if (s.equals("GAUCHE") && ((y-1)>-1)){
            retour = Tabterrain[x][y-1];
        } else if (s.equals("HAUT") && ((x-1)>-1)) {
            retour = Tabterrain[x+1][y];
        } else if (s.equals("BAS") && ((x+1)<40)) {
            retour = Tabterrain[x-1][y];
        }
        return retour;
    }
*/
    public LinkedList<Cases> getChemin() {
        return this.casesParcourues.getCasesParcourues();
    }

    public void setChemin(LinkedList<Cases> chemin) {
        this.casesParcourues.setCasesParcourues(chemin);
    }

    /*
    public void seDeplace() {
        // On récupère le tableau du terrain
        int tab[][] = terrain.getTabTerrain();


        // On ajoute la case ou se situe l'ennemi à sa liste cases parcourues

        casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));


        if (peutSeDeplacer(1, "DROITE") || peutSeDeplacer(2, "DROITE")) {
            this.setX(this.getX() + 32);
            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
        }


        else if (peutSeDeplacer(1, "BAS") || peutSeDeplacer(2, "BAS")) {
            this.setY(this.getY() + 32);
            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
        }

        else if (peutSeDeplacer(1, "GAUCHE") || peutSeDeplacer(2, "GAUCHE")) {
            this.setX(this.getX() - 32);
            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
        }

        else if (peutSeDeplacer(1, "HAUT") || peutSeDeplacer(2, "HAUT")) {
            this.setY(this.getY() - 32);
            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
        }
    }

    public boolean peutSeDeplacer(String s, int i, int j) {
        boolean retour = false;


            if (!casesParcourues.verif(CasesDirection(s,i,j)) && tabDirection(s,i,j) == 9)
                retour = true;

        return retour;
    }

    public Cases CasesDirection(String s, int i, int j) {
        Cases c = null;
        if (s.equals("DROITE"))
            c = new Cases(i, j + 1);
        else if (s.equals("BAS"))
            c = new Cases(i + 1, j);
        else if (s.equals("GAUCHE"))
            c = new Cases(i, j - 1);
        else if (s.equals("HAUT"))
            c = new Cases(i - 1, j);
        return c;
    }

    public int tabDirection(String s, int i, int j) {
        // X = j = 40,  Y = i = 30
        int retour = 0;

        if (s.equals("DROITE") && (j + 1) < 40)
            retour = Tabterrain[i][j + 1];
        else if (s.equals("BAS") && (i + 1) < 30)
            retour = Tabterrain[i + 1][j];
        else if (s.equals("GAUCHE") && (j - 1) > -1)
            retour = Tabterrain[i][j - 1];
        else if (s.equals("HAUT") && (i - 1) > -1)
            retour = Tabterrain[i - 1][j];
        return retour;
    }

*/
}