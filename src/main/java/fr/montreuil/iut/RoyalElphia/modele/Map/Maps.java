package fr.montreuil.iut.RoyalElphia.modele.Map;

import static fr.montreuil.iut.RoyalElphia.modele.LecteurCSV.LecteurTXT.lireMatriceDepuisFichier;

public class Maps extends Terrain {



    public Maps(int a) {
        super();
        if (a == 1) {
            this.Tabterrain = getTab1();
        }
        else {
            this.Tabterrain = getTab2();
        }
        this.setPointDep(this.calculPointDep());
        this.setPointArv(this.calculPointArv());
        this.setChemin();
    }

    public int[][] getTab1() {

        String cheminFichier = "src/main/java/fr/montreuil/iut/RoyalElphia/modele/Map/TableauxMap/tab1.txt";


        return lireMatriceDepuisFichier(cheminFichier);
    }

    public int[][] getTab2() {

        String cheminFichier = "src/main/java/fr/montreuil/iut/RoyalElphia/modele/Map/TableauxMap/tab2.txt";


        return lireMatriceDepuisFichier(cheminFichier);
    }
}

