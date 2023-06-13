package fr.montreuil.iut.RoyalElphia.modele;

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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Duration;


import java.io.FileWriter;
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

    private VBox vBox;

    private int temps, nbTour;
    private Vague vague;

    private boolean vagueS = false;


    public jeu(Terrain terrain, Niveau niveau, VBox vBox) {
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
        this.vague = new Vague(this.niveau.getNbEnnemis(), this.terrain);
        this.vBox = vBox;
    }

    public void enleveObstacleDetruit(int[][] tab, Ennemis e) {
        for (int j = 0; j < this.listeObstacle.size(); j++) {
            Obstacle obstacle = this.listeObstacle.get(j);
            if (obstacle.getPointDeVie() <= 0) {
                tab[obstacle.getPosY()][obstacle.getPosX()] = 9;
                this.listeObstacle.remove(this.listeObstacle.get(j));
            }

            //
            if ((e.getCapaciteObstacle() >= obstacle.getMateriaux() && (e.getX() / 32 + 1 == obstacle.getPosX() && e.getY() / 32 == obstacle.getPosY()) || (e.getX() / 32 == obstacle.getPosX() && e.getY() / 32 + 1 == obstacle.getPosY()) || (e.getX() / 32 == obstacle.getPosX() && e.getY() / 32 - 1 == obstacle.getPosY()) || (e.getX() / 32 - 1 == obstacle.getPosX() && e.getY() / 32 == obstacle.getPosY()))) {
                int degat = e.getDegatObstacle();
                int vieObstacle = obstacle.getPointDeVie() - degat;
                obstacle.setPointDeVie(vieObstacle);
            }
        }
    }

    public void degatEnnemis(Ennemis e) {
        for (int j = 0; j < this.terrain.getCasesDégats().size(); j++) {
            CasesDégats c = this.terrain.getCasesDégats().get(j);
            if (c.verifDegat(e))
                e.setPv(this.terrain.getCasesDégats().get(j).getDegat());
        }
    }

    public void degatBase(Ennemis e) {
        if (this.terrain.verifPArv(e.getX(), e.getY())) {
            System.out.println("-1 PV");
            setPvJoueur(this.getPvJoueur() - 1);
            this.getEnnemis().remove(e);
        }
    }

    public void enleveEnnemisMort() {
        for (int i = this.ennemis.size() - 1; i >= 0; i--) {
            if (this.ennemis.get(i).getPv() == 0)
                this.ennemis.remove(i);
        }
    }

    public void augmentationCapacité(int nbTour, Ennemis e) {
        if (nbTour % 64 == 0) {
            System.out.println("augmentation capacité");
            if (e.getCapaciteDegatObstacle() == 1) {
                System.out.println("degat obs av:" + e.getDegatObstacle());
                e.setDegatObstacle((int) (e.getDegatObstacle() * 1.5));
                System.out.println("degat obs ap : " + e.getDegatObstacle());
            }
            if (e.getCapaciteVie() == 1) {
                System.out.println("pv  av :" + e.getPv());
                e.améliorationPv((int) (e.getPv() * 1.5));
                System.out.println("pv ap :" + e.getPv());
            }
            if (e.getCapaciteDegatsBase() == 1) {
                System.out.println("degat base av :" + e.getDegatBase());
                e.setDegatBase((int) (e.getDegatBase() * 1.5));
                System.out.println("degat base ap: " + e.getDegatBase());

            }
        }
    }

    public void ajouterTour(Tour t) {
        listeDeTour.add(t);
    }


    public void ajouterObstacle(Obstacle O) {
        listeObstacle.add(O);
    }

    public final ObservableList<Obstacle> getListeObstacle() {
        return listeObstacle;
    }

    public IntegerProperty getArgentProperty() {
        return argent;
    }

    public void setArgent(int prix) {
        this.argent.setValue(this.argent.getValue() - prix);
    }

    public void setArgentAZero() {
        this.argent.setValue(0);
    }

    public void setPvZero() {
        this.pvJoueur.setValue(0);
    }

    public int getArgent() {
        return this.argent.getValue();
    }

    public boolean verifArgent(Tour t) {
        if (t.getCoutAchat() > getArgent()) {
            return false;
        }
        return true;
    }

    public boolean verifArgentObstacle(Obstacle O) {
        if (O.getCoutAchat() > getArgent()) {
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

        listeEnnemisSpawn.clear();
        ennemis.clear();
        this.nbVague.setValue(this.nbVague.getValue() + 1);
        this.niveau.setNbEnnemis(this.niveau.getNbEnnemis() * 2);
        this.nbEnnemisRestant.setValue(this.niveau.getNbEnnemis());


    }

    // permet d'ajouter un ennemi qui a spawn sur le terrain dans la liste de notre modèle
    public void spwanEnnemi(){
        //for (int i = 0; i < this.niveau.getNbEnnemis(); i++) {
            //if(nbTour % 2 == 0) {
                Ennemis enm = new Sorcières(terrain);
                ennemis.add(enm);
                this.listeEnnemisSpawn.add(enm);
           // }

           /* if (nbTour % 4 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
                Ennemis enm = new Sorcières(terrain);
                ennemis.add(enm);
                this.listeEnnemisSpawn.add(enm);
            }
            if (nbTour % 8 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
                Ennemis enm = new gobelins(terrain);
                ennemis.add(enm);
                this.listeEnnemisSpawn.add(enm);
=======
>>>>>>> 2d08813abbee35a32ab98e6d5d0fc14c6199e17c

        for (int i = 0; i < vague.getListeEnnemis().size(); i++) {
            Ennemis e = vague.getListeEnnemis().pollLast();
            ennemis.add(e);
            this.listeEnnemisSpawn.add(e);

<<<<<<< HEAD
            }
            if (nbTour % 32 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
                Ennemis enm = new GéantRoyal(terrain);
                ennemis.add(enm);
                this.listeEnnemisSpawn.add(enm);
<<<<<<< HEAD
=======
           /* for (int i = 0; i < this.niveau.getNbEnnemis(); i++) {
                if (nbTour % 2 == 0) {
                    Ennemis enm = new Sorcières(terrain);
                    ennemis.add(enm);
                    this.listeEnnemisSpawn.add(enm);
                }
                if (nbTour % 4 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
                    Ennemis enm = new Sorcières(terrain);
                    ennemis.add(enm);
                    this.listeEnnemisSpawn.add(enm);
                }
                if (nbTour % 8 == 0 && listeEnnemisSpawn.size() <= this.niveau.getNbEnnemis()) {
                    Ennemis enm = new gobelins(terrain);
                    ennemis.add(enm);
                    this.listeEnnemisSpawn.add(enm);
=======
            }*/
        //}
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

    public void unTour() {
        int[][] tab = terrain.getTabTerrain();
        for (int i = 0; i < this.ennemis.size(); i++) {
            Ennemis e = this.ennemis.get(i);
            augmentationCapacité(this.nbTour, e);
            e.seDeplace();
            degatBase(e);
            enleveObstacleDetruit(tab, e);
            degatEnnemis(e);
        }
        enleveEnnemisMort();
        if (getArgent() < 0) {
            setArgentAZero();
        }


        if (getPvJoueur() < 0) {
            setPvZero();
        }
        nbTour++;
    }

    public void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);


        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)

                Duration.seconds(0.025),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev -> {
                    if (this.getPvJoueur() == 0 || this.nbVague.getValue() == 5) {
                        menuEnnemiS(vBox);
                        System.out.println("Vous avez perdu");
                        gameLoop.stop();
                    } else if (getNbEnnemisRestant()==0) {
                        System.out.println("Vague suivante " + this.getNbVague());
                        vagueSuivante();
                        getEnnemisTué().removeAll(getEnnemisTué());
                        System.out.println("nombre d'ennemis spwan:  " + this.listeEnnemisSpawn.size());


                    } else if (temps % 3 == 0) {
                        unTour();
                        System.out.println("Un tour");

                    } else if (temps % 5 == 0) {
                        if (getEnnemis().size() < this.niveau.getNbEnnemis()) {
                            menuEnnemiS(vBox);
                            //spwanEnnemi();
                            menuEnnemiA(vBox);
                        }
                        } else if (temps % 20 == 0 && getListeEnnemisSpawn().size() < this.niveau.getNbEnnemis()) {
                            spwanEnnemi();
                            temps++;
                            System.out.println("Ennemis spwan");
                        }
                        temps++;
                    })
                );
        gameLoop.getKeyFrames().add(kf);
    }

    public void menuEnnemiA(VBox vBox) {
        for (int i = 0; i < ennemis.size(); i++) {
            Ennemis en = ennemis.get(i);
            Circle c = new Circle(12);
            c.setOnMouseClicked(e -> System.out.println(en.affichageImmunité()));
            if (en instanceof gobelins) {
                c.setFill(Color.GREEN);
                vBox.getChildren().add(c);
            } else if (en instanceof Sorcières) {
                c.setFill(Color.VIOLET);
                vBox.getChildren().add(c);
            } else if (en instanceof GéantRoyal) {
                c.setFill(Color.BLACK);
                vBox.getChildren().add(c);
            } else if (en instanceof Géant) {
                c.setFill(Color.BROWN);
                vBox.getChildren().add(c);
            } else if (en instanceof Squelette) {
                c.setFill(Color.GREY);
                vBox.getChildren().add(c);
            }
            Label l = new Label();
            l.textProperty().bind(en.getPvProperty().asString());
            vBox.getChildren().add(l);
        }
    }

    public void menuEnnemiS(VBox vBox) {
        vBox.getChildren().removeAll(vBox.getChildren());
    }


}


