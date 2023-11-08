package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.StrategieTour;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class Tour extends Items {

    private int PorteeAttaque;
    private int TypeAttaque;
    protected IntegerProperty degat;
    private ArrayList<CasesDégats> listeCasesDegats;

    protected StrategieTour st;

    public Tour(int porteeAttaque, int typeAttaque, int degat, StrategieTour s) {

        super(0, 0, 0, 0, 0, 0, 0);

        PorteeAttaque = porteeAttaque;
        TypeAttaque = typeAttaque;
        this.degat = new SimpleIntegerProperty(degat);
        this.st = s;
    }

    public void setDegat(int degat) {
        this.degat.set(degat);
    }

    public int getDegat() {
        return degat.getValue();
    }

    public IntegerProperty getDegatProperty() {
        return this.degat;
    }

    public void setDegat() {
        this.degat.setValue(this.degat.getValue() * 1.5);
    }


    public int getPorteeAttaque() {
        return PorteeAttaque;
    }


    public int getTypeAttaque() {
        return TypeAttaque;
    }


    public ArrayList<CasesDégats> rayonDegat(Terrain terrain, int x, int y, int degat) throws ArrayIndexOutOfBoundsException{
        this.listeCasesDegats = new ArrayList<>();

        for (int i = 1; i <= this.getPorteeAttaque(); i++) {
            if ((y-i) > -1 && (terrain.getTabTerrain()[y - i][x] == 9 || terrain.getTabTerrain()[y - i][x] == 8)) {
                CasesDégats c1 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "H", i);
                terrain.ajouterCaseDegat(c1);
                listeCasesDegats.add(c1);
                c1.getDegatProperty().bind(this.getDegatProperty());
            }
            if ((x+i) < 40  && (terrain.getTabTerrain()[y][x + i] == 9 || terrain.getTabTerrain()[y][x + i] == 8)) {
                CasesDégats c2 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "D", i);
                terrain.ajouterCaseDegat(c2);
                listeCasesDegats.add(c2);
                c2.getDegatProperty().bind(this.getDegatProperty());
            }
            if ((y+i) < 30 &&  (terrain.getTabTerrain()[y + i][x] == 9 || terrain.getTabTerrain()[y + i][x] == 8)) {
                CasesDégats c3 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "B", i);
                terrain.ajouterCaseDegat(c3);
                listeCasesDegats.add(c3);
                c3.getDegatProperty().bind(this.getDegatProperty());
            }
            if ((x-i) > -1 &&  (terrain.getTabTerrain()[y][x - i] == 9 || terrain.getTabTerrain()[y][x - i] == 8)) {
                CasesDégats c4 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "G", i);
                terrain.ajouterCaseDegat(c4);
                listeCasesDegats.add(c4);
                c4.getDegatProperty().bind(this.getDegatProperty());
            }
        }
        return listeCasesDegats;
    }

  /*  public void setCaseDegat(Terrain terrain) {
        ArrayList<CasesDégats> newCasesDegats = new ArrayList<>();

        // Parcourez chaque CasesDégats actuelle
        for (CasesDégats caseDegat : listeCasesDegats) {
            // Obtenez la position actuelle de la case
            int x = caseDegat.getX() / 32;
            int y = caseDegat.getY() / 32;

            // Créez de nouvelles cases autour de la case actuelle (ajout d'une case en haut, en bas, à gauche et à droite)
            int portee = 1; // Portée des nouvelles cases
            if (listeCasesDegats.size() < 30) {
                if ((y - portee) > -1 && (terrain.getTabTerrain()[y - portee][x] == 9 || terrain.getTabTerrain()[y - portee][x] == 8)) {
                    CasesDégats c1 = new CasesDégats(x, y - (portee), getDegat(), getTypeAttaque(), "H", portee);
                    terrain.ajouterCaseDegat(c1);
                    newCasesDegats.add(c1);
                    c1.getDegatProperty().bind(this.getDegatProperty());
                }
                if ((x + portee) < 40 && (terrain.getTabTerrain()[y][x + (portee)] == 9 || terrain.getTabTerrain()[y][x + (portee)] == 8)) {
                    CasesDégats c2 = new CasesDégats(x + (portee), y, getDegat(), getTypeAttaque(), "D", portee);
                    terrain.ajouterCaseDegat(c2);
                    newCasesDegats.add(c2);
                    c2.getDegatProperty().bind(this.getDegatProperty());
                }
                if ((y + portee) < 30 && (terrain.getTabTerrain()[y + (portee)][x] == 9 || terrain.getTabTerrain()[y + (portee)][x] == 8)) {
                    CasesDégats c3 = new CasesDégats(x, y + (portee), getDegat(), getTypeAttaque(), "B", portee);
                    terrain.ajouterCaseDegat(c3);
                    newCasesDegats.add(c3);
                    c3.getDegatProperty().bind(this.getDegatProperty());
                }
                if ((x - portee) > -1 && (terrain.getTabTerrain()[y][x - (portee)] == 9 || terrain.getTabTerrain()[y][x - (portee)] == 8)) {
                    CasesDégats c4 = new CasesDégats(x - (portee), y, getDegat(), getTypeAttaque(), "G", portee);
                    terrain.ajouterCaseDegat(c4);
                    newCasesDegats.add(c4);
                    c4.getDegatProperty().bind(this.getDegatProperty());
                }
            }
        }
        // Ajoutez les nouvelles cases créées à la liste existante
        listeCasesDegats.addAll(newCasesDegats);
    }*/



    public void TourDevientInoffensif(Terrain terrain, ArrayList<CasesDégats> listeCasesDegats) {          //Enleve toutes les cases dégats associées à une tour.
        terrain.getCasesDégats().removeAll(listeCasesDegats);
    }

    public ArrayList<CasesDégats> getListeCasesDegats() {
        return listeCasesDegats;
    }

    public StrategieTour getSt() {
        return st;
    }

    public abstract String getChemin();
}

