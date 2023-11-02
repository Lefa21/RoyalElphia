package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import fr.montreuil.iut.RoyalElphia.modele.jeu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    private jeu jeu;


    private boolean trouve = false;

    public VueTour(Pane p, Tour T, double x, double y, Terrain terrain, jeu jeu) {
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
            Image tourImage = null;
            switch (tour.getClass().getSimpleName()) {
                case "TourABombe":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTour/TourBombeM.png"));
                    break;
                case "TourBouleDeFeu":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTour/TourFeuTerrain.png"));
                    break;
                case "TourFleche":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTour/TourFlecheM.png"));
                    break;
                case "TourElectrique":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTour/TourEclairM.png"));
                    break;
                case "TourLaser":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTour/TourLaserView.png"));
                    break;
            }
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

    public void CliqueTour(jeu jeu, String TypeTour) {
        Tour tour = null;
        switch (TypeTour) {
            case "bombe":
                tour = new TourABombe(jeu.getNbTour());
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
            if (jeu.verifArgent(tour)) {
                jeu.setArgent(tour.getCoutAchat());
                jeu.ajouterTour(tour);
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
                for (int i = 0; i < jeu.getListeDeTour().size(); i++) {
                    Tour t = jeu.getListeDeTour().get(i);
                    if (Integer.toString(t.getID()).equals(x.getId())) {
                        if (t.getNiveauAmelioration() != t.getNiveauMaxAmelioration()) {
                            if (t.getCoutAmelioration() <= jeu.getArgent()) {
                                jeu.setArgent(t.getCoutAmelioration());
                                t.setNiveauAmelioration(t.getNiveauAmelioration() + 1);
                                t.setDegat();
                                t.setCoutAmelioration((int) (t.getCoutAmelioration() * 1.5));
                                t.setCoutVente((int) (t.getCoutVente() * 1.5));
                                System.out.println("NIV " + t.getNiveauAmelioration() + " DEGAT " + t.getDegat());
                            }
                        }
                        else
                            System.out.println("niv MAX");
                    }
                }
            } else {
                x.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && !trouve) {
                        for (int j = 0; j < this.jeu.getListeDeTour().size(); j++) {
                            Tour t = this.jeu.getListeDeTour().get(j);

                            if (Integer.toString(t.getID()).equals(x.getId())) {
                                panneauJeu.getChildren().remove(x);
                                this.jeu.getListeDeTour().remove(t);
                                this.jeu.setArgent(-t.getCoutVente());

                                t.TourDevientInoffensif(terrain, t.getListeCasesDegats());
                                trouve = true;
                            }
                        }
                    }
                });
            }
        });

    }
}
