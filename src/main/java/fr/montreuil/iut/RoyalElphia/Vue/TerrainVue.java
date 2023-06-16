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

                Image image = null;

                if (tab[i][j] == 4) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/herbe.png"));
                } else if (tab[i][j] == 1) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/pointDep.jpg"));
                } else if (tab[i][j] == 2) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/pointArv.jpg"));
                } else if (tab[i][j] == 7) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/contour.png"));
                } else if (tab[i][j] == 9) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/chemin.png"));
                } else if (tab[i][j] == 3) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/eau.png"));
                } else if (tab[i][j] == 8) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageObstacle/pont.png"));
                } else if (tab[i][j] == 10) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/rocheEau.png"));
                } else if (tab[i][j] == 5) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/mur.png"));
                }  else if (tab[i][j] == 88) {
                    image = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTuile/lave.png"));
                }

                ImageView imageView = new ImageView(image);
                map.getChildren().add(imageView);
            }
        }
    }
}