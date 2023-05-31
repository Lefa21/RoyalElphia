package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.Vue.*;
import fr.montreuil.iut.RoyalElphia.modele.*;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.ListObsEnnemis;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import javafx.collections.ListChangeListener;
import javafx.event.Event;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class HelloController implements Initializable {

 private Terrain terrain;
@FXML
 private TilePane map;
private jeu jeu;

    @FXML
    public Label LabelArgent;

    @FXML
    public Label LabelPV;
    @FXML
    private Pane panneauJeu;

    private VueEnnemi vueEnnemi;

    private Tour tour;

    private boolean TourPose = true;

    private VueTour vt = new VueTour();
    @FXML
   /* public void CliqueTourABombe(MouseEvent mouseEvent) throws FileNotFoundException {
        if (this.TourPose){
            System.out.println("tour cliqué");
            this.tour = new TourABombe();
            VueTour vt = new VueTour();
            vt.CliqueTour(jeu, tour);
            this.TourPose = false;
        }
    }

    public void CliqueTourFeu(MouseEvent mouseEvent) throws FileNotFoundException {
        System.out.println(((ImageView)mouseEvent.getSource()).getId());

        if (this.TourPose) {
            System.out.println("tour cliqué");
            this.tour = new TourBouleDeFeu();
            VueTour vt = new VueTour();
            vt.CliqueTour(jeu, tour);
            this.TourPose = false;
        }
    }

    public void CliqueTourFleche(MouseEvent mouseEvent) throws FileNotFoundException {
        if (this.TourPose) {
            System.out.println("tour cliqué");
            this.tour = new TourFleche();
            VueTour vt = new VueTour();
            vt.CliqueTour(jeu, tour);
            this.TourPose = false;
        }
    }*/

    public void TourClique(MouseEvent mouseEvent) throws FileNotFoundException {
        for (Tour T:
                this.jeu.getListeDeTour()) {
            System.out.println(T);
        }
        //this.tour = null;
        if (this.TourPose && tour == null) {
            if (((ImageView) mouseEvent.getSource()).getId().equals("bombe")) {
                if (this.jeu.getArgent() >= 40){
                vt.CliqueTour(this.jeu, "bombe");
                this.tour = vt.getTour();
                this.TourPose = false;}
            } else if (((ImageView) mouseEvent.getSource()).getId().equals("feu")) {
                if (this.jeu.getArgent() >= 22){
                vt.CliqueTour(this.jeu, "feu");
                this.tour = vt.getTour();
                this.TourPose = false;}
            } else if (((ImageView) mouseEvent.getSource()).getId().equals("fleche")) {
                if (this.jeu.getArgent() >= 20){
                    vt.CliqueTour(this.jeu, "fleche");
                    this.tour = vt.getTour();
                    this.TourPose = false;}
            } /*else if (((ImageView) mouseEvent.getSource()).getId().equals("eclair")) {
                this.tour = new TourElectrique();
                vt.CliqueTour(jeu, tour);
                this.TourPose = false;
            }*/
        }
    }
    @FXML
    public void PoserTour(MouseEvent mouseEvent) throws FileNotFoundException {
        double cliqueX = mouseEvent.getX();
        double cliqueY = mouseEvent.getY();
        VueTour vueTour = new VueTour(panneauJeu, tour, cliqueX, cliqueY);
        vueTour.PoserTour();
        this.TourPose = true;
        this.tour=null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.terrain = new Terrain(40, 30) {
            };
            this.jeu = new jeu(this.terrain,10,2,2,2,2,2);
            this.LabelPV.textProperty().bind(this.jeu.getPvJoueurProperty().asString());
            TerrainVue terrainVue = new TerrainVue(terrain,map);
            //demarre l'animation
            jeu.initAnimation();
            ListChangeListener<Ennemis> listenerEnnemis = new ListObsEnnemis(this.jeu,this.panneauJeu);
            jeu.getEnnemis().addListener(listenerEnnemis);
            this.LabelArgent.textProperty().bind(this.jeu.getArgentProperty().asString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void Demarrer(Event event) {
        jeu.lancementLoop();
    }

}

