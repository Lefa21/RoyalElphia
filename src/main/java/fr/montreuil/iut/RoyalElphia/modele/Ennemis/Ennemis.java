package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesParcourues;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemis {

    private IntegerProperty xProperty, yProperty;
    // private int vitesse; // vitesse de deplacement
    protected Terrain terrain;
    public static int compteur = 0;
    private String id;
    private int ptsDefense, Immunite, degatBase, butin;
    private IntegerProperty pv;

    //private Capacite capacite;

    private CasesParcourues casesParcourues;
    private int degatObstacle;

    public Ennemis(Terrain terrain, int pv, int ptsDefense, int immunite, int degatBase, int butin) {
        this.id = "" + compteur;
        this.casesParcourues = new CasesParcourues();
        this.Immunite = immunite;
        this.degatBase = degatBase;
        this.ptsDefense = ptsDefense;
        this.pv = new SimpleIntegerProperty(pv);
        this.butin = butin;
        this.degatObstacle = 15;
        compteur++;
        this.terrain = terrain;

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

    public final void setPv(int x) {
        if (getPv() - x < 0)
            this.pv.setValue(0);
        else
            this.pv.setValue(this.getPv() - x);
    }

    public int getDegatObstacle() {
        return degatObstacle;
    }

    public IntegerProperty getPvProperty() {
        return this.pv;
    }

    public int getPtsDefense() {
        return ptsDefense;
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


    public final void setY(int n) {
        yProperty.setValue(n);
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

    public boolean peutSeDeplacer(int i, String s) {
        boolean retour = false;
        if (i == 1) {
            if (!casesParcourues.verif(CasesDirection(s)) && tabDirection(s) == 9)
                retour = true;
        } else if (i == 2) {
            if (!casesParcourues.verif(CasesDirection(s)) && tabDirection(s) == 2)
                retour = true;
        }
        return retour;
    }

    public Cases CasesDirection(String s) {
        Cases c = null;
        if (s.equals("DROITE"))
            c = new Cases(this.getX() + 32, this.getY());
        else if (s.equals("BAS"))
            c = new Cases(this.getX(), this.getY() + 32);
        else if (s.equals("GAUCHE"))
            c = new Cases(this.getX() - 32, this.getY());
        else if (s.equals("HAUT"))
            c = new Cases(this.getX(), this.getY() - 32);
        return c;
    }

    public int tabDirection(String s) {
        int retour = 0;
        if (s.equals("DROITE"))
            retour = terrain.getTabTerrain()[this.getY() / 32][(this.getX() / 32) + 1];
        else if (s.equals("BAS"))
            retour = terrain.getTabTerrain()[(this.getY() / 32) + 1][this.getX() / 32];
        else if (s.equals("GAUCHE"))
            retour = terrain.getTabTerrain()[this.getY() / 32][(this.getX() / 32) - 1];
        else if (s.equals("HAUT"))
            retour = terrain.getTabTerrain()[(this.getY() / 32) - 1][this.getX() / 32];
        return retour;
    }

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
}


