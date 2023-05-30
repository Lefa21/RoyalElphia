package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.Vue.*;
import fr.montreuil.iut.RoyalElphia.modele.*;
import javafx.collections.ListChangeListener;
import javafx.event.Event;

import fr.montreuil.iut.RoyalElphia.modele.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.Pane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import fr.montreuil.iut.RoyalElphia.modele.GéantRoyal;


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
    private Pane panneauJeu;

    private Timeline gameLoop;

    private int temps;



    private VueEnnemi vueEnnemi;

    private Tour tour;

    private ArrayList<Tour> listeTour = new ArrayList<>();


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

    private void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);


        KeyFrame kf = new KeyFrame(
                // on définit le FPS (nbre de frame par seconde)
                Duration.seconds(0.03),
                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda
                (ev -> {
                    if (jeu.getEnnemisTué().size() == jeu.getNbEnnemisMax()) {
                        System.out.println("fini");
                        gameLoop.stop();
                    } else if (temps % 3 == 0) {
                        jeu.unTour();
                    } else if (temps % 5 == 0) {
                        if (this.jeu.getEnnemis().size() < this.jeu.getNbEnnemisMax()) {
                            System.out.println("Un tour");
                            jeu.spwanEnnemi();
                        }
                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            this.terrain = new Terrain(40, 30) {
            };
            this.jeu = new jeu(this.terrain,10,2,2,2,2,2);
            TerrainVue terrainVue = new TerrainVue(terrain,map);

            // demarre l'animation

            initAnimation();
            ListChangeListener<Ennemis> listenerEnnemis = (c -> {

                while (c.next()) {
                    if (c.wasAdded()) {
                        for (Ennemis a : c.getAddedSubList()
                        ) {
                            if(a instanceof gobelins){
                                VueEnnemi vueGob = new VueGobelins(panneauJeu);
                                vueGob.créerSprite(a);
                            }
                            else if (a instanceof Sorcières) {
                                VueEnnemi vueSorcieres = new VueSorcières(panneauJeu);
                                vueSorcieres.créerSprite(a);
                            }
                            else if (a instanceof Squelette) {
                                VueEnnemi vueSquelette = new VueSquelette(panneauJeu);
                                vueSquelette.créerSprite(a);
                            }

                            else if (a instanceof GéantRoyal) {
                                VueEnnemi vueGeantRoyale = new VueGeantRoyale(panneauJeu);
                                vueGeantRoyale.créerSprite(a);
                            }

                            else if (a instanceof Géant) {
                                VueEnnemi VueGéant = new VueGeant(panneauJeu);
                                VueGéant.créerSprite(a);
                            }

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
    gameLoop.play();
    }

}

