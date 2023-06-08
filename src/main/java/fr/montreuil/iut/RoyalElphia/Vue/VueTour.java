package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.Controller.HelloController;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
        for (int i = 0; i < this.jeu.getListeDeTour().size(); i++) {
            System.out.println(this.jeu.getListeDeTour().size());
        }
        int[][] tab = terrain.getTabTerrain();
        int posX = (int) this.x / 32;
        int posY = (int) this.y / 32;
        if (tab[posY][posX] == 7 && tour != null) {
            Image tourImage = null;
            switch (tour.getClass().getSimpleName()) {
                case "TourABombe":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/tt-PhotoRoom.png-PhotoRoom(2).png"));
                    break;
                case "TourBouleDeFeu":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/TourFeuTerrain.png"));
                    break;
                case "TourFleche":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/TourFlecheM.png"));
                    break;
                case "TourElectrique":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/TourEclairM.png"));
                    break;
                case "TourLaser":
                    tourImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/TourLaserView.png"));
                    break;
            }
            if (tourImage != null) {
                ImageView tourImageView = new ImageView(tourImage);
                tour.rayonDegat(terrain, posX, posY, tour.getDegat(), this.panneauJeu);
                if (tour instanceof TourElectrique) {
                    tourImageView.setX(x - 45);
                    tourImageView.setY(y - 45);
                } else {
                    tourImageView.setX(x - 10);
                    tourImageView.setY(y - 15);

                }
                tourImageView.setId(Integer.toString(IDImage));
                IDImage++;
                panneauJeu.getChildren().add(tourImageView);
                this.tour = null;
                VendreTour(tourImageView);
                //AmeliorationTour(tourImageView);
            }
        }
    }

    public void CliqueTour(jeu jeu, String TypeTour) {
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

    public void VendreTour(ImageView i) {
        i.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2 && !trouve) {
                for (int j = 0; j < this.jeu.getListeDeTour().size(); j++) {
                    Tour t = this.jeu.getListeDeTour().get(j);

                    if (Integer.toString(t.getID()).equals(i.getId())) {
                        panneauJeu.getChildren().remove(i);
                        this.jeu.getListeDeTour().remove(t);
                        this.jeu.setArgent(-t.getCoutVente());
                        t.TourDevientInoffensif(terrain, t.getListeCasesDegats());
                        trouve = true;
                    }
                }
            }
        });
    }


    /*public void AmeliorationTour(ImageView i) {
        i.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1 && !trouve) {
                for (int j = 0; j < this.jeu.getListeDeTour().size(); j++) {
                    Tour t = this.jeu.getListeDeTour().get(j);
                    if (Integer.toString(t.getID()).equals(i.getId())) {
                        for (int k = 0; k < t.getListeCasesDegats().size(); k++) {
                            t.getListeCasesDegats().get(k).setDegat(15);
                        }
                        this.jeu.setArgent(-t.getCoutAmelioration());
                        System.out.println("amelioré");
                        trouve = true;
                    }
                }
            }
        });
    }*/

}

