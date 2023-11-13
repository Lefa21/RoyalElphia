package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Jeu;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueTour {

    private Tour tour;
    private Pane panneauJeu;

    private double x, y;

    private Terrain terrain;

    private static int IDtour = 1000;
    private static int IDImage = 1000;

    private Jeu jeu;


    private boolean trouve = false;

    public VueTour(Pane p, Tour T, double x, double y, Terrain terrain, Jeu jeu) {
        this.panneauJeu = p;
        this.tour = T;
        this.x = x;
        this.y = y;
        this.terrain = terrain;
        this.jeu = jeu;
    }

    public VueTour() {
    }


    public void PoserTour() throws FileNotFoundException {

        int[][] tab = terrain.getTabTerrain();
        int posX = (int) this.x / 32;
        int posY = (int) this.y / 32;
        if (tab[posY][posX] == 7 && tour != null) {
            Image tourImage = new Image(new FileInputStream(tour.getChemin()));
            if (tourImage != null) {
                tour.setPosX(posX);
                tour.setPosy(posY);
                ImageView tourImageView = new ImageView(tourImage);
                tour.rayonDegat(terrain, posX, posY, tour.getDegat());
                if (tour instanceof TourElectrique) {
                    tourImageView.setX(x - 45);
                    tourImageView.setY(y - 45);
                } else {
                    tourImageView.setX(x - 10);
                    tourImageView.setY(y - 15);

                }
                tourImageView.setId(Integer.toString(IDImage));
                Label label = new Label();
                label.textProperty().bind(tour.getDegatProperty().asString());
                label.translateXProperty().bind(tour.getPosXProperty().multiply(32).add(46));
                label.translateYProperty().bind(tour.getPosYProperty().multiply(32).add(-32));
                label.setBackground(Background.fill(Color.RED));
                System.out.println();
                label.setId(tour.getID() + "Lt");
                IDImage++;
                new VueProjectile(tour,panneauJeu);
                panneauJeu.getChildren().add(tourImageView);
                this.panneauJeu.getChildren().add(label);
                this.tour = null;
                AmeliorationEtVente(tourImageView);
            }
        }
    }

    public void CliqueTour(Jeu jeu, String TypeTour) {
        Tour tour = null;
        switch (TypeTour) {
            case "bombe":
                tour = new TourABombe();
                break;
            case "feu":
                tour = new TourBouleDeFeu();
                break;
            case "fleche":
                tour = new TourFleche();
                break;
            case "eclair":
                tour = new TourElectrique();
                break;
            case "laser":
                tour = new TourLaser();
                break;
        }
        if (tour != null) {
            tour.setID(IDtour);
            IDtour++;
            if(jeu.VerifEtAchatTour(tour)){
                this.tour = tour;
            }
        }
    }

    public Tour getTour() {
        return tour;
    }

    public void AmeliorationEtVente(ImageView x) {
        x.setOnMouseClicked(KeyEvent -> {
            if (KeyEvent.isAltDown()) {
                this.jeu.ameliorationTour(x);
            } else {
                x.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && !trouve) {
                        if(jeu.venteTour(x)){
                            panneauJeu.getChildren().remove(x);
                            trouve = true;
                        }
                    }
                });
            }
        });

    }
}
