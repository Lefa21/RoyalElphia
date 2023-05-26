package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.Vue.*;
import fr.montreuil.iut.RoyalElphia.modele.*;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import fr.montreuil.iut.RoyalElphia.modele.GéantRoyal;


import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
public class HelloController implements Initializable {

 private Terrain terrain;
@FXML
 private TilePane map;
private jeu jeu;

    @FXML
    private Pane panneauJeu;

    private Timeline gameLoop;

    private int temps;



private void initAnimation() {
    gameLoop = new Timeline();
    temps=0;
    gameLoop.setCycleCount(Timeline.INDEFINITE);


    KeyFrame kf = new KeyFrame(
            // on définit le FPS (nbre de frame par seconde)
            Duration.seconds(0.03),
            // on définit ce qui se passe à chaque frame
            // c'est un eventHandler d'ou le lambda

            // si le nombre d'ennemis tué est égal au nombre d'ennemis de la vague alors la vague est terminé
            (ev ->{
                if(jeu.getEnnemisTué().size() == jeu.getNbEnnemisMax()){
                    System.out.println("fini");
                    gameLoop.stop();
                }
                else if (temps%3 ==0){
                    jeu.unTour();
                } else if (temps%5 == 0) {
                    // si la liste des ennemis ayant spawn est inférieur au nombre d'ennemis max alors on fait spawn un nouvel ennemis
                    if(this.jeu.getListeEnnemisSpawn().size() < this.jeu.getNbEnnemisMax()){
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
            this.terrain = new Terrain(20,20);
            this.jeu = new jeu(this.terrain,10,2,2,2,2,2);
            TerrainVue terrainVue = new TerrainVue(terrain,map);
            // demarre l'animation

            initAnimation();
            gameLoop.play();
            ListChangeListener<Ennemis> listenerEnnemis = (c -> {

                while (c.next()) {
                    if(c.wasAdded()){
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
            } );

            jeu.getEnnemis().addListener(listenerEnnemis);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
