package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.HelloApplication;
import fr.montreuil.iut.RoyalElphia.Vue.*;
import fr.montreuil.iut.RoyalElphia.modele.*;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Map.Map2;
import fr.montreuil.iut.RoyalElphia.modele.Map.Map_1;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

import fr.montreuil.iut.RoyalElphia.modele.Niveau.Difficile;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Facile;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Niveau;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Normal;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.*;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;


import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.scene.shape.Circle;

import javafx.stage.Stage;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private Terrain terrain;
    @FXML
    private TilePane map;

    @FXML
    private VBox menuEnnemi;

    private jeu jeu;
    private Niveau niveau;

    @FXML
    public Label LabelPV, LabelnbEnnemisRestant, LabelArgent, LabelVague, LabelMort;
    @FXML
    private Pane panneauJeu;
    private VueEnnemi vueEnnemi;

    private Tour tour;
    private Obstacle obstacle;
    private boolean TourPose = true;
   // private Boolean ItemPose = true;

    // private Boolean ItemPose = true;

    private boolean ObstaclePose = true;
    private VueTour vt = new VueTour();
    private VueObstacle vo = new VueObstacle();

    @FXML
    public void cliqueObstacle(MouseEvent mouseEvent) throws FileNotFoundException {
        if (this.ObstaclePose && obstacle == null && mouseEvent.getClickCount() == 2) {
            System.out.println("clique obstacle ");
            String imageId = ((ImageView) mouseEvent.getSource()).getId();
            fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle obstacle = null;

            switch (imageId) {
                case "bois":
                    obstacle = new BarricadeBois();
                    break;
                case "fer":
                    obstacle = new BarricadeFer();
                    break;
                case "metal":
                    obstacle = new BarricadeMetal();
                    break;
                case "pierre":
                    obstacle = new BarricadePierre();
                    break;
            }
            if (obstacle != null && jeu.verifArgentObstacle(obstacle)) {
                vo.CliqueObstacle(this.jeu, imageId);
                this.obstacle = vo.getObstacle();
                this.ObstaclePose = false;
            }
        }
    }

    @FXML
    public void TourClique(MouseEvent mouseEvent) {
        if (this.TourPose && tour == null && mouseEvent.getClickCount() == 2) {
            System.out.println("clique tour");
            String imageId = ((ImageView) mouseEvent.getSource()).getId();
            Tour tour = null;

            switch (imageId) {
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
            if (tour != null && jeu.verifArgent(tour)) {
                System.out.println();
                vt.CliqueTour(this.jeu, imageId);
                this.tour = vt.getTour();
                this.TourPose = false;
            }
        }
    }
    @FXML
    public void poserItem(MouseEvent mouseEvent) throws FileNotFoundException {
        if(this.obstacle != null){
            double cliqueX = mouseEvent.getX();
            double cliqueY = mouseEvent.getY();
            System.out.println("obstacle poser ");
            VueObstacle vueObstacle = new VueObstacle(panneauJeu, obstacle, cliqueX, cliqueY, terrain,jeu);
            vueObstacle.PoserObstacle();
            this.ObstaclePose = true;
            this.obstacle = vueObstacle.getObstacle();
        }
        if(this.tour != null){
            System.out.println("tour poser");
            double cliqueX = mouseEvent.getX();
            double cliqueY = mouseEvent.getY();
            VueTour vueTour = new VueTour(panneauJeu, tour, cliqueX, cliqueY, terrain, jeu);
            vueTour.PoserTour();
            this.TourPose = true;
            this.tour = vueTour.getTour();
        }
        }


    public void PoserTour(MouseEvent mouseEvent) throws FileNotFoundException {
        double cliqueX = mouseEvent.getX();
        double cliqueY = mouseEvent.getY();
        VueTour vueTour = new VueTour(panneauJeu, tour, cliqueX, cliqueY, terrain, jeu);
        vueTour.PoserTour();
        this.TourPose = true;
        this.tour = vueTour.getTour();
    }


    public void créerNiveau(){
        int niveau = SceneController.getNiveau();
        if (niveau == 1) {
            this.niveau = new Facile();
        } else if (niveau == 2) {
            this.niveau = new Normal();
        } else if (niveau == 3) {
            this.niveau = new Difficile();
        }
    }

    public void créerTerrain() {
        int terrain = SceneController.getTerrain();
        if (terrain == 1) {
            this.terrain = new Map_1();
        } else if (terrain == 2) {
            this.terrain = new Map2();
        }
    }

    public void créationPartie() {
        créerNiveau();
        créerTerrain();
        this.jeu = new jeu(this.terrain, this.niveau,this.menuEnnemi);
    }

    @FXML
    public void BoutonCaracteristiques(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Caractéristiques des tours");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/CaracteristiquesTours.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {

            créationPartie();

            //demarre l'animation
            jeu.initAnimation();
            TerrainVue terrainVue = new TerrainVue(terrain, map);
            this.LabelVague.textProperty().bind(this.jeu.getNbVagueProperty().asString());
            this.LabelArgent.textProperty().bind(this.jeu.getArgentProperty().asString().concat(" $"));
            this.LabelPV.textProperty().bind(this.jeu.getPvJoueurProperty().asString().concat(" pv"));
            this.LabelnbEnnemisRestant.textProperty().bind(this.jeu.nbEnnemisRestantProperty().asString());
            this.LabelMort.textProperty().bind(this.jeu.ComptEnnemiTueProperty().asString());

            ListChangeListener<Ennemis> listenerEnnemis = new ListObsEnnemis(this.jeu, this.panneauJeu);
            jeu.getEnnemis().addListener(listenerEnnemis);

            ListChangeListener<Obstacle> listenerObstacle = new ListObservableObstacle(this.jeu, this.panneauJeu);
            jeu.getListeObstacle().addListener(listenerObstacle);

            ListChangeListener<Tour> listenerTour = new ListObservableTour(this.jeu, this.panneauJeu);
            jeu.getListeDeTour().addListener(listenerTour);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void Demarrer(Event event) {
        jeu.lancementLoop();
    }

    @FXML
    public void Pause(Event event) {
        jeu.arretLoop();
    }

    public void Rejouer(ActionEvent actionEvent) throws IOException{
      // Stage stage =  SceneController.fermetureStage();
        //stage.close();
        Stage newWindow = new Stage();
        newWindow.setTitle("Paramètres de ma partie");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Page_Fxml/ChoixMap.fxml"));
        newWindow.setScene(new Scene(loader.load()));

        newWindow.show();
        ((Stage)  LabelPV.getScene().getWindow()).close();
    }
}

