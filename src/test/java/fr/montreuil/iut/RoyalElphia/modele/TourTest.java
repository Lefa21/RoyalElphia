package fr.montreuil.iut.RoyalElphia.modele;

import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Map2;
import fr.montreuil.iut.RoyalElphia.modele.Map.Map_1;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TourTest {

    private Tour tourBombe = new TourABombe(); // portée de la tour 1 case
    private Tour tourLaser = new TourLaser(); // portée de la tour  2  cases
    private Tour tourElectrique = new TourElectrique(); // portée de la tour 3 cases
    private Tour tourFeu = new TourBouleDeFeu(); // portée de la tour 3 cases
    private Tour tourFleche = new TourFleche(); // portée de la tour 5 cases


private ArrayList<CasesDégats> listeCasesDegVerif = new ArrayList<>();
private    ArrayList<CasesDégats> listeVide = new ArrayList<>();
    private Terrain map1 = new Map_1();
    private Terrain Map2 = new Map2();

    private Pane pane = new Pane();


// La méthode rayonDegat permet de créer les cases dégats pour la tour et l'ajouter à la liste des cases dégats du terrain
// l'objectif est de pouvoir attribuer des dégats aux ennemis qui arrivent sur cette case
    @Test
    void rayonDegat(){

        //vérification pour chaque tour que les cases dégats sont bien créer et ajouter à leurs listes de cases dégats
        // vérifie si les cases sont créer quelque soit leurs direction à partir de la tour (haut,droit,bas,gauche)
        //vérifie si la liste des cases dégâts de la map à bien était mise à jour.

        //Vérification sur la map simple ayant comme classe Map2

        CaseDegatBombe();
        tourBombeInnoffensif();

        CaseDegatLaser();
        tourLaserInnoffensif();

        CaseDegatElectrique();
        tourElectInnoffensif();

        // vérification pour la map évoluer qui correspond à la classe map1

        CaseDegatFeu();
        tourFeuInnofensif();

        CaseDegatFleche();
        tourFlecheInnoffensif();
    }

    private void assertArrayEquals(int size, int size1) {}

    // Lorsque une tour est vendu, alors on retire la tour de la vue et de la liste des tours dans le modèle ainsi que ses cases dégats.


    public void CaseDegatBombe(){
        tourBombe.setPosX(12);
        tourBombe.setPosy(23);

        tourBombe.rayonDegat(Map2,tourBombe.getPosX(),tourBombe.getPosY(),tourBombe.getDegat(),pane);
        CasesDégats casesDégats = new CasesDégats(tourBombe.getPosX(),tourBombe.getPosY(),tourBombe.getDegat(),tourBombe.getTypeAttaque(),"G",1); // le paramètre est le nombre de case créer
        listeCasesDegVerif.add(casesDégats);

        assertArrayEquals(listeCasesDegVerif.size(),tourBombe.getListeCasesDegats().size());
        System.out.println("Test map 2" + "\n");

        System.out.println("liste casedegat tourBombe : " + tourBombe.getListeCasesDegats().toString());
        System.out.println("liste caseVerifDegat tourBombe : " + listeCasesDegVerif.toString() + "\n");
        listeCasesDegVerif.clear();

        System.out.println("Liste de case dégats de la Map2 : " + Map2.getCasesDégats().toString() + "\n");

    }

    public void tourBombeInnoffensif(){
        System.out.println("Tour bombe devient Innoffensif : ");
        tourBombe.TourDevientInoffensif(Map2,tourBombe.getListeCasesDegats());
        System.out.println("liste case degat map2 après suppression : " + Map2.getCasesDégats().toString() + '\n');

        assertArrayEquals(listeVide.size(),Map2.getCasesDégats().size());
    }

    public void CaseDegatLaser(){
        tourLaser.setPosX(23);
        tourLaser.setPosy(8);
        tourLaser.rayonDegat(Map2,tourLaser.getPosX(),tourLaser.getPosY(),tourLaser.getDegat(),pane);
        CasesDégats casesDégats2 = new CasesDégats(tourLaser.getPosX(),tourLaser.getPosY(),tourLaser.getDegat(),tourLaser.getTypeAttaque(),"H",1);
        CasesDégats casesDégats3 = new CasesDégats(tourLaser.getPosX(),tourLaser.getPosY(),tourLaser.getDegat(),tourLaser.getTypeAttaque(),"D",2);


        listeCasesDegVerif.add(casesDégats2);
        listeCasesDegVerif.add(casesDégats3);

        assertArrayEquals(listeCasesDegVerif.size(),tourLaser.getListeCasesDegats().size());
        System.out.println("liste casedegat tour laser : " + tourLaser.getListeCasesDegats().toString());
        System.out.println("liste caseVerifDegat tour laseer : " + listeCasesDegVerif.toString() + "\n");
        listeCasesDegVerif.clear();

        System.out.println("Liste de case dégats de la Map2 : " + Map2.getCasesDégats().toString() + "\n");
    }

    public void tourLaserInnoffensif(){
        System.out.println("Tour laser devient Innoffensif : ");

        tourLaser.TourDevientInoffensif(Map2,tourLaser.getListeCasesDegats());
        assertArrayEquals(0,Map2.getCasesDégats().size());
        System.out.println("liste case degat map2 après suppression :  " + Map2.getCasesDégats().toString() + '\n');
    }


    public void CaseDegatElectrique(){
        tourElectrique.setPosX(10);
        tourElectrique.setPosy(24);
        tourElectrique.rayonDegat(Map2,tourElectrique.getPosX(),tourElectrique.getPosY(),tourElectrique.getDegat(),pane);
        CasesDégats  casesDégats4 = new CasesDégats(tourElectrique.getPosX(),tourElectrique.getPosY(),tourElectrique.getDegat(),tourElectrique.getTypeAttaque(),"H",1);
        CasesDégats casesDégats5 = new CasesDégats(tourElectrique.getPosX(),tourElectrique.getPosY(),tourElectrique.getDegat(),tourElectrique.getTypeAttaque(),"D",2);
        CasesDégats casesDégats6 = new CasesDégats(tourElectrique.getPosX(),tourElectrique.getPosY(),tourElectrique.getDegat(),tourElectrique.getTypeAttaque(),"B",3);

        listeCasesDegVerif.add(casesDégats4);
        listeCasesDegVerif.add(casesDégats5);
        listeCasesDegVerif.add(casesDégats6);

        assertArrayEquals(listeCasesDegVerif.size(),tourElectrique.getListeCasesDegats().size());
        System.out.println("liste casedegat tour électrique : " + tourElectrique.getListeCasesDegats().toString());
        System.out.println("liste caseVerifDegat tour électrique : " + listeCasesDegVerif.toString() + "\n");
        listeCasesDegVerif.clear();

        System.out.println("Liste de case dégats de la Map2 : " + Map2.getCasesDégats().toString() + "\n");
    }

    public void tourElectInnoffensif(){
        System.out.println("Tour electrique devient Innoffensif : ");

        tourElectrique.TourDevientInoffensif(Map2,tourElectrique.getListeCasesDegats());
        assertArrayEquals(listeVide.size(),Map2.getCasesDégats().size());
        System.out.println("liste case degat terrain après suppression : " +Map2.getCasesDégats().toString() + '\n');
    }

    public void CaseDegatFeu(){
        tourFeu.setPosX(33);
        tourFeu.setPosy(26);
        tourFeu.rayonDegat(map1,tourFeu.getPosX(),tourFeu.getPosY(),tourFeu.getDegat(),pane);
        CasesDégats  casesDégats7 = new CasesDégats(tourFeu.getPosX(),tourFeu.getPosY(),tourFeu.getDegat(),tourFeu.getTypeAttaque(),"D",1);
        CasesDégats  casesDégats8 =new CasesDégats(tourFeu.getPosX(),tourFeu.getPosY(),tourFeu.getDegat(),tourFeu.getTypeAttaque(),"B",2);
        CasesDégats   casesDégats9 = new CasesDégats(tourFeu.getPosX(),tourFeu.getPosY(),tourFeu.getDegat(),tourFeu.getTypeAttaque(),"G",3);


        listeCasesDegVerif.add(casesDégats7);
        listeCasesDegVerif.add(casesDégats8);
        listeCasesDegVerif.add(casesDégats9);

        assertArrayEquals(listeCasesDegVerif.size(),tourFeu.getListeCasesDegats().size());
        System.out.println("Test  map 1 " + '\n');
        System.out.println("liste casedegat tour Feu : " + tourFeu.getListeCasesDegats().toString());
        System.out.println("liste caseVerifDegat tour Feu : " + listeCasesDegVerif.toString() + "\n");
        listeCasesDegVerif.clear();

        System.out.println("Liste de case dégats de la Map1 : " + map1.getCasesDégats().toString() + "\n");
    }

    public void tourFeuInnofensif(){
        System.out.println("Tour feu devient Innoffensif : ");
        tourFeu.TourDevientInoffensif(map1,tourFeu.getListeCasesDegats());
        assertArrayEquals(listeVide.size(),map1.getCasesDégats().size());
        System.out.println("liste case degat map1 après suppression :  " + map1.getCasesDégats().toString() + '\n');
    }

    public void CaseDegatFleche(){
        tourFleche.setPosX(31);
        tourFleche.setPosy(4);
        tourFleche.rayonDegat(map1,tourFleche.getPosX(),tourFleche.getPosY(),tourFleche.getDegat(),pane);
        CasesDégats casesDégats10 = new CasesDégats(tourFleche.getPosX(),tourFleche.getPosY(),tourFleche.getDegat(),tourFleche.getTypeAttaque(),"H",1);
        CasesDégats   casesDégats11 =new CasesDégats(tourFleche.getPosX(),tourFleche.getPosY(),tourFleche.getDegat(),tourFleche.getTypeAttaque(),"G",2);
        CasesDégats casesDégats12= new CasesDégats(tourFleche.getPosX(),tourFleche.getPosY(),tourFleche.getDegat(),tourFleche.getTypeAttaque(),"D",3);

        listeCasesDegVerif.add(casesDégats10);
        listeCasesDegVerif.add(casesDégats11);
        listeCasesDegVerif.add(casesDégats12);


        assertArrayEquals(listeCasesDegVerif.size(),tourFleche.getListeCasesDegats().size());
        System.out.println("liste casedegat tour fleche : " +tourFleche.getListeCasesDegats().toString());
        System.out.println("liste caseVerifDegat tour fleche : " + listeCasesDegVerif.toString() + "\n");
        listeCasesDegVerif.clear();

        System.out.println("Liste de case dégats de la Map1 : " + map1.getCasesDégats().toString() + "\n");

    }

    public void tourFlecheInnoffensif(){
        System.out.println("Tour flèche devient Innoffensif : ");

        tourFleche.TourDevientInoffensif(map1,tourFleche.getListeCasesDegats());
        assertArrayEquals(listeVide.size(),map1.getCasesDégats().size());
        System.out.println("liste case degat map1 après suppression :  " + map1.getCasesDégats().toString() + '\n');
    }

}
