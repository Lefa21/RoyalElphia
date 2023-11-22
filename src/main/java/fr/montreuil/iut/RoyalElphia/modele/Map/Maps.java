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
        this.calculChemin();
    }

    public int[][] getTab1() {
        String cheminFichier = "src/main/resources/fr/montreuil/iut/RoyalElphia/TableauxMap/tab1.txt";

        int[][] tab1 = lireMatriceDepuisFichier(cheminFichier);
        return tab1;
    }

    public int[][] getTab2() {
        String cheminFichier = "src/main/resources/fr/montreuil/iut/RoyalElphia/TableauxMap/tab2.txt";

        int[][] tab2 = lireMatriceDepuisFichier(cheminFichier);

        return tab2;
    }
}

