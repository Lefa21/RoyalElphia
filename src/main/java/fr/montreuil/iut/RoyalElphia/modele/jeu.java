package fr.montreuil.iut.RoyalElphia.modele;
import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;

import java.util.ArrayList;

public  class jeu {
    private Terrain terrain;
    private ObservableList<Ennemis> ennemis;

    private ArrayList<Ennemis> listeEnnemisTuée;

    private ArrayList<Ennemis> listeEnnemisSpawn;

    private int nbEnnemis,nbSquelette,nbGobelins,nbGeant,nbSorciere,nbGeantRoyale,nbTour;

    private Timeline gameLoop;
    private int temps;



    public jeu (Terrain terrain,int nbEnnemis, int nbGobelins, int nbSquelette, int nbGeant,int nbSorciere,int nbGeantRoyale) {
        this.terrain = terrain;
        this.ennemis = FXCollections.observableArrayList();
        this.nbEnnemis = nbEnnemis;
        this.listeEnnemisTuée = new ArrayList<>();
        this.listeEnnemisSpawn = new ArrayList<>();
        this.nbGeant = nbGeant;
        this.nbSorciere = nbSorciere;
        this.nbGobelins = nbGobelins;
        this.nbSquelette = nbSquelette;
        this.nbGeantRoyale = nbGeantRoyale;
        this.nbTour = 0;
    }


    public Terrain getTerrain() {
        return terrain;
    }

    public ArrayList<Ennemis> getListeEnnemisTuée() {
        return listeEnnemisTuée;
    }

    public int getNbSquelette() {
        return nbSquelette;
    }

    public int getNbGobelins() {
        return nbGobelins;
    }

    public int getNbGeant() {
        return nbGeant;
    }

    public int getNbSorciere() {
        return nbSorciere;
    }

    public int getNbGeantRoyale() {
        return nbGeantRoyale;
    }

    public void ajouter(Ennemis e) {
        this.ennemis.add(e);
    }

    // permet d'ajouter un ennemi qui a spawn sur le terrain dans la liste de notre modèle

    public void setNbSquelette(int nbSquelette) {
        this.nbSquelette = nbSquelette;
    }

    public void setNbGobelins(int nbGobelins) {
        this.nbGobelins = nbGobelins;
    }

    public void setNbGeant(int nbGeant) {
        this.nbGeant = nbGeant;
    }

    public void setNbSorciere(int nbSorciere) {
        this.nbSorciere = nbSorciere;
    }

    public void setNbGeantRoyale(int nbGeantRoyale) {
        this.nbGeantRoyale = nbGeantRoyale;
    }

    public void spwanEnnemi(){
        if(nbTour%2 == 0 && getNbSorciere() != 0){
            Ennemis enm = new Sorcières(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbSorciere(getNbSorciere() -1);
        }

        else if(nbTour%4 == 0 && getNbGeant() != 0){
            Ennemis  enm = new Géant(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbGeant(getNbGeant() -1);
        }

        else if(nbTour%8 == 0 && getNbGobelins() != 0){
            Ennemis enm = new gobelins(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbGobelins(getNbGobelins() -1);
        }

        else if(nbTour%16 == 0 && getNbSquelette() != 0){
            Ennemis enm = new Squelette(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbSquelette(getNbSquelette() -1);
        }

        else if(nbTour%32 == 0 && getNbGeantRoyale() != 0){
            Ennemis enm = new GéantRoyal(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbGeantRoyale(getNbGeantRoyale() -1);
        }
    }


   //permet de récuperer la liste des ennemis ayant spawn
    public ArrayList<Ennemis> getListeEnnemisSpawn(){
        return listeEnnemisSpawn;
    }

    public void ajoutEnnemisMort(Ennemis enm){
        listeEnnemisTuée.add(enm);
    }

    public ArrayList<Ennemis> getEnnemisTué(){
        return listeEnnemisTuée;
    }

    public int getNbEnnemisMax(){
        return nbEnnemis;
    }

    public void unTour() {
        for (int i = 0; i < ennemis.size(); i++) {
            this.ennemis.get(i).seDeplace();
            if (this.ennemis.get(i).getX()== (this.terrain.getPointArv().getX()*32+16) && this.ennemis.get(i).getY() == (this.terrain.getPointArv().getY()*32+16)) {
                System.out.println("-1 PV");
                this.getEnnemis().remove(this.getEnnemis().get(i));
            }
        }
        nbTour++;
        }

    public void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);


        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.03),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev -> {
                    if (getEnnemisTué().size() == getNbEnnemisMax()) {
                        System.out.println("fini");
                        gameLoop.stop();
                    } else if (temps % 3 == 0) {
                        unTour();
                    } else if (temps % 5 == 0) {
                        if (getEnnemis().size() < getNbEnnemisMax()) {
                            System.out.println("Un tour");
                            spwanEnnemi();
                        }
                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

    public ObservableList<Ennemis> getEnnemis() {
        return ennemis;
    }

    public void lancementGameloop(){
        gameLoop.play();
    }
}
