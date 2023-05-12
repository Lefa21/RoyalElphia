package jeu.royalelphia.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import modele.Terrain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private Terrain terrain;

    @FXML
    private TilePane map;

    public void ter( Terrain Terrain) throws FileNotFoundException {
            int [][] tab = Terrain.getTabTerrain();
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if(tab[i][j] == 1){
                    Image herbe = new Image(new FileInputStream("/home/benyoussef-admin/IdeaProjects/RoyalElphia/src/main/resources/jeu/royalelphia/herbe.jpg"));
                    ImageView herbe2 = new ImageView(herbe);
                    this.map.getChildren().add(herbe2);

                } else if (tab[i][j]==0) {
                    Image chemin = new Image(new FileInputStream("/home/benyoussef-admin/IdeaProjects/RoyalElphia/src/main/resources/jeu/royalelphia/chemin.jpg"));
                    ImageView chemin2 = new ImageView(chemin);
                    this.map.getChildren().add(chemin2);
                }

            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.terrain = new Terrain(20,20);
        try {
            ter(terrain);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
