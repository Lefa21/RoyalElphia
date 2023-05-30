package fr.montreuil.iut.RoyalElphia.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Ennemis {

    private IntegerProperty xProperty, yProperty;
    private int vitesse; // vitesse de deplacement

    // private int dx,dy ;// direction
    protected Terrain terrain;
    public static int compteur = 0;
    private String id;
    private int pv, ptsDefense, Immunité, dégatBase;

    private CasesParcourues casesParcourues;


    /*
    public Ennemis(int x, int y, int v, Terrain terrain, int pv, int ptsDefense, int immunite, int dégatBase) {
        this.pv=pv;
        this.xProperty = new SimpleIntegerProperty(x);
        this.yProperty = new SimpleIntegerProperty(y);
        this.vitesse = v;
        this.terrain = terrain;
        this.id="A"+compteur;
        compteur++;
        this.ptsDefense = ptsDefense;
        this.Immunité = immunite;
        this.dégatBase =  dégatBase;
        this.tirerDirection();
    }
    */


    /*

    public Ennemis(int x, int y, int v, Terrain env, int pv,int ptsDefense,int immunite,int degatDefense) {
        this.pv=pv;
        Random random=new Random();
        this.xProperty = new SimpleDoubleProperty(x);
        this.yProperty = new SimpleDoubleProperty(y);
        this.vitesse = v;
        this.terrain =env;
        this.id="A"+compteur;
        compteur++;
        this.ptsDefense = ptsDefense;
        this.Immunité = immunite;
        this.dégatBase =  degatDefense;
        //System.out.println("y" + y + "x" +x);
    }
    */





    public Ennemis(Terrain terrain){

            compteur++;
            this.terrain = terrain;

            // On multiplie par 32 la case de départ du terrain, pour adapter les dimensions du tableau aux dimensions du terrains et on ajoute 16 pour mettre l'ennemi au centre de la case
            this.xProperty = new SimpleIntegerProperty(terrain.getPointDep().getX() * 32 + 16);
            this.yProperty = new SimpleIntegerProperty(terrain.getPointDep().getY() * 32 + 16);

            this.id = "" + compteur;
            this.casesParcourues = new CasesParcourues();
        }

        public final int getX () {
            return xProperty.getValue();
        }

        public final IntegerProperty getxProperty () {
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

        public String getId () {
            return id;
        }

        public void seDeplace () {
            // On récupère le tableau du terrain
            int tab[][] = terrain.getTabTerrain();


                    // On ajoute la case ou se situe l'ennemi à sa liste cases parcourues

            casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));

            // On vérifie si la case à droite de l'ennemi est dans sa liste de case parcourue et on vérifie après si la case est un chemin ou la base
            if (!casesParcourues.verif(this.getX() + 32, this.getY()) && tab[this.getY() / 32][(this.getX() / 32) + 1] == 0 || !casesParcourues.verif(this.getX() + 32, this.getY()) && tab[this.getY() / 32][(this.getX() / 32) + 1] == 3) {
                this.setX(this.getX() + 32);
                casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
            }

            // On vérifie si la case en dessous de l'ennemi est dans sa liste de case parcourue et on vérifie après si la case est un chemin ou la base
            else if (!casesParcourues.verif(this.getX(), this.getY() + 32) && tab[(this.getY() / 32) + 1][(this.getX() / 32)] == 0 || !casesParcourues.verif(this.getX(), this.getY() + 32) && tab[(this.getY() / 32) + 1][(this.getX() / 32)] == 3) {
                this.setY(this.getY() + 32);
                casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
            }

            // On vérifie si la case à gauche de l'ennemi est dans sa liste de case parcourue et on vérifie après si la case est un chemin ou la base
            else if (!casesParcourues.verif(this.getX() - 32, this.getY()) && tab[(this.getY() / 32)][(this.getX() / 32) - 1] == 0 || !casesParcourues.verif(this.getX() - 32, this.getY()) && tab[(this.getY() / 32)][(this.getX() / 32) - 1] == 3) {
                this.setX(this.getX() - 32);
                casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
            }

            // On vérifie si la case au dessus de l'ennemi est dans sa liste de case parcourue et on vérifie après si la case est un chemin ou la base
            else if (!casesParcourues.verif(this.getX(), this.getY() - 32) && tab[(this.getY() / 32) - 1][this.getX() / 32] == 0 || !casesParcourues.verif(this.getX(), this.getY() - 32) && tab[(this.getY() / 32) - 1][this.getX() / 32] == 3) {
                this.setY(this.getY() - 32);
                casesParcourues.ajouterCase(new Cases(this.getX(), this.getY()));
            }

        }
    }


