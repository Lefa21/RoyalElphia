package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Tour extends Items {

    private int PorteeAttaque;
    private int TypeAttaque;
    private int NombreAttaqueMax;
    private IntegerProperty degat;

    private ArrayList<CasesDégats> listeCasesDegats;


    public Tour(int porteeAttaque, int typeAttaque, int degat) {

        super(0, 0, 0, 0, 0, 0, 0);

        PorteeAttaque = porteeAttaque;
        TypeAttaque = typeAttaque;
        this.degat = new SimpleIntegerProperty(degat);
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


    public ArrayList<CasesDégats> rayonDegat(Terrain terrain, int x, int y, int degat, Pane pane) throws ArrayIndexOutOfBoundsException{
        this.listeCasesDegats = new ArrayList<>();

        for (int i = 1; i <= this.getPorteeAttaque(); i++) {
            if ((y-i) > -1 && (terrain.getTabTerrain()[y - i][x] == 9 || terrain.getTabTerrain()[y - i][x] == 8)) {
                CasesDégats c1 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "H", i, pane);
                terrain.ajouterCaseDegat(c1);
                listeCasesDegats.add(c1);
                c1.getDegatProperty().bind(this.getDegatProperty());
            }
            if ((x+i) < 40  && (terrain.getTabTerrain()[y][x + i] == 9 || terrain.getTabTerrain()[y][x + i] == 8)) {
                CasesDégats c2 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "D", i, pane);
                terrain.ajouterCaseDegat(c2);
                listeCasesDegats.add(c2);
                c2.getDegatProperty().bind(this.getDegatProperty());
            }
            if ((y+i) < 30 &&  (terrain.getTabTerrain()[y + i][x] == 9 || terrain.getTabTerrain()[y + i][x] == 8)) {
                CasesDégats c3 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "B", i, pane);
                terrain.ajouterCaseDegat(c3);
                listeCasesDegats.add(c3);
                c3.getDegatProperty().bind(this.getDegatProperty());
            }
            if ((x-i) > -1 &&  (terrain.getTabTerrain()[y][x - i] == 9 || terrain.getTabTerrain()[y][x - i] == 8)) {
                CasesDégats c4 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "G", i, pane);
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

}

