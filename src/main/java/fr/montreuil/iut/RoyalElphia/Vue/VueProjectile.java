package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueProjectile {

    public VueProjectile(Tour tour, Pane pane) throws FileNotFoundException {
        int compteur = 0;
        for (int i = 0; i < tour.getListeCasesDegats().size(); i++) {
            Image im = null;
            CasesDégats c = tour.getListeCasesDegats().get(i);
            if (tour instanceof TourABombe) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Bombe.gif"));
            } else if (tour instanceof TourBouleDeFeu) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/BouleDeFeu.gif"));
            } else if (tour instanceof TourElectrique) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Electricité.gif"));
            } else if (tour instanceof TourFleche) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/TEST3.png"));
            } else if (tour instanceof TourLaser) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/Laser.gif"));
            }
            ImageView imV = new ImageView(im);
            imV.setX(c.getX() - 16);
            imV.setY(c.getY() - 16);
            imV.setId(compteur + "P" + tour.getID());
            pane.getChildren().add(imV);
            compteur++;
        }
    }


}
