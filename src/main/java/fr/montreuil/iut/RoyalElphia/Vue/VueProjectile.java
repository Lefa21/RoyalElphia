package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueProjectile {

    private Tour tour;
    private Pane pane;
    private int compteur;

    public VueProjectile (Tour tour, Pane pane) throws FileNotFoundException {
        this.tour = tour;
        this.pane = pane;
        this.compteur = 0;
        for (int i = 0; i < this.tour.getListeCasesDegats().size(); i++) {
            ImageView imV = null;
            CasesDégats c = this.tour.getListeCasesDegats().get(i);
            if (this.tour instanceof TourABombe) {
                Image im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TEST.png"));
                imV = new ImageView(im);
            }
            else if (this.tour instanceof TourBouleDeFeu) {
                Image im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TEST1.png"));
                imV = new ImageView(im);
            }
            else if (this.tour instanceof TourElectrique) {
                Image im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TEST2.png"));
                imV = new ImageView(im);
            }
            else if (this.tour instanceof TourFleche) {
                Image im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TEST3.png"));
                imV = new ImageView(im);
            }
            else if (this.tour instanceof TourLaser) {
                Image im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TEST4.png"));
                imV = new ImageView(im);
            }
            imV.setX(c.getX()-16);
            imV.setY(c.getY()-16);
            imV.setId(compteur+"P"+this.tour.getID());
            this.pane.getChildren().add(imV);
            compteur++;
        }
    }


}
