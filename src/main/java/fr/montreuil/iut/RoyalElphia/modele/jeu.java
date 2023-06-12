package fr.montreuil.iut.RoyalElphia.modele;

import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Niveau;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;

import java.util.ArrayList;

public class jeu {
    private Terrain terrain;
    private ObservableList<Ennemis> ennemis;
    private ArrayList<Ennemis> listeEnnemisTuée;
    private ArrayList<Ennemis> listeEnnemisSpawn;
    private Timeline gameLoop;
    private IntegerProperty pvJoueur;
    private ObservableList<Tour> listeDeTour;

    private ObservableList<Obstacle> listeObstacle;
    private IntegerProperty argent;

    private Niveau niveau;

    private IntegerProperty nbVague, nbEnnemisRestant;


    private int temps, nbTour;


    public jeu(Terrain terrain, Niveau niveau) {
        this.terrain = terrain;
        this.ennemis = FXCollections.observableArrayList();
        this.listeEnnemisTuée = new ArrayList<>();
        this.listeEnnemisSpawn = new ArrayList<>();
        this.niveau = niveau;
        this.nbTour = 0;
        this.nbEnnemisRestant = new SimpleIntegerProperty(this.niveau.getNbEnnemis());
        this.nbVague = new SimpleIntegerProperty(1);
        this.pvJoueur = new SimpleIntegerProperty(400);
        this.listeDeTour = FXCollections.observableArrayList();
        this.listeObstacle = FXCollections.observableArrayList();
        this.argent = new SimpleIntegerProperty(200);
    }


    public void ajouterTour(Tour t) {
        listeDeTour.add(t);
    }


    public void ajouterObstacle(fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle O) {
        listeObstacle.add(O);
    }

    public final ObservableList<fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle> getListeObstacle() {
        return listeObstacle;
    }

    public IntegerProperty getArgentProperty() {
        return argent;
    }

    public void setArgent(int prix) {
        this.argent.setValue(this.argent.getValue() - prix);
    }

    public int getArgent() {
        return this.argent.getValue();
    }

    public boolean verifArgent(Items items) {
        if (items.getCoutAchat() > getArgent()) {
            return false;
        }
        return true;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public ArrayList<Ennemis> getListeEnnemisTuée() {
        return listeEnnemisTuée;
    }


    public final void setNbVague(int nbVague) {
        this.nbVague.set(nbVague);
    }

    public final int getNbVague() {
        return nbVague.get();
    }

    public final IntegerProperty getNbVagueProperty() {
        return this.nbVague;
    }

    public void ajouter(Ennemis e) {
        this.ennemis.add(e);
    }

    public void vagueSuivante() {
        for (int i = 0; i < listeEnnemisSpawn.size(); i++) {
            listeEnnemisSpawn.remove(i);
        }
        this.nbVague.setValue(this.nbVague.getValue() + 1);
        this.niveau.setNbEnnemis(this.niveau.getNbEnnemis() * 2);
        this.nbEnnemisRestant.setValue(this.niveau.getNbEnnemis());
    }

    // permet d'ajouter un ennemi qui a spawn sur le terrain dans la liste de notre modèle
    public void spwanEnnemi() {

        /*

        if (nbTour % 2 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
            Ennemis enm = new Sorcières(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);

/*
=======
        }

        if (nbTour % 4 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
>>>>>>> 2cd98ba8bad3a457bbe0ee5f99bcaf47999cb7fd
            Ennemis enm1 = new Géant(terrain);
            ennemis.add(enm1);
            this.listeEnnemisSpawn.add(enm1);


        }
        if (nbTour % 8 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
            Ennemis enm = new gobelins(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);

        }

        */
        if (nbTour % 2 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
            Ennemis enm = new Squelette(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);

        }
        if (nbTour % 4 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
            Ennemis enm = new GéantRoyal(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
        }
    }


    //permet de récuperer la liste des ennemis ayant spawn
    public ArrayList<Ennemis> getListeEnnemisSpawn() {
        return listeEnnemisSpawn;
    }

    public void ajoutEnnemisMort(Ennemis enm) {
        listeEnnemisTuée.add(enm);
    }

    public ArrayList<Ennemis> getEnnemisTué() {
        return listeEnnemisTuée;
    }


    public void lancementLoop() {
        gameLoop.play();
    }

    public void arretLoop() {
        gameLoop.stop();
    }


    public ObservableList<Ennemis> getEnnemis() {
        return ennemis;
    }

    public IntegerProperty getPvJoueurProperty() {
        return this.pvJoueur;
    }

    public int getPvJoueur() {
        return this.pvJoueur.getValue();
    }

    public void setPvJoueur(int pvJoueur) {
        this.pvJoueur.setValue(pvJoueur);
    }

    public ObservableList<Tour> getListeDeTour() {
        return listeDeTour;
    }

    public final void setNbEnnemisRestant(int nbEnnemisRestant) {
        this.nbEnnemisRestant.setValue(nbEnnemisRestant);
    }

    public IntegerProperty nbEnnemisRestantProperty() {
        return nbEnnemisRestant;
    }

    public int getNbEnnemisRestant() {
        return this.nbEnnemisRestant.getValue();
    }

    public void enleveObstacleDetruit(int [][] tab,Ennemis e) {
        for (int j = 0; j < this.listeObstacle.size(); j++) {
            Obstacle obstacle = this.listeObstacle.get(j);
            if(obstacle.getPointDeVie() <=0){
                tab[obstacle.getPosY()][obstacle.getPosX()] = 9;
                this.listeObstacle.remove(this.listeObstacle.get(j));
            }

            // e.getCapaciteObstacle() >= obstacle.getMateriaux()
            if (((e.getX()/32+1 == obstacle.getPosX() && e.getY()/32 == obstacle.getPosY()) || (e.getX()/32 == obstacle.getPosX() && e.getY()/32+1 == obstacle.getPosY()) || (e.getX()/32 == obstacle.getPosX() && e.getY()/32-1 == obstacle.getPosY()) || (e.getX()/32-1 == obstacle.getPosX() && e.getY()/32 == obstacle.getPosY())) ) {
                int degat = e.getDegatObstacle();
                int vieObstacle = obstacle.getPointDeVie() - degat;
                obstacle.setPointDeVie(vieObstacle);
            }
        }
    }

    public void degatEnnemis(Ennemis e){
        for (int j = 0; j < this.terrain.getCasesDégats().size(); j++) {
            CasesDégats c = this.terrain.getCasesDégats().get(j);
            if (c.verifDegat(e))
                e.setPv(this.terrain.getCasesDégats().get(j).getDegat());
        }
    }

    public void degatBase(Ennemis e){
        if (this.terrain.verifPArv(e.getX(), e.getY())) {
            System.out.println("-1 PV");
            setPvJoueur(this.getPvJoueur() - 1);
            this.getEnnemis().remove(e);
        }
    }

    public void enleveEnnemisMort(){
        for (int i = this.ennemis.size() - 1; i >= 0; i--) {
            if (this.ennemis.get(i).getPv() == 0)
                this.ennemis.remove(i);
        }
    }

    public void augmentationCapacité(int nbTour,Ennemis e){
        if(nbTour%64 ==0){
            System.out.println("augmentation capacité");
            if(e.getCapaciteDegatObstacle() == 1){
                System.out.println("degat obs av:" + e.getDegatObstacle());
                e.setDegatObstacle((int)(e.getDegatObstacle() * 1.5));
                System.out.println("degat obs ap : " + e.getDegatObstacle());
            }
            if(e.getCapaciteVie() == 1){
                System.out.println("pv  av :" + e.getPv());
                e.améliorationPv((int)(e.getPv() * 1.5));
                System.out.println("pv ap :" + e.getPv() );
            }
            if(e.getCapaciteDegatsBase() == 1){
                System.out.println("degat base av :" + e.getDegatBase());
                e.setDegatBase((int)(e.getDegatBase() * 1.5));
                System.out.println("degat base ap: " + e.getDegatBase());

            }
        }
    }


    public void unTour() {
        int [][] tab = terrain.getTabTerrain();
        for (int i = 0; i < this.ennemis.size(); i++) {
            Ennemis e = this.ennemis.get(i);
            augmentationCapacité(this.nbTour,e);
            e.seDeplace();
            degatBase(e);
            enleveObstacleDetruit(tab,e);
            degatEnnemis(e);
        }
        enleveEnnemisMort();
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
                    if (this.getPvJoueur() == 0 || this.nbVague.getValue() == 5) {
                        System.out.println("Vous avez perdu");
                        gameLoop.stop();
                    } else if (getEnnemisTué().size() == niveau.getNbEnnemis()) {
                        System.out.println("Vague suivante " + this.getNbVague());
                        vagueSuivante();
                        System.out.println("nombre d'ennemis spwan:  " + this.listeEnnemisSpawn.size());
                        unTour();
                    } else if (temps % 3 == 0) {
                        unTour();
                        System.out.println("Un tour");
                    } else if (temps % 5 == 0) {
                        if (getEnnemis().size() < this.niveau.getNbEnnemis()) {
                            spwanEnnemi();
                            System.out.println("Ennemis spwan");
                        }
                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

}

