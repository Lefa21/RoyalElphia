package fr.montreuil.iut.RoyalElphia.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public  abstract class Ennemis {

    private IntegerProperty xProperty, yProperty;
   // private int vitesse; // vitesse de deplacement
    protected Terrain terrain;
    public static int compteur = 0;
    private String id;
    private int pv, ptsDefense,Immunite,degatBase,butin;

    //private Capacite capacite;

    private CasesParcourues casesParcourues;

    public Ennemis (Terrain terrain,int pv, int ptsDefense,int immunite,int degatBase, int butin){
        this.id = "" + compteur;
        this.casesParcourues = new CasesParcourues();
        this.Immunite = immunite;
        this.degatBase =  degatBase;
        this.ptsDefense = ptsDefense;
        this.pv=pv;
        this.butin = butin;
        compteur++;
        this.terrain = terrain;

        // On multiplie par 32 la case de départ du terrain, pour adapter les dimensions du tableau aux dimensions du terrains et on ajoute 16 pour mettre l'ennemi au centre de la case
        this.xProperty = new SimpleIntegerProperty(terrain.getPointDep().getX() * 32 + 16);
        this.yProperty = new SimpleIntegerProperty(terrain.getPointDep().getY() * 32 + 16);

    }



    public String getId() {
        return id;
    }

    public int getPv() {
        return pv;
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


    public final void setX ( int n){
            xProperty.setValue(n);
        }

        public final int getY () {
            return yProperty.getValue();
        }

        public final IntegerProperty getyProperty () {
            return yProperty;
        }


        public final void setY ( int n){
            yProperty.setValue(n);
        }

        public void seDeplace () {
            // On récupère le tableau du terrain
            int tab[][] = terrain.getTabTerrain();


                    // On ajoute la case ou se situe l'ennemi à sa liste cases parcourues

            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));

            // On vérifie si la case à droite de l'ennemi est dans sa liste de case parcourue et on vérifie après si la case est un chemin ou la base
            if (!casesParcourues.verif(this.getX() + 32, this.getY()) && tab[this.getY() / 32][(this.getX() / 32) + 1] == 9 || !casesParcourues.verif(this.getX() + 32, this.getY()) && tab[this.getY() / 32][(this.getX() / 32) + 1] == 2) {
                this.setX(this.getX() + 32);
                casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
            }

            // On vérifie si la case en dessous de l'ennemi est dans sa liste de case parcourue et on vérifie après si la case est un chemin ou la base
            else if (!casesParcourues.verif(this.getX(), this.getY() + 32) && tab[(this.getY() / 32) + 1][(this.getX() / 32)] == 9 || !casesParcourues.verif(this.getX(), this.getY() + 32) && tab[(this.getY() / 32) + 1][(this.getX() / 32)] == 2) {
                this.setY(this.getY() + 32);
                casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
            }

            // On vérifie si la case à gauche de l'ennemi est dans sa liste de case parcourue et on vérifie après si la case est un chemin ou la base
            else if (!casesParcourues.verif(this.getX() - 32, this.getY()) && tab[(this.getY() / 32)][(this.getX() / 32) - 1] == 9 || !casesParcourues.verif(this.getX() - 32, this.getY()) && tab[(this.getY() / 32)][(this.getX() / 32) - 1] == 2) {
                this.setX(this.getX() - 32);
                casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
            }

            // On vérifie si la case au dessus de l'ennemi est dans sa liste de case parcourue et on vérifie après si la case est un chemin ou la base
            else if (!casesParcourues.verif(this.getX(), this.getY() - 32) && tab[(this.getY() / 32) - 1][this.getX() / 32] == 9 || !casesParcourues.verif(this.getX(), this.getY() - 32) && tab[(this.getY() / 32) - 1][this.getX() / 32] == 2) {
                this.setY(this.getY() - 32);
                casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
            }

        }
    }


