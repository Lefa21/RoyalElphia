package fr.montreuil.iut.RoyalElphia.modele;

import fr.montreuil.iut.RoyalElphia.modele.Map.Map_1;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Facile;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Niveau;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;
import fr.montreuil.iut.RoyalElphia.modele.Tour.TourLaser;
import javafx.scene.layout.VBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class jeuTest {

    private Terrain t = new Map_1();
    private Niveau n = new Facile();
    private VBox v = new VBox();

    private jeu j = new jeu(t,n,v);

    @Test
    void enleveObstacleDetruit() {
    }

    @Test
    void degatEnnemis() {
    }

    @Test
    void degatBase() {
    }

    @Test
    void enleveEnnemisMort() {
    }

    @Test
    void augmentationCapacité() {
    }

    @Test
    void ajouterTour() {
    }

    @Test
    void ajouterObstacle() {
    }

    @Test
    void getListeObstacle() {
    }

    @Test
    void getArgentProperty() {
    }

    @Test
    void setArgent() {
    }

    @Test
    void setArgentAZero() {
    }

    @Test
    void setPvZero() {
    }

    @Test
    void getArgent() {
       // jeu j = new jeu(t,n,v);
        assertEquals(200,j.getArgent());
    }

    @Test
    void verifArgent() {
        Tour t = new TourLaser();
        j.setArgentAZero();
        assertFalse(j.verifArgent(t));
    }

    @Test
    void verifArgentObstacle() {
    }

    @Test
    void getNiveau() {

    }

    @Test
    void getTerrain() {
    }

    @Test
    void getListeEnnemisTuée() {
    }

    @Test
    void setNbVague() {
    }

    @Test
    void getNbVague() {
    }

    @Test
    void getNbVagueProperty() {
    }

    @Test
    void ajouter() {
    }

    @Test
    void vagueSuivante() {
    }

    @Test
    void spwanEnnemi() {
    }

    @Test
    void getListeEnnemisSpawn() {
    }

    @Test
    void ajoutEnnemisMort() {
    }

    @Test
    void getEnnemisTué() {
    }

    @Test
    void lancementLoop() {
    }

    @Test
    void arretLoop() {
    }

    @Test
    void getEnnemis() {
    }

    @Test
    void comptEnnemiTueProperty() {
    }

    @Test
    void getComptEnnemiTue() {
    }

    @Test
    void setComptEnnemiTue() {
    }

    @Test
    void getPvJoueurProperty() {
    }

    @Test
    void getPvJoueur() {
    }

    @Test
    void setPvJoueur() {
    }

    @Test
    void getListeDeTour() {
    }

    @Test
    void setNbEnnemisRestant() {
    }

    @Test
    void nbEnnemisRestantProperty() {
    }

    @Test
    void getNbEnnemisRestant() {
    }

    @Test
    void unTour() {
    }

    @Test
    void gagne() {
    }

    @Test
    void perdu() {
    }
}