package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.Vue.*;
import fr.montreuil.iut.RoyalElphia.modele.*;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;
import fr.montreuil.iut.RoyalElphia.modele.Tour.TourABombe;
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

    private ArrayList<Tour> listeTour = new ArrayList<>();

    @FXML

    public void CliqueTourABombe(MouseEvent mouseEvent) throws FileNotFoundException {
        System.out.println("tour cliqué");
        this.tour = new TourABombe();
        if (listeTour.size() < 2) {
            listeTour.add(this.tour);
        }
    }
    public void PoserTour(MouseEvent mouseEvent) throws FileNotFoundException {
        double cliqueX = mouseEvent.getX();
        double cliqueY = mouseEvent.getY();
        if (cliqueX <= 960 && cliqueY <= 1280) {
            for (Tour t : (listeTour)) {
                Image TourBombe = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/tt-PhotoRoom.png-PhotoRoom(2).png"));
                ImageView TourBombeView = new ImageView(TourBombe);
                TourBombeView.setX(cliqueX);
                TourBombeView.setY(cliqueY);
                panneauJeu.getChildren().add(TourBombeView);
                listeTour.remove(t);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            this.terrain = new Terrain(40, 30) {
            };
            this.jeu = new jeu(this.terrain,10,2,2,2,2,2);
            this.LabelPV.textProperty().bind(this.jeu.getPvJoueurProperty().asString());
            TerrainVue terrainVue = new TerrainVue(terrain,map);

            // demarre l'animation

            jeu.initAnimation();
            ListChangeListener<Ennemis> listenerEnnemis = (c -> {

                while (c.next()) {
                    if (c.wasAdded()) {
                        for (Ennemis a : c.getAddedSubList()
                        ) {
                            VueEnnemi vueEnm = new VueEnnemi(panneauJeu);
                            vueEnm.créerSprite(a);
                        }
                    } else if (c.wasRemoved()) {
                        for (Ennemis a : c.getRemoved()
                        ) {

                            jeu.ajoutEnnemisMort(a);
                            panneauJeu.getChildren().remove((panneauJeu.lookup("#" + a.getId())));
                        }
                    }
                }
            });

            jeu.getEnnemis().addListener(listenerEnnemis);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    public void Demarrer(Event event) {
        jeu.lancementLoop();
    }

}

