package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesParcourues;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.LinkedList;

public abstract class Ennemis {

    private IntegerProperty xProperty, yProperty;

    protected Terrain terrain;
    public static int compteur = 0;
    private String id;
    private int ptsDefense, Immunite, degatBase, butin, capaciteObstacle;
    private IntegerProperty pv;
    private CasesParcourues casesParcourues;
    private int degatObstacle;

    private LinkedList<Cases> chemin;


    public Ennemis(Terrain terrain, int pv, int ptsDefense, int immunite, int degatBase, int butin, int capaciteObstacle, int degatObstacle) {
        this.id = "" + compteur;
        this.casesParcourues = new CasesParcourues();
        this.Immunite = immunite;
        this.degatBase = degatBase;
        this.ptsDefense = ptsDefense;
        this.pv = new SimpleIntegerProperty(pv);
        this.butin = butin;
        this.capaciteObstacle = capaciteObstacle;
        this.degatObstacle = degatObstacle;
        compteur++;
        this.terrain = terrain;
        this.chemin  = new LinkedList<Cases>(this.terrain.getChemin());

        /* On multiplie par 32 la case de départ du terrain, pour adapter les dimensions du tableau aux dimensions du
         terrains et on ajoute 16 pour mettre l'ennemi au centre de la case*/
        this.xProperty = new SimpleIntegerProperty(terrain.getPointDep().getX() * 32 + 16);
        this.yProperty = new SimpleIntegerProperty(terrain.getPointDep().getY() * 32 + 16);
    }



    public String getId() {
        return id;
    }

    public final int getPv() {
        return pv.getValue();
    }

    public int getPtsDefense() {
        return ptsDefense;
    }

    public void setPv(int degat) {

        // Variable permettant de gérer le taux de dégat que l'ennemi va subir
        double multiplicateur = 1;

        // Si l'attaque de la tour est inférieur à la défense de l'ennemi il subit la moitié des dégats de la tour
        if (degat < this.getPtsDefense())
            multiplicateur = 0.5;

        // On vérifie si les pv de l'ennemi après avoir subit une attaque sont inférieurs à 0
        if (getPv() - (degat * multiplicateur) < 0) {
            this.pv.setValue(0);
        } else {
            this.pv.setValue(this.getPv() - (degat * multiplicateur));
        }
    }

    public void améliorationPv(int pv) {
        this.pv.setValue(pv);
    }

    public int getDegatObstacle() {
        return degatObstacle;
    }

    public IntegerProperty getPvProperty() {
        return this.pv;
    }

    public int getImmunite() {
        return Immunite;
    }

    public int getDegatBase() {
        return degatBase;
    }

    public int getButin() {
        return butin;
    }

    public final int getX() {
        return xProperty.getValue();
    }

    public final IntegerProperty getxProperty() {
        return xProperty;
    }

    public final void setX(int n) {
        xProperty.setValue(n);
    }

    public final int getY() {
        return yProperty.getValue();
    }

    public final IntegerProperty getyProperty() {
        return yProperty;
    }

    public int getCapaciteObstacle() {
        return capaciteObstacle;
    }

    public final void setY(int n) {
        yProperty.setValue(n);
    }

    public void setDegatBase(int degatBase) {
        this.degatBase = degatBase;
    }

    public void setDegatObstacle(int degatObstacle) {
        this.degatObstacle = degatObstacle;
    }

    /*
    public void testCheminE() {
        for (int i = 0; i < chemin.size(); i++) {
            System.out.println("Case :" + (i + 1));
            System.out.println("X = " + chemin.get(i).getX());
            System.out.println("Y = " + chemin.get(i).getY() + "\n");
        }
    }
    */


    public void deplacementV2() {

        Cases cases = chemin.pollLast();
        this.setX((cases.getY() * 32) + 16);
        this.setY((cases.getX() * 32) + 16);

    }

    public void seDeplace() {
        // On récupère le tableau du terrain
        int tab[][] = terrain.getTabTerrain();


        // On ajoute la case ou se situe l'ennemi à sa liste cases parcourues

        casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));

        /* On vérifie si la case à droite de l'ennemi est dans sa liste de case parcourue et on vérifie
        après si la case est un chemin ou la base */
        if (peutSeDeplacer(1, "DROITE") || peutSeDeplacer(2, "DROITE")) {
            this.setX(this.getX() + 32);
            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
        }

        /* On vérifie si la case en dessous de l'ennemi est dans sa liste de case parcourue et on vérifie
        après si la case est un chemin ou la base */
        else if (peutSeDeplacer(1, "BAS") || peutSeDeplacer(2, "BAS")) {
            this.setY(this.getY() + 32);
            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
        }

        /* On vérifie si la case à gauche de l'ennemi est dans sa liste de case parcourue et on vérifie
        après si la case est un chemin ou la base */
        else if (peutSeDeplacer(1, "GAUCHE") || peutSeDeplacer(2, "GAUCHE")) {
            this.setX(this.getX() - 32);
            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
        }

        /* On vérifie si la case au dessus de l'ennemi est dans sa liste de case parcourue et on vérifie
        après si la case est un chemin ou la base */
        else if (peutSeDeplacer(1, "HAUT") || peutSeDeplacer(2, "HAUT")) {
            this.setY(this.getY() - 32);
            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
        }
    }


    /*
    On vérifie avec cette méthode si l'ennemi peut se déplacer sur le terrain
    */
    public boolean peutSeDeplacer(int i, String s) {
        boolean retour = false;
        if (i == 1) {
            /*
            On vérifie d'abord que la case qu'on le souhaite visitée n'a pas déja été parcourue,
            puis si la case du tableau contient une valeur sur laquelle le déplacement est autorisé
            */
            if (!casesParcourues.verif(CasesDirection(s)) && tabDirection(s) == 9)
                retour = true;
        } else if (i == 2) {
            if (!casesParcourues.verif(CasesDirection(s)) && tabDirection(s) == 2)
                retour = true;
        }
        return retour;
    }

    /*
    Cette méthode permet de créer une case qui se situe autour de l'ennemi en fonction d'un paramètre de type String
    */
    public Cases CasesDirection(String s) {
        Cases c = null;
        if (s.equals("DROITE"))
            // On ajoute ou soustrait 32 pour vérifier les cases autour de l'ennemi sur la carte
            c = new Cases(this.getX() + 32, this.getY());
        else if (s.equals("BAS"))
            c = new Cases(this.getX(), this.getY() + 32);
        else if (s.equals("GAUCHE"))
            c = new Cases(this.getX() - 32, this.getY());
        else if (s.equals("HAUT"))
            c = new Cases(this.getX(), this.getY() - 32);
        return c;
    }
    // Tour qui fait changer la strat


    /*
    Cette méthode permet de renvoyer un entier représentant la valeur des cases du tableau terrain se situant
    autour de la position de l'ennemi sur le tableau ,en fonction d'un paramètre de type String
    */
    public int tabDirection(String s) {
        int retour = 0;

        /*
        On vérifie avec la deuxième condition si on ne sort pas du tableau terrain et on divise les positions par
        32 car la position récuperer est celle de la map, et on doit la faire correspondre avec les cases du
        tableau terrain
        */
        if (s.equals("DROITE") && ((this.getX() / 32) + 1) < 40)
            retour = terrain.getTabTerrain()[this.getY() / 32][(this.getX() / 32) + 1];
        else if (s.equals("BAS") && ((this.getY() / 32) + 1) < 30)
            retour = terrain.getTabTerrain()[(this.getY() / 32) + 1][this.getX() / 32];
        else if (s.equals("GAUCHE") && ((this.getX() / 32) - 1) > -1)
            retour = terrain.getTabTerrain()[this.getY() / 32][(this.getX() / 32) - 1];
        else if (s.equals("HAUT") && ((this.getY() / 32) - 1) > -1)
            retour = terrain.getTabTerrain()[(this.getY() / 32) - 1][this.getX() / 32];
        return retour;
    }


    // Méthode permettant de gérer l'affichage de l'immunité aux tours de l'ennemi
    public String affichageImmunité() {
        String affichage = "Cet ennemi est immunisé face aux tours";
        if (this.Immunite == 1) {
            affichage = affichage + " à bombes";
        } else if (this.Immunite == 2) {
            affichage = affichage + " boule de feu";
        } else if (this.Immunite == 3) {
            affichage = affichage + " électriques";
        } else if (this.Immunite == 4) {
            affichage = affichage + " à flèches";
        } else if (this.Immunite == 5) {
            affichage = affichage + " laser";
        }
        return affichage;
    }

    public void setPvZero() {
        this.pv.setValue(0);
    }

    //public abstract void attaqueEnnemi(Obstacle obstacle);
    public abstract void strategieAttaque(Obstacle o);


}


