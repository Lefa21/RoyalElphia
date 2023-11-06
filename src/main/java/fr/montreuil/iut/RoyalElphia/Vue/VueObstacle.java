package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.*;
import fr.montreuil.iut.RoyalElphia.modele.Jeu;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


//La classe vueObstacle permet de créer la vue de l'obstacle qui a été créer lors du clique sur lui.

public class VueObstacle {

    private Obstacle obstacle;
    private Pane panneauJeu;

    private double x, y;

    private Terrain terrain;

    private static int idObstacle = 2000;
    private static int idImage = 2000;

    private boolean trouve = false;

    private Jeu jeu;

    public VueObstacle(Pane p, Obstacle T, double x, double y, Terrain terrain, Jeu jeu) {
        this.panneauJeu = p;
        this.obstacle = T;
        this.x = x;
        this.y = y;
        this.terrain = terrain;
        this.jeu = jeu;
    }

    public VueObstacle() {
    }

    // La méthode pose obstacle récupère la position de l'obstacle et vérifie si celui-ci a été poser sur le chemin ou se déplace les ennemis
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

                    obstacleImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageObstacle/mur.png"));
                    break;
                case "BarricadeFer":
                    obstacleImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageObstacle/fer.png"));

                    break;
                case "BarricadeMetal":
                    obstacleImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageObstacle/metal.png"));
                    break;
                case "BarricadePierre":
                    obstacleImage = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageObstacle/rocher.png"));
                    break;
            }
//Lorsque l'image de l'obstacle a été créer alors on modifie la valeur du terrain dans le tableau à cette emplacement puis ajoute l'obstacle à la vue.

            if (obstacleImage != null) {
                ImageView obstacleImageView = new ImageView(obstacleImage);
                tab[posY][posX] = 8;
                obstacle.setPosX(posX);
                obstacle.setPosy(posY);
                obstacleImageView.setX(x - 20);
                obstacleImageView.setY(y - 15);
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

                AmeliorationEtVente(obstacleImageView);
                }
            }
    }

    // Lors du clique sur l'obstacle on créer l'obstacle.
    //On l'ajoute à notre liste d'obstacle.
    public void CliqueObstacle(Jeu jeu, String typeObstacle) throws FileNotFoundException {
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
            if (jeu.verifArgentObstacle(obstacle)) {
                jeu.setArgent(obstacle.getCoutAchat());
                jeu.ajouterObstacle(obstacle);
                this.obstacle = obstacle;
            }
        }
        }

    public Obstacle getObstacle() {
        return obstacle;
    }


    // La méthode améliorationEtVente, améliore un obstacle lors d'un alt clique droit et augmente les points de vie ainsi que le niveau d'amélioration.
    // Le cout d'amélioration augmente à son tour.


    public void AmeliorationEtVente(ImageView x) {
        int[][] tab = terrain.getTabTerrain();
        x.setOnMouseClicked(KeyEvent -> {
            if (KeyEvent.isAltDown()) {
                for (int i = 0; i < jeu.getListeObstacle().size(); i++) {
                    Obstacle o = jeu.getListeObstacle().get(i);
                    if (Integer.toString(o.getID()).equals(x.getId())){
                        if (o.getNiveauAmelioration() != o.getNiveauMaxAmelioration()) {
                            if (o.getCoutAmelioration() <= jeu.getArgent()) {
                                jeu.setArgent(o.getCoutAmelioration());
                                o.setNiveauAmelioration(o.getNiveauAmelioration() + 1);
                                o.setPointDeVie((int) (o.getPointDeVie() * 1.5));
                                o.setCoutAmelioration((int) (o.getCoutAmelioration() * 1.5));
                            }
                        } else
                            System.out.println("niv MAX");
                }
                }
            }
            // si l'utilisateur double click sur l'obstacle afin de l'enlever du chemin, alors on parcours la liste d'obstacle afin de chercher l'obstacle correspondant
            //On l'enlève par la suite du panneau, puis la case où il était placé redeviens une case chemin
            //L'obstacle est enlever de la liste d'obstacle par la même occasion
            else {
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

