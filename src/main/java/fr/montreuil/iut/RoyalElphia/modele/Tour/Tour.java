package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import fr.montreuil.iut.RoyalElphia.modele.Jeu;
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

    public void ameliorationTour(Jeu jeu) {
        if (getCoutAmelioration() <= jeu.getArgent()) {
            jeu.setArgent(getCoutAmelioration());
            setNiveauAmelioration(getNiveauAmelioration() + 1);
            setDegat();
            setCoutAmelioration((int) (getCoutAmelioration() * 1.5));
            setCoutVente((int) (getCoutVente() * 1.5));
            System.out.println("NIV " + getNiveauAmelioration() + " DEGAT " + getDegat());
        }
    }

    public abstract void strategieAttaque(Tour T);
}

