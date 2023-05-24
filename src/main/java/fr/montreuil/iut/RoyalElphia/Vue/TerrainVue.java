package fr.montreuil.iut.RoyalElphia.Vue;
import fr.montreuil.iut.RoyalElphia.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class TerrainVue {
 public TerrainVue(Terrain Terrain, TilePane map) throws FileNotFoundException {
        int [][] tab = Terrain.getTabTerrain();
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if(tab[i][j] == 1){
                    Image herbe = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/herbe.jpg"));
                    ImageView herbe2 = new ImageView(herbe);
                    map.getChildren().add(herbe2);

                } else if (tab[i][j]==0) {
                    Image chemin = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/chemin.jpg"));
                    ImageView chemin2 = new ImageView(chemin);
                    map.getChildren().add(chemin2);
                }
            }
        }
    }
}
