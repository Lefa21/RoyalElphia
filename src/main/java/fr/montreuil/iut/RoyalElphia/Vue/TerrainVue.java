package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class TerrainVue {
    public TerrainVue(Terrain Terrain, TilePane map) throws FileNotFoundException {
        int[][] tab = Terrain.getTabTerrain();

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (tab[i][j] == 4) {
                    Image herbe = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/herbe2.png"));
                    ImageView herbe2 = new ImageView(herbe);
                    map.getChildren().add(herbe2);
                } else if (tab[i][j] == 1) {
                    Image départ = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/pointDep.jpg"));
                    ImageView départ2 = new ImageView(départ);
                    map.getChildren().add(départ2);
                } else if (tab[i][j] == 2) {
                    Image arrivé = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/pointArv.jpg"));
                    ImageView arrivé2 = new ImageView(arrivé);
                    map.getChildren().add(arrivé2);
                } else if (tab[i][j] == 7) {
                    Image contour = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/contour.png"));
                    ImageView contour2 = new ImageView(contour);
                    map.getChildren().add(contour2);
                } else if (tab[i][j] == 9) {
                    Image chemin = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/chemin2.png"));
                    ImageView chemin2 = new ImageView(chemin);
                    map.getChildren().add(chemin2);
                } else if (tab[i][j] == 3) {
                    Image eau = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/eau.png"));
                    ImageView eau2 = new ImageView(eau);
                    map.getChildren().add(eau2);
                } else if (tab[i][j] == 8) {
                    Image pont = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageObstacle/pont.png"));
                    ImageView pont2 = new ImageView(pont);
                    map.getChildren().add(pont2);
                } else if (tab[i][j] == 10) {
                    Image rocher = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/eau-overlay.png"));
                    ImageView rocher2 = new ImageView(rocher);
                    map.getChildren().add(rocher2);
                } else if (tab[i][j] == 5) {
                    Image mur = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageObstacle/mur.png"));
                    ImageView mur2 = new ImageView(mur);
                    map.getChildren().add(mur2);
                } else if (tab[i][j] == 15) {
                    Image départ = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageObstacle/départ.png"));
                    ImageView départ2 = new ImageView(départ);
                    map.getChildren().add(départ2);
                } else if (tab[i][j] == 88) {
                    Image t = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TEST.png"));
                    ImageView t2 = new ImageView(t);
                    map.getChildren().add(t2);
                }
            }
        }
    }
}