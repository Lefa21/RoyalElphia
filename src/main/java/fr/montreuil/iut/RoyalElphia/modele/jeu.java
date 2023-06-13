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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;

public class jeu {
    private Terrain terrain;
    private ObservableList<Ennemis> ennemis;
    private ArrayList<Ennemis> listeEnnemisTuée;
    private ArrayList<Ennemis> listeEnnemisSpawn;
    private Timeline gameLoop;
    private IntegerProperty pvJoueur;
    private ArrayList<Tour> listeDeTour;

    private ObservableList<Obstacle> listeObstacle;
    private IntegerProperty argent;


    private Niveau niveau;

    private IntegerProperty nbVague, nbEnnemisRestant;

    private VBox vBox;


    private int temps, nbTour;
    private Vague vague;


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
        this.listeDeTour = new ArrayList<>();
        this.listeObstacle = FXCollections.observableArrayList();
        this.argent = new SimpleIntegerProperty(200);
        this.vague = new Vague(this.niveau.getNbEnnemis(), this.terrain);
        this.vBox = vBox;
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
        listeEnnemisSpawn.removeAll(listeEnnemisSpawn);
        this.nbVague.setValue(this.nbVague.getValue() + 1);
        this.niveau.setNbEnnemis(this.niveau.getNbEnnemis() * 2);
        this.nbEnnemisRestant.setValue(this.niveau.getNbEnnemis());
        this.vague = new Vague(this.niveau.getNbEnnemis(), terrain);
    }

    // permet d'ajouter un ennemi qui a spawn sur le terrain dans la liste de notre modèle
    public void spwanEnnemi() {
        for (int i = 0; i < vague.getListeEnnemis().size(); i++) {
            Ennemis e = vague.getListeEnnemis().pollLast();
            ennemis.add(e);
            this.listeEnnemisSpawn.add(e);
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

    public ArrayList<Tour> getListeDeTour() {
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
            e.seDeplace();

            if (this.terrain.verifPArv(e.getX(), e.getY())) {
                System.out.println("-1 PV");
                setPvJoueur(this.getPvJoueur() - 1);
                ennemis.remove(ennemis.get(i));
            }

            for (int j = 0; j < this.listeObstacle.size(); j++) {
                ObservableList<Obstacle> listObs = getListeObstacle();
                if (this.listeObstacle.get(j).getPointDeVie() == 10) {
                    tab[this.listeObstacle.get(j).getPosY()][this.listeObstacle.get(j).getPosX()] = 9;
                    this.listeObstacle.remove(this.listeObstacle.get(j));
                }
                int degat = ennemis.get(i).getDegatObstacle();

                System.out.println("vie obstacle " + this.listeObstacle.get(i).getPointDeVie());
                int vieObstacle = this.listeObstacle.get(i).getPointDeVie() - degat;
                System.out.println("vie obs après dégats : " + vieObstacle);
                if (((e.getX() / 32 + 1 == listObs.get(j).getPosX() && e.getY() / 32 == listObs.get(j).getPosY()) || (e.getX() / 32 == listObs.get(j).getPosX() && e.getY() / 32 + 1 == listObs.get(j).getPosY()) || (e.getX() / 32 == listObs.get(j).getPosX() && e.getY() / 32 - 1 == listObs.get(j).getPosY()) || (e.getX() / 32 - 1 == listObs.get(j).getPosX() && e.getY() / 32 == listObs.get(j).getPosY())) && vieObstacle >= 0) {


                    System.out.println(listObs.get(j).toString());
                    listObs.get(j).setPointDeVie(vieObstacle);
                    System.out.println("vie obs après dégats réel : " + vieObstacle);
                    System.out.println(listObs.get(j).toString());
                }
/*
                        else if (((enm.getX()) == ((obs.getPosX()* 33)) && (enm.getY() == ((obs.getPosY() * 32) + 16)))) {
                            System.out.println("check position ennemis obstacle");
                            System.out.println("point de vie obstacle : " + obs.getPointDeVie());
                            obs.setPointDeVie(obs.getPointDeVie() - degat);
                            System.out.println("point de vie après dégat :" + obs.getPointDeVie());
                        }
 */
            }

            for (int j = 0; j < this.terrain.getCasesDégats().size(); j++) {
                CasesDégats c = this.terrain.getCasesDégats().get(j);
                if (c.verifDegat(e))
                    e.setPv(this.terrain.getCasesDégats().get(j).getDegat());
            }
        }
/*
        for (int i = 0; i < listeObstacle.size(); i++) {
<<<<<<< HEAD
            if(this.listeObstacle.get(i).getPointDeVie() == 10){
=======
            if (this.listeObstacle.get(i).getPointDeVie() == 0) {
>>>>>>> Integration
                tab[this.listeObstacle.get(i).getPosY()][this.listeObstacle.get(i).getPosX()] = 9;
                this.listeObstacle.remove(this.listeObstacle.get(i));
            }
        }

 */


        for (int i = this.ennemis.size() - 1; i >= 0; i--) {
            if (this.ennemis.get(i).getPv() == 0)
                this.ennemis.remove(i);
        }

        nbTour++;
    }


    public void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);


        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)


                Duration.seconds(0.05),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev -> {
                    if (this.getPvJoueur() == 0 || this.nbVague.getValue() == 5) {
                        menuEnnemiS(vBox);
                        System.out.println("Vous avez perdu");
                        gameLoop.stop();
                    } else if (getEnnemisTué().size() == niveau.getNbEnnemis()) {

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
                            spwanEnnemi();
                            menuEnnemiA(vBox);
                            System.out.println("Ennemis spwan");
                        }
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

