package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.LancementJeu;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;


public class TerrainVue {
    public TerrainVue(Terrain Terrain, TilePane map){
        int[][] tab = Terrain.getTabTerrain();

        for (int[] ints : tab) {
            for (int anInt : ints) {

                Image image = null;

                if (anInt == 4) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/herbe.png");
                    image = new Image(String.valueOf(urlImageSol));
                } else if (anInt == 1) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/pointDep.jpg");
                    image = new Image(String.valueOf(urlImageSol));
                } else if (anInt == 2) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/pointArv.jpg");
                    image = new Image(String.valueOf(urlImageSol));
                } else if (anInt == 7) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/contour.png");
                    image = new Image(String.valueOf(urlImageSol));
                } else if (anInt == 9) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/chemin.png");
                    image = new Image(String.valueOf(urlImageSol));
                } else if (anInt == 3) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/eauu.png");
                    image = new Image(String.valueOf(urlImageSol));
                } else if (anInt == 8) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/pont.png");
                    image = new Image(String.valueOf(urlImageSol));
                } else if (anInt == 10) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/rocheEau.png");
                    image = new Image(String.valueOf(urlImageSol));
                } else if (anInt == 5) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/mur.png");
                    image = new Image(String.valueOf(urlImageSol));
                } else if (anInt == 88) {
                    URL urlImageSol = LancementJeu.class.getResource("ImageTuile/lave.png");
                    image = new Image(String.valueOf(urlImageSol));
                }

                ImageView imageView = new ImageView(image);
                map.getChildren().add(imageView);
            }
        }
    }
}