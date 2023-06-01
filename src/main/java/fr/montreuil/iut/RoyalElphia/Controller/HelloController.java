package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.Vue.*;
import fr.montreuil.iut.RoyalElphia.modele.*;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Map.Map2;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Facile;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Niveau;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;
import fr.montreuil.iut.RoyalElphia.modele.Tour.TourABombe;
import javafx.collections.ListChangeListener;
import javafx.event.Event;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;


import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class HelloController implements Initializable {

 private Terrain terrain;
@FXML
 private TilePane map;
private jeu jeu;
private Niveau niveau;

    @FXML
    public Label LabelArgent;

    @FXML
    public Label LabelPV;
    @FXML
    private Pane panneauJeu;

    private VueEnnemi vueEnnemi;

    private Tour tour;

    private ArrayList<Tour> listeTour = new ArrayList<>();

    public void CliqueTourABombe(MouseEvent mouseEvent) throws FileNotFoundException {
        System.out.println("tour cliqué");
        this.tour = new TourABombe();
        this.jeu.ajouterTour(this.tour);
        if(this.jeu.verifArgent(this.tour)){ this.jeu.setArgent(tour.getCoutAchat());}
    }
    @FXML
    public void PoserTour(MouseEvent mouseEvent) throws FileNotFoundException {
        double cliqueX = mouseEvent.getX();
        double cliqueY = mouseEvent.getY();
        VueTour vueTour = new VueTour(panneauJeu, tour, cliqueX, cliqueY);
        vueTour.PoserTour();
        this.tour = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            this.terrain = new Map2() {
            };
            this.niveau = new Facile();
            this.jeu = new jeu(this.terrain,this.niveau);
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

