package fr.montreuil.iut.RoyalElphia.modele;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Géant;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Sorcières;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.gobelins;
import fr.montreuil.iut.RoyalElphia.modele.Map.Map_1;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Facile;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Niveau;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.BarricadeBois;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;
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
        int[][] tab = t.getTabTerrain();
        Obstacle o = new BarricadeBois();
        j.getListeObstacle().add(o);
        assertEquals(1,j.getListeObstacle().size());
        Ennemis e = new Géant(t);
        o.setPointDeVie(0);
        j.enleveObstacleDetruit(tab,e);
        assertEquals(0,j.getListeObstacle().size());

    }

    @Test
    void degatBase() {
        Ennemis e = new Sorcières(t);
        e.setX(10000);
        e.setY(10000);
        j.getEnnemis().add(e);
        j.degatBase(e);
        assertEquals(399,j.getPvJoueur());
        assertEquals(0,j.getEnnemis().size());
    }

    @Test
    void enleveEnnemisMort() {
        Ennemis e = new gobelins(t);
        j.getEnnemis().add(e);
        e.setPvZero();
        j.enleveEnnemisMort();
        assertEquals(0,j.getEnnemis().size());
    }

    @Test
    void augmentationCapacité() {
        Ennemis e = new Géant(t);
        j.augmentationCapacité(128,e);
        assertEquals(150,e.getDegatObstacle());
        assertEquals(150,e.getDegatBase());
    }

    @Test
    void ajouterTour() {
        Tour t = new TourLaser();
        j.ajouterTour(t);
        assertEquals(1,j.getListeDeTour().size());
    }

    @Test
    void ajouterObstacle() {
        Obstacle o = new BarricadeBois();
        j.ajouterObstacle(o);
        assertEquals(1,j.getListeObstacle().size());
    }

    @Test
    void getListeObstacle() {
        //ajout et suppression d'un obstacle puis get de la liste pour voir sa ça correspond
        Obstacle o = new BarricadeBois();
        j.getListeObstacle().add(o);
        assertEquals(1,j.getListeObstacle().size());
        j.getListeObstacle().remove(o);
        assertEquals(0,j.getListeObstacle().size());
    }

    @Test
    void setArgent() {
        j.setArgent(150);
        assertEquals(50,j.getArgent());
    }

    @Test
    void setArgentAZero() {
        j.setArgentAZero();
        assertEquals(0,j.getArgent());
    }

    @Test
    void setPvZero() {
        j.setPvZero();
        assertEquals(0,j.getPvJoueur());
    }

    @Test
    void getArgent() {
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
        Obstacle o = new BarricadeBois();
        j.verifArgentObstacle(o);
        assertTrue(j.verifArgentObstacle(o));
    }

    @Test
    void getNiveau() {
    assertSame(n,j.getNiveau());
    }

    @Test
    void getTerrain() {
        assertSame(t,j.getTerrain());
    }

    @Test
    void getListeEnnemisTuée() {
        //ajout et assassinat d'un Ennemi puis get de la liste pour voir sa ça correspond
        Ennemis e = new gobelins(t);
        j.getListeEnnemisTuée().add(e);
        assertEquals(1,j.getListeEnnemisTuée().size());
        j.getListeEnnemisTuée().remove(e);
        assertEquals(0,j.getListeEnnemisTuée().size());
    }

    @Test
    void setNbVague() {
        j.setNbVague(3);
        assertEquals(3,j.getNbVague());
    }

    @Test
    void getNbVague() {
        assertEquals(1,j.getNbVague());
    }

    @Test
    void vagueSuivante() {
        j.vagueSuivante();
        assertEquals(0,j.getListeEnnemisSpawn().size());
        assertEquals(0,j.getEnnemis().size());
        assertEquals(2,j.getNbVague());
        assertEquals(10,j.getNbEnnemisRestant());
    }

    @Test
    void getListeEnnemisSpawn() {
        Ennemis e = new gobelins(t);
        j.getListeEnnemisSpawn().add(e);
        Ennemis c = new gobelins(t);
        j.getListeEnnemisSpawn().add(c);
        assertEquals(2,j.getListeEnnemisSpawn().size());
    }

    @Test
    void ajoutEnnemisMort() {
        Ennemis e = new Géant(t);
        j.ajoutEnnemisMort(e);
        assertEquals(1,j.getEnnemisTué().size());

    }

    @Test
    void getEnnemisTué() {
        Ennemis e = new Sorcières(t);
        j.getEnnemisTué().add(e);
        assertEquals(1,j.getEnnemisTué().size());
    }

    @Test
    void getEnnemis() {
        for (int i = 0; i < 3; i++) {
            Ennemis e = new gobelins(t);
            j.getListeEnnemisTuée().add(e);
        }
        assertEquals(3,j.getListeEnnemisTuée().size());
    }

    @Test
    void getComptEnnemiTue() {
        j.setComptEnnemiTue();
        j.setComptEnnemiTue();
        assertEquals(2,j.getComptEnnemiTue());
    }

    @Test
    void setComptEnnemiTue() {
        j.setComptEnnemiTue();  //incrémente de 1
        assertEquals(1,j.getComptEnnemiTue());
    }

    @Test
    void getPvJoueur() {
        assertEquals(400,j.getPvJoueur());
    }

    @Test
    void setPvJoueur() {
        j.setPvJoueur(15);
        assertEquals(15,j.getPvJoueur());
    }

    @Test
    void getListeDeTour() {
        Tour tour = new TourLaser();
        j.getListeDeTour().add(tour);
        assertEquals(1,j.getListeDeTour().size());
    }

    @Test
    void setNbEnnemisRestant() {
        j.setNbEnnemisRestant(13);
        assertEquals(13,j.getNbEnnemisRestant());
    }

    @Test
    void getNbEnnemisRestant() {
        //La 1ere vague du niveau facile a 5 ennemis.
        assertEquals(5,j.getNbEnnemisRestant());
    }

    @Test
    void spwanEnnemi() {
        j.spwanEnnemi(); //ajoute ennemis dans les 2 listes correspondantes
        assertEquals(1,j.getEnnemis().size());
        assertEquals(1,j.getListeEnnemisSpawn().size());
    }

    @Test
    void degatEnnemis() {
    }

    @Test
    void unTour() {
    }
}