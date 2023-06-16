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

        // Variable permettant de donner un ID aux projectiles afin de les supprimer
        int compteur = 0;

        // On crée un projectile pour chaque case dégât de la tour
        for (int i = 0; i < tour.getListeCasesDegats().size(); i++) {
            Image im = null;

            // Cette variable permet de récuperer la position de la case dégât pour placer l'image
            CasesDégats c = tour.getListeCasesDegats().get(i);
            if (tour instanceof TourABombe) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageProjectile/Bombe.gif"));
            } else if (tour instanceof TourBouleDeFeu) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageProjectile/BouleDeFeu.gif"));
            } else if (tour instanceof TourElectrique) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageProjectile/Electricité.gif"));
            } else if (tour instanceof TourFleche) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageProjectile/Flèche.gif"));
            } else if (tour instanceof TourLaser) {
                im = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/ImageProjectile/Laser.gif"));
            }
            ImageView imV = new ImageView(im);

            // On soustrait 16 pour que le projectile prenne toute la tuile sur laquelle la case dégât se trouve
            imV.setX(c.getX() - 16);
            imV.setY(c.getY() - 16);

            imV.setId(compteur + "P" + tour.getID());
            pane.getChildren().add(imV);
            compteur++;
        }
    }


}
