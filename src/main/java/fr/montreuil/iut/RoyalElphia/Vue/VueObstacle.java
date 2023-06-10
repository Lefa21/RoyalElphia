package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.*;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueObstacle {

    private Obstacle obstacle;
    private Pane panneauJeu;

    private double x, y;

    private Terrain terrain;

    private static int idObstacle = 2000;
    private static int idImage = 2000;

    private boolean trouve = false;

    private jeu jeu;

    public VueObstacle(Pane p, Obstacle T, double x, double y, Terrain terrain, jeu jeu) {
        this.panneauJeu = p;
        this.obstacle = T;
        this.x = x;
        this.y = y;
        this.terrain = terrain;
        this.jeu = jeu;
    }

    public VueObstacle() {
    }

    public void PoserObstacle() throws FileNotFoundException {
        int[][] tab = terrain.getTabTerrain();
        System.out.println("position X obstacle " + this.x);
        System.out.println("position Y obstacle " + this.y);
        int posX = (int) this.x / 32;
        int posY = (int) this.y / 32;
        System.out.println("pos x après : " + posX);
        System.out.println("pos y après " + posY);
        if (tab[posY][posX] == 9 && obstacle != null) {
            Image obstacleImage = null;

            switch (obstacle.getClass().getSimpleName()) {
                case "BarricadeBois":
                    obstacleImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/pont.png"));
                    break;
                case "BarricadeFer":
                    obstacleImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/mur.png"));
                    break;
                case "BarricadeMetal":
                    obstacleImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/départ.png"));
                    break;
                case "BarricadePierre":
                    obstacleImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/rocher.png"));
                    break;
            }

            if (obstacleImage != null) {
                ImageView obstacleImageView = new ImageView(obstacleImage);
                tab[posY][posX] = 8;
                obstacle.setPosX(posX);
                obstacle.setPosy(posY);
                obstacleImageView.setX(x - 20);
                obstacleImageView.setY(y - 15);
                System.out.println("pos x image " + obstacleImageView.getX());
                System.out.println("pos Y image " + obstacleImageView.getX());
                obstacleImageView.setId(Integer.toString(idImage));
                Label label = new Label();
                label.textProperty().bind(obstacle.getPvProperty().asString());
                label.translateXProperty().bind(obstacle.getPosXProperty().multiply(32).add(10));
                label.translateYProperty().bind(obstacle.getPosYProperty().multiply(32).add(40));
                label.setBackground(Background.fill(Color.WHITE));
                label.setId(obstacle.getID() + "L");
                idImage++;
                panneauJeu.getChildren().add(obstacleImageView);
                this.panneauJeu.getChildren().add(label);
                this.obstacle = null;
                //VendreTour(obstacleImageView);
                AmeliorationEtVente(obstacleImageView);
                }
            }
    }

    public void CliqueObstacle(jeu jeu, String typeObstacle) throws FileNotFoundException {
        Obstacle obstacle = null;
        switch (typeObstacle) {
            case "bois":
                obstacle = new BarricadeBois ();
                break;
            case "pierre":
                obstacle = new BarricadePierre();
                break;
            case "metal":
                obstacle = new BarricadeMetal();
                break;
            case "fer":
                obstacle = new BarricadeFer();
                break;
        }

        if (obstacle != null) {
            obstacle.setID(idObstacle);
            idObstacle++;
            if (jeu.verifArgent(obstacle)) {
                jeu.setArgent(obstacle.getCoutAchat());
                jeu.ajouterObstacle(obstacle);
                this.obstacle = obstacle;
            }
        }
        }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void AmeliorationEtVente(ImageView x) {
        int[][] tab = terrain.getTabTerrain();
        x.setOnMouseClicked(KeyEvent -> {
            if (KeyEvent.isAltDown()) {
                for (int i = 0; i < jeu.getListeObstacle().size(); i++) {
                    Obstacle o = jeu.getListeObstacle().get(i);
                    if (o.getNiveauAmelioration() != o.getNiveauMaxAmelioration()) {
                        if (o.getCoutAmelioration() <= jeu.getArgent()) {
                            jeu.setArgent(o.getCoutAmelioration());
                            o.setNiveauAmelioration(o.getNiveauAmelioration() + 1);
                            o.setPointDeVie((int)(o.getPointDeVie()* 1.5 ));
                            o.setCoutAmelioration((int) (o.getCoutAmelioration() * 1.5));
                        }
                    } else
                        System.out.println("niv MAX");
                }
            } else {
                x.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2 && !trouve) {
                        for (int j = 0; j < this.jeu.getListeObstacle().size(); j++) {
                            Obstacle o = this.jeu.getListeObstacle().get(j);

                            if (Integer.toString(o.getID()).equals(x.getId())) {
                                panneauJeu.getChildren().remove(x);
                                tab[o.getPosY()][o.getPosX()] = 9;
                                this.jeu.getListeObstacle().remove(o);
                                this.jeu.setArgent(-o.getCoutVente());
                                trouve = true;
                            }
                        }
                    }
                });
            }
        });

    }
}

