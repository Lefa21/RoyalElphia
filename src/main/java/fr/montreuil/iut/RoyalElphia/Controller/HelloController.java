package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.Vue.TerrainVue;
import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;

import fr.montreuil.iut.RoyalElphia.modele.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.collections.ListChangeListener;
import javafx.event.Event;

import fr.montreuil.iut.RoyalElphia.modele.*;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Button;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class HelloController implements Initializable {

    @FXML
    public Label LabelArgent;

    private Terrain terrain;
    @FXML
    private TilePane map;

    private jeu jeu;

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
        listeTour.add(this.tour);
        Image tour = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/tt-PhotoRoom.png-PhotoRoom.png"));
        ImageView tour1 = new ImageView(tour);
        tour1.setFitWidth(80);
        tour1.setFitHeight(95);
        tour1.setX(25 + (int)(Math.random() * ((540- 25) + 1)));
        tour1.setY(25 + (int)(Math.random() * ((540- 25) + 1)));
        panneauJeu.getChildren().add(tour1);
    }


private void initAnimation() {
    gameLoop = new Timeline();
    temps=0;
    gameLoop.setCycleCount(Timeline.INDEFINITE);


    KeyFrame kf = new KeyFrame(
            // on définit le FPS (nbre de frame par seconde)


            Duration.seconds(0.03),

            // on définit ce qui se passe à chaque frame
            // c'est un eventHandler d'ou le lambda
            (ev ->{
                if(jeu.getEnnemisTué().size() == jeu.getNbEnnemisMax()){
                    System.out.println("fini");
                    gameLoop.stop();
                }
                else if (temps%3 ==0){
                    jeu.unTour();
                } else if (temps%5 == 0) {
                    if(this.jeu.getEnnemis().size() < this.jeu.getNbEnnemisMax()){
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
            this.jeu = new jeu(this.terrain,10);

            TerrainVue terrainVue = new TerrainVue(terrain,map);
            // demarre l'animation

            initAnimation();
            ListChangeListener<Ennemis> listenerEnnemis = (c -> {

                while (c.next()) {
                    if(c.wasAdded()){
                        for (Ennemis a : c.getAddedSubList()
                        ) {
                            VueEnnemi vueEnnemi1 = new VueEnnemi(panneauJeu);
                            vueEnnemi1.créerSprite(a);
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


    @FXML
    public void Demarrer(Event event) {
    gameLoop.play();
    }

}
