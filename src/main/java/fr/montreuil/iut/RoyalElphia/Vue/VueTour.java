package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueTour {

    private Tour tour;
    private Pane panneauJeu;

    private double x, y;

    private Terrain terrain;

    public VueTour(Pane p, Tour T, double x, double y, Terrain terrain) {
        this.panneauJeu = p;
        this.tour = T;
        this.x = x;
        this.y = y;
        this.terrain = terrain;
    }

    public VueTour() {

    }


    public void PoserTour() throws FileNotFoundException {
        int[][] tab = terrain.getTabTerrain();
        int posX = (int) this.x/32;
        int posY = (int) this.y/32;
        if (tab[posY][posX]==7){
            if (this.tour instanceof TourABombe) {
                Image TourBombe = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/tt-PhotoRoom.png-PhotoRoom(2).png"));
                ImageView TourBombeView = new ImageView(TourBombe);
                TourBombeView.setX(x-10);
                TourBombeView.setY(y-15);
                panneauJeu.getChildren().add(TourBombeView);
                this.tour = null;
            }
            if (this.tour instanceof TourBouleDeFeu) {
                Image TourFeu = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TourFeuTerrain.png"));
                ImageView TourFeuView = new ImageView(TourFeu);
                TourFeuView.setX(x-10);
                TourFeuView.setY(y-15);
                panneauJeu.getChildren().add(TourFeuView);
                this.tour = null;
            }
            if (this.tour instanceof TourFleche) {
                Image TourFleche = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TourFlecheM.png"));
                ImageView TourFlecheView = new ImageView(TourFleche);
                TourFlecheView.setX(x-10);
                TourFlecheView.setY(y-15);
                panneauJeu.getChildren().add(TourFlecheView);
                this.tour = null;
            }
            if (this.tour instanceof TourElectrique) {
                Image TourElec = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TourEclairM.png"));
                ImageView TourElecView = new ImageView(TourElec);
                TourElecView.setX(x-45);
                TourElecView.setY(y-45);
                panneauJeu.getChildren().add(TourElecView);
                this.tour = null;
            }
        }

    }

    public void CliqueTour(jeu jeu, String TypeTour) throws FileNotFoundException {
        System.out.println("tour cliqué");
        if (TypeTour.equals("bombe")) {
            this.tour = new TourABombe();
            if (jeu.verifArgent(this.tour)) {
                jeu.setArgent(this.tour.getCoutAchat());
                jeu.ajouterTour(this.tour);
            }
        }
        if (TypeTour.equals("feu")) {
            this.tour = new TourBouleDeFeu();
            if (jeu.verifArgent(this.tour)) {
                jeu.ajouterTour(this.tour);
                jeu.setArgent(this.tour.getCoutAchat());
            }
        }
        if (TypeTour.equals("fleche")) {
            this.tour = new TourFleche();
            if (jeu.verifArgent(this.tour)) {
                jeu.ajouterTour(this.tour);
                jeu.setArgent(this.tour.getCoutAchat());
            }
        }
        if (TypeTour.equals("eclair")) {
            this.tour = new TourElectrique();
            if (jeu.verifArgent(this.tour)) {
                jeu.ajouterTour(this.tour);
                jeu.setArgent(this.tour.getCoutAchat());
            }
        }
    }

    public Tour getTour() {
        return tour;
    }
}
