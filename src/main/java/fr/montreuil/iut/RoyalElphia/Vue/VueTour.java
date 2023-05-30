package fr.montreuil.iut.RoyalElphia.Vue;

import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;
import fr.montreuil.iut.RoyalElphia.modele.Tour.TourABombe;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.cert.PolicyNode;

public class VueTour {

    private Tour tour;
    private Pane panneauJeu;

    private double x, y;

    public VueTour(Pane p, Tour T, double x, double y){
        this.panneauJeu = p;
        this.tour = T;
        this.x = x;
        this.y = y;
    }



    public void PoserTour() throws FileNotFoundException {
            if (this.tour instanceof TourABombe) {
                Image TourBombe = new Image(new FileInputStream("src/main/resources/fr/montreuil/iut/RoyalElphia/tt-PhotoRoom.png-PhotoRoom(2).png"));
                ImageView TourBombeView = new ImageView(TourBombe);
                TourBombeView.setX(x);
                TourBombeView.setY(y);
                panneauJeu.getChildren().add(TourBombeView);
                this.tour = null;
            }
        }
    }
