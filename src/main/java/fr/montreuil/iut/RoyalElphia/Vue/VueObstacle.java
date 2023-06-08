package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.*;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
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

    private static int idObstacle = 2000;
    private static int idImage = 2000;

    private jeu jeu;

    public VueObstacle(Pane p, Obstacle T, double x, double y, Terrain terrain,jeu jeu) {
        this.panneauJeu = p;
        this.Obstacle = T;
        this.x = x;
        this.y = y;
        this.terrain = terrain;
        this.jeu = jeu;
    }

    public VueObstacle() {
    }

    public void PoserObstacle() throws FileNotFoundException {
        for (int i = 0; i < this.jeu.getListeObstacle().size(); i++) {
            System.out.println("Taille de la liste  : " + this.jeu.getListeObstacle().size());
        }
        int[][] tab = terrain.getTabTerrain();
        int posX = (int) this.x / 32;
        int posY = (int) this.y / 32;
        if (tab[posY][posX] == 9) {
            if (this.Obstacle instanceof BarricadeBois) {
                tab[posY][posX] = 8;
                Obstacle.setPosX(posX);
                Obstacle.setPosY(posY);
                Image BarricadeBois = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/pont.png"));
                ImageView BarricadeBoisView = new ImageView(BarricadeBois);
                BarricadeBoisView.setX(x - 10);
                BarricadeBoisView.setY(y - 15);
                BarricadeBoisView.setId(Integer.toString(idImage));
                System.out.println("Id de barricade bois : " + BarricadeBoisView.getId());
                idImage++;
                panneauJeu.getChildren().add(BarricadeBoisView);
                this.Obstacle = null;
                VendreObstacle(BarricadeBoisView);
            }
            if (this.Obstacle instanceof BarricadePierre) {
                tab[posY][posX] = 8;
                Obstacle.setPosX(posX);
                Obstacle.setPosY(posY);
                Image BarricadePierre = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/rocher.png"));
                ImageView BarricadePierreView = new ImageView(BarricadePierre);
                BarricadePierreView.setX(x - 10);
                BarricadePierreView.setY(y - 15);
                BarricadePierreView.setId(Integer.toString(idImage));
                idImage++;
                panneauJeu.getChildren().add(BarricadePierreView);
                this.Obstacle = null;
                VendreObstacle(BarricadePierreView);
            }
            if (this.Obstacle instanceof BarricadeMetal) {
                  tab[posY][posX] = 8;
                Obstacle.setPosX(posX);
                Obstacle.setPosY(posY);
                Image BarricadeMetal = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/départ.png"));
                ImageView BarricadeMetalView = new ImageView(BarricadeMetal);
                BarricadeMetalView.setX(x - 10);
                BarricadeMetalView.setY(y - 15);
                BarricadeMetalView.setId(Integer.toString(idImage));
                panneauJeu.getChildren().add(BarricadeMetalView);
                this.Obstacle = null;
                VendreObstacle(BarricadeMetalView);
            }
            if (this.Obstacle instanceof BarricadeFer) {
                tab[posY][posX] = 8;
                Obstacle.setPosX(posX);
                Obstacle.setPosY(posY);
                Image BarricadeFer = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Page_Fxml/mur.png"));
                ImageView BarricadeFerView = new ImageView(BarricadeFer);
                BarricadeFerView.setX(x - 45);
                BarricadeFerView.setY(y - 45);
                BarricadeFerView.setId("fer");
                BarricadeFerView.setId(Integer.toString(idImage));
                idImage++;
                panneauJeu.getChildren().add(BarricadeFerView);
                this.Obstacle = null;
                VendreObstacle(BarricadeFerView);
            }

        }
    }

    public void CliqueObstacle(jeu jeu, String typeObstacle) throws FileNotFoundException {
        if (typeObstacle.equals("bois")) {
            this.Obstacle = new BarricadeBois();
            this.Obstacle.setID(idObstacle);
            System.out.println("Id de l'obstacle dans le modèle : " + this.Obstacle.getID());
            idObstacle++;
            if (jeu.verifArgent(this.Obstacle)) {
                System.out.println("Ajout de l'obstacle à la liste ");
                jeu.setArgent(this.Obstacle.getCoutAchat());
                jeu.ajouterObstacle(this.Obstacle);
                System.out.println("Liste d'obstacle : "  + jeu.getListeObstacle().toString());
            }
        }

        if (typeObstacle.equals("fer")) {
            this.Obstacle = new BarricadeFer();
            this.Obstacle.setID(idObstacle);
            System.out.println("Id de l'obstacle dans le modèle : " + this.Obstacle.getID());
            idObstacle++;
            if (jeu.verifArgent(this.Obstacle)) {
                System.out.println("Ajout de l'obstacle à la liste ");
                jeu.setArgent(this.Obstacle.getCoutAchat());
                jeu.ajouterObstacle(this.Obstacle);
                System.out.println("Liste d'obstacle : "  + jeu.getListeObstacle().toString());
            }
        }

        if (typeObstacle.equals("pierre")) {
            this.Obstacle = new BarricadePierre();
            this.Obstacle.setID(idObstacle);
            System.out.println("Id de l'obstacle dans le modèle : " + this.Obstacle.getID());
            idObstacle++;
            if (jeu.verifArgent(this.Obstacle)) {
                System.out.println("Ajout de l'obstacle à la liste ");
                jeu.setArgent(this.Obstacle.getCoutAchat());
                jeu.ajouterObstacle(this.Obstacle);
                System.out.println("Liste d'obstacle : "  + jeu.getListeObstacle().toString());
            }
        }

        if (typeObstacle.equals("metal")) {
            this.Obstacle = new BarricadeMetal();
            this.Obstacle.setID(idObstacle);
            System.out.println("Id de l'obstacle dans le modèle : " + this.Obstacle.getID());
            idObstacle++;
            if (jeu.verifArgent(this.Obstacle)) {
                System.out.println("Ajout de l'obstacle à la liste ");
                jeu.setArgent(this.Obstacle.getCoutAchat());
                jeu.ajouterObstacle(this.Obstacle);
                System.out.println("Liste d'obstacle : "  + jeu.getListeObstacle().toString());
            }
        }
    }
    public Obstacle getObstacle() {
        return Obstacle;
    }

    public void VendreObstacle(ImageView i){
        int[][] tab = terrain.getTabTerrain();
        i.setOnMouseClicked(event -> {
            if (event.getClickCount()==2){
                for (Obstacle o: this.jeu.getListeObstacle()) {
                    if (Integer.toString(o.getID()).equals(i.getId())){
                        panneauJeu.getChildren().remove(i);
                        tab[o.getPosY()][o.getPosX()] = 9;
                        this.jeu.getListeObstacle().remove(o);
                        System.out.println("Liste d'obstacle : " + this.jeu.getListeObstacle().toString());
                        System.out.println();
                        this.jeu.setArgent(-o.getCoutVente());
                    }
                }}});}
}

