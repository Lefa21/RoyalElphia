package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.*;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueObstacle {

    private Obstacle Obstacle;
    private Pane panneauJeu;

    private double x, y;

    private Terrain terrain;

    public VueObstacle(Pane p, Obstacle T, double x, double y, Terrain terrain) {
        this.panneauJeu = p;
        this.Obstacle = T;
        this.x = x;
        this.y = y;
        this.terrain = terrain;
    }

    public VueObstacle() {
    }

    public void PoserObstacle() throws FileNotFoundException {
        int[][] tab = terrain.getTabTerrain();
        int posX = (int) this.x / 32;
        int posY = (int) this.y / 32;
        if (tab[posY][posX] == 9) {
            if (this.Obstacle instanceof BarricadeBois) {
                Image BarricadeBois = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/pont.png"));
                ImageView BarricadeBoisView = new ImageView(BarricadeBois);
                //Obstacle.rayonDegat(terrain, posX, posY, Obstacle.getDegat());
                BarricadeBoisView.setX(x - 10);
                BarricadeBoisView.setY(y - 15);
                BarricadeBoisView.setId("bois");
                panneauJeu.getChildren().add(BarricadeBoisView);
                this.Obstacle = null;
            }
            if (this.Obstacle instanceof BarricadePierre) {
                Image BarricadePierre = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/rocher.png"));
                ImageView BarricadePierreView = new ImageView(BarricadePierre);

                //Obstacle.rayonDegat(terrain, posX, posY, Obstacle.getDegat());
                BarricadePierreView.setX(x - 10);
                BarricadePierreView.setY(y - 15);
                BarricadePierreView.setId("pierre");
                panneauJeu.getChildren().add(BarricadePierreView);
                this.Obstacle = null;
                for (Node n :
                        panneauJeu.getChildren()) {
                    System.out.println(n);
                }
            }
            if (this.Obstacle instanceof BarricadeMetal) {
                Image BarricadeMetal = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/départ.png"));
                ImageView BarricadeMetalView = new ImageView(BarricadeMetal);

                //Obstacle.rayonDegat(terrain, posX, posY, Obstacle.getDegat());
                BarricadeMetalView.setX(x - 10);
                BarricadeMetalView.setY(y - 15);
                BarricadeMetalView.setId("metal");
                panneauJeu.getChildren().add(BarricadeMetalView);
                this.Obstacle = null;
                for (Node n :
                        panneauJeu.getChildren()) {
                    System.out.println(n);
                }
            }
            if (this.Obstacle instanceof BarricadeFer) {
                Image BarricadeFer = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/mur.png"));
                ImageView BarricadeFerView = new ImageView(BarricadeFer);

                //Obstacle.rayonDegat(terrain, posX, posY, Obstacle.getDegat());
                BarricadeFerView.setX(x - 45);
                BarricadeFerView.setY(y - 45);
                BarricadeFerView.setId("fer");
                panneauJeu.getChildren().add(BarricadeFerView);
                this.Obstacle = null;
                for (Node n :
                        panneauJeu.getChildren()) {
                    System.out.println(n);
                }
            }

        }
    }

    public void CliqueObstacle(jeu jeu, String typeObstacle) throws FileNotFoundException {
        if (typeObstacle.equals("bois")) {
            this.Obstacle = new BarricadeBois();
            if (jeu.verifArgentObstacle(this.Obstacle)) {
                jeu.setArgent(this.Obstacle.getCoutObstacle());
                jeu.ajouterObstacle(this.Obstacle);
            }
        }

        if (typeObstacle.equals("fer")) {
            this.Obstacle = new BarricadeFer();
            if (jeu.verifArgentObstacle(this.Obstacle)) {
                jeu.setArgent(this.Obstacle.getCoutObstacle());
                jeu.ajouterObstacle(this.Obstacle);
            }
        }

        if (typeObstacle.equals("pierre")) {
            this.Obstacle = new BarricadePierre();
            if (jeu.verifArgentObstacle(this.Obstacle)) {
                jeu.setArgent(this.Obstacle.getCoutObstacle());
                jeu.ajouterObstacle(this.Obstacle);
            }
        }

        if (typeObstacle.equals("metal")) {
            this.Obstacle = new BarricadeMetal();
            if (jeu.verifArgentObstacle(this.Obstacle)) {
                jeu.setArgent(this.Obstacle.getCoutObstacle());
                jeu.ajouterObstacle(this.Obstacle);
            }
        }
    }

    public Obstacle getObstacle() {
        return Obstacle;
    }
}
