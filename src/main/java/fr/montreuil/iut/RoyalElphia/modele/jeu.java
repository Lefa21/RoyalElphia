package fr.montreuil.iut.RoyalElphia.modele;

import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Niveau;
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
    private ArrayList<Tour> listeDeTour;
    private IntegerProperty argent;

    private Niveau niveau;

    private IntegerProperty nbVague;


    private int temps, nbTour;


    public jeu(Terrain terrain, Niveau niveau) {
        this.terrain = terrain;
        this.ennemis = FXCollections.observableArrayList();
        this.listeEnnemisTuée = new ArrayList<>();
        this.listeEnnemisSpawn = new ArrayList<>();
        this.niveau = niveau;
        this.nbTour = 0;
        this.nbVague = new SimpleIntegerProperty(1);
        this.pvJoueur = new SimpleIntegerProperty(4);
        this.listeDeTour = new ArrayList<>();
        this.argent = new SimpleIntegerProperty(200);
    }


    public void ajouterTour(Tour t) {
        listeDeTour.add(t);
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

    public boolean verifArgent(Tour t) {
        if (t.getCoutAchat() > getArgent()) {
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
        this.nbVague.setValue(this.nbVague.getValue() + 1);
        this.niveau.setNbEnnemis(this.niveau.getNbEnnemis() * 2);
    }

    // permet d'ajouter un ennemi qui a spawn sur le terrain dans la liste de notre modèle
    public void spwanEnnemi() {
        if (nbTour % 2 == 0 && listeEnnemisSpawn.size() != this.niveau.getNbEnnemis()) {
            Ennemis enm = new Sorcières(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
        }

        if (nbTour % 2 == 0 && listeEnnemisSpawn.size() != this.niveau.getNbEnnemis()) {
            Ennemis enm1 = new Géant(terrain);
            ennemis.add(enm1);
            this.listeEnnemisSpawn.add(enm1);
        } else if (nbTour % 4 == 0 && listeEnnemisSpawn.size() != this.niveau.getNbEnnemis()) {
            Ennemis enm = new gobelins(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
        } else if (nbTour % 4 == 0 && listeEnnemisSpawn.size() != this.niveau.getNbEnnemis()) {
            Ennemis enm = new Squelette(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
        } else if (nbTour % 4 == 0 && listeEnnemisSpawn.size() != this.niveau.getNbEnnemis()) {
            Ennemis enm = new GéantRoyal(terrain);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);

        }
    }


            //permet de récuperer la liste des ennemis ayant spawn
            public ArrayList<Ennemis> getListeEnnemisSpawn() {
                return listeEnnemisSpawn;
            }

            public void ajoutEnnemisMort(Ennemis enm){
                listeEnnemisTuée.add(enm);
            }

            public ArrayList<Ennemis> getEnnemisTué() {
                return listeEnnemisTuée;
            }


    public void lancementLoop () {
        gameLoop.play();
    }

    public void arretLoop () {
        gameLoop.stop();
    }


    public ObservableList<Ennemis> getEnnemis () {
        return ennemis;
    }

    public IntegerProperty getPvJoueurProperty () {
        return this.pvJoueur;
    }

    public int getPvJoueur () {
        return this.pvJoueur.getValue();
    }

    public void setPvJoueur ( int pvJoueur){
        this.pvJoueur.setValue(pvJoueur);
    }

    public ArrayList<Tour> getListeDeTour () {
        return listeDeTour;
    }


            public void unTour() {
                for (int i = 0; i < ennemis.size(); i++) {
                    this.ennemis.get(i).seDeplace();
                    if (this.ennemis.get(i).getX() == (this.terrain.getPointArv().getX() * 32 + 16) && this.ennemis.get(i).getY() == (this.terrain.getPointArv().getY() * 32 + 16)) {
                        System.out.println("-1 PV");
                        setPvJoueur(this.getPvJoueur() - 1);
                        this.getEnnemis().remove(this.getEnnemis().get(i));
                    }
                    for (int j = 0; j < terrain.getCasesDégats().size(); j++) {
                        if (this.ennemis.get(i).getX() == this.terrain.getCasesDégats().get(j).getX() && this.ennemis.get(i).getY() == this.terrain.getCasesDégats().get(j).getY())
                            this.ennemis.get(i).setPv(this.terrain.getCasesDégats().get(j).getDegat());
                    }
                }
                for (int i = ennemis.size() - 1; i >= 0; i--) {
                    if (ennemis.get(i).getPv() == 0)
                        ennemis.remove(i);
                }
                nbTour++;
            }
            public void initAnimation () {
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
                                System.out.println("Vous avez perdu");
                                gameLoop.stop();
                            } else if (getEnnemisTué().size() == niveau.getNbEnnemis()) {
                                System.out.println("Le nombre d'ennemis max est de   " + this.niveau.getNbEnnemis());
                                System.out.println("Le nombre d'ennemis est tué est  " + this.getEnnemisTué().size());
                                vagueSuivante();
                                System.out.println("Nous passons à la vague " + this.getNbVague());
                                unTour();
                            } else if (temps % 3 == 0) {
                                unTour();
                            } else if (temps % 5 == 0) {
                                if (getEnnemis().size() < this.niveau.getNbEnnemis()) {
                                    System.out.println("Un tour");
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

