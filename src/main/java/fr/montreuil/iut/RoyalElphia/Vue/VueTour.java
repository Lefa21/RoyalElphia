package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        if (tab[posY][posX] == 7) {
            if (this.tour instanceof TourABombe) {
                Image TourBombe = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/tt-PhotoRoom.png-PhotoRoom(2).png"));
                ImageView TourBombeView = new ImageView(TourBombe);
                tour.rayonDegat(terrain, posX, posY, tour.getDegat());
                TourBombeView.setX(x - 10);
                TourBombeView.setY(y - 15);
                TourBombeView.setId(Integer.toString(IDImage));
                IDImage++;
                panneauJeu.getChildren().add(TourBombeView);
                this.tour = null;
                VendreTour(TourBombeView);

            }
            if (this.tour instanceof TourBouleDeFeu) {
                Image TourFeu = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/TourFeuTerrain.png"));
                ImageView TourFeuView = new ImageView(TourFeu);
                tour.rayonDegat(terrain, posX, posY, tour.getDegat());
                TourFeuView.setX(x - 10);
                TourFeuView.setY(y - 15);
                TourFeuView.setId(Integer.toString(IDImage));
                IDImage++;
                panneauJeu.getChildren().add(TourFeuView);
                this.tour = null;
                VendreTour(TourFeuView);
            }
            if (this.tour instanceof TourFleche) {
                Image TourFleche = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/TourFlecheM.png"));
                ImageView TourFlecheView = new ImageView(TourFleche);
                tour.rayonDegat(terrain, posX, posY, tour.getDegat());
                TourFlecheView.setX(x - 10);
                TourFlecheView.setY(y - 15);
                TourFlecheView.setId(Integer.toString(IDImage));
                IDImage++;
                panneauJeu.getChildren().add(TourFlecheView);
                this.tour = null;
                VendreTour(TourFlecheView);
            }
            if (this.tour instanceof TourElectrique) {
                Image TourElec = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/TourEclairM.png"));
                ImageView TourElecView = new ImageView(TourElec);
                tour.rayonDegat(terrain, posX, posY, tour.getDegat());
                TourElecView.setX(x - 45);
                TourElecView.setY(y - 45);
                TourElecView.setId(Integer.toString(IDImage));
                IDImage++;
                panneauJeu.getChildren().add(TourElecView);
                this.tour = null;
                VendreTour(TourElecView);
            }
            if (this.tour instanceof TourLaser) {
                Image TourLaser = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/TourLaserView.png"));
                ImageView TourLaserView = new ImageView(TourLaser);
                tour.rayonDegat(terrain, posX, posY, tour.getDegat());
                TourLaserView.setX(x - 16);
                TourLaserView.setY(y - 16);
                TourLaserView.setId(Integer.toString(IDImage));
                IDImage++;
                panneauJeu.getChildren().add(TourLaserView);
                this.tour = null;
                VendreTour(TourLaserView);
            }
        }
    }

    public void CliqueTour(jeu jeu, String TypeTour) throws FileNotFoundException {
        if (TypeTour.equals("bombe")) {
            this.tour = new TourABombe();
            this.tour.setID(IDtour);
            IDtour++;
            //  System.out.println(this.tour.getID());
            if (jeu.verifArgent(this.tour)) {
                jeu.setArgent(this.tour.getCoutAchat());
                jeu.ajouterTour(this.tour);
            }
        }
        if (TypeTour.equals("feu")) {
            this.tour = new TourBouleDeFeu();
            this.tour.setID(IDtour);
            IDtour++;
            if (jeu.verifArgent(this.tour)) {
                jeu.ajouterTour(this.tour);
                jeu.setArgent(this.tour.getCoutAchat());
            }
        }
        if (TypeTour.equals("fleche")) {
            this.tour = new TourFleche();
            this.tour.setID(IDtour);
            IDtour++;
            if (jeu.verifArgent(this.tour)) {
                jeu.ajouterTour(this.tour);
                jeu.setArgent(this.tour.getCoutAchat());
            }
        }
        if (TypeTour.equals("eclair")) {
            this.tour = new TourElectrique();
            this.tour.setID(IDtour);
            IDtour++;
            if (jeu.verifArgent(this.tour)) {
                jeu.ajouterTour(this.tour);
                jeu.setArgent(this.tour.getCoutAchat());
            }
        }
        if (TypeTour.equals("laser")) {
            this.tour = new TourLaser();
            this.tour.setID(IDtour);
            IDtour++;
            if (jeu.verifArgent(this.tour)) {
                jeu.ajouterTour(this.tour);
                jeu.setArgent(this.tour.getCoutAchat());
            }
        }
    }

    public Tour getTour() {
        return tour;
    }

    public void VendreTour(ImageView i) {
        i.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                for (Tour t : this.jeu.getListeDeTour()) {
                    if (Integer.toString(t.getID()).equals(i.getId())) {
                        panneauJeu.getChildren().remove(i);
                        this.jeu.getListeDeTour().remove(t);
                        this.jeu.setArgent(-t.getCoutVente());
                        t.TourDevientInoffensif(terrain);
                    }
                }
            }
        });
    }

    public void TourCliqueee(MouseEvent mouseEvent, Tour tour, VueTour vt, jeu jeu, boolean TourPose) throws FileNotFoundException {
        TourPose = true;
        if (TourPose && tour == null && mouseEvent.getClickCount() == 2) {
            if (((ImageView) mouseEvent.getSource()).getId().equals("bombe")) {
                if (jeu.getArgent() >= 40) {
                    vt.CliqueTour(jeu, "bombe");
                    tour = vt.getTour();
                    TourPose = false;
                }
            } else if (((ImageView) mouseEvent.getSource()).getId().equals("feu")) {
                if (jeu.getArgent() >= 22) {
                    vt.CliqueTour(jeu, "feu");
                    tour = vt.getTour();
                    TourPose = false;
                }
            } else if (((ImageView) mouseEvent.getSource()).getId().equals("fleche")) {
                if (jeu.getArgent() >= 20) {
                    vt.CliqueTour(jeu, "fleche");
                    tour = vt.getTour();
                    TourPose = false;
                }
            } else if (((ImageView) mouseEvent.getSource()).getId().equals("eclair")) {
                if (jeu.getArgent() >= 60) {
                    vt.CliqueTour(jeu, "eclair");
                    tour = vt.getTour();
                    TourPose = false;

                }
            } else if (((ImageView) mouseEvent.getSource()).getId().equals("laser")) {
                if (jeu.getArgent() >= 60) {
                    vt.CliqueTour(jeu, "laser");
                    tour = vt.getTour();
                    TourPose = false;
                }
            }
        }
    }
}

