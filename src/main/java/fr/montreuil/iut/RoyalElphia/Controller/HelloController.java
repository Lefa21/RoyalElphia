package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.Vue.TerrainVue;
import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.collections.ListChangeListener;
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

    private VueEnnemi vueEnnemi;



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
            gameLoop.play();
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

    public void PoserTour(MouseEvent mouseEvent) throws FileNotFoundException {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();

        Image herbe = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/chemin.jpg"));
        ImageView herbe2 = new ImageView(herbe);
        herbe2.setX(mouseX);
        herbe2.setY(mouseY);
        panneauJeu.getChildren().add(herbe2);
    }
}
