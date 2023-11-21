package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Direction;
import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import fr.montreuil.iut.RoyalElphia.modele.Jeu;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDegats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.StrategieTour;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public abstract class Tour extends Items {

    private int PorteeAttaque;
    private int TypeAttaque;
    protected IntegerProperty degat;
    private ArrayList<CasesDegats> listeCasesDegats = new ArrayList<>();
    private boolean poison;
    private int degatPoison;

    protected StrategieTour st;

    protected Tour(){
        super();
    }

    public Tour(int porteeAttaque, int typeAttaque, int degat, StrategieTour s) {

        super(0, 0, 0, 0, 0, 0, 0);

        PorteeAttaque = porteeAttaque;
        TypeAttaque = typeAttaque;
        this.degat = new SimpleIntegerProperty(degat);
        this.st = s;
        this.degatPoison = 2;
        this.poison = false;
    }

    public boolean isPoison() {
        return poison;
    }

    public int getDegatPoison() {
        return degatPoison;
    }

    public void ameliorerDegat (){
        this.degatPoison = this.degatPoison + 5;
    }

    public void activerPoison(){
        this.poison = true;
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


    public void rayonDegat(Terrain terrain, int x, int y, int degat) throws ArrayIndexOutOfBoundsException{

        for (int i = 1; i <= this.getPorteeAttaque(); i++) {
            if ((y-i) > -1 && (terrain.getTabTerrain()[y - i][x] == 9 || terrain.getTabTerrain()[y - i][x] == 8)) {
                CasesDegats c1 = new CasesDegats(x, y, degat, this.getTypeAttaque(), Direction.Haut, i, isPoison(), getDegatPoison());
                terrain.ajouterCaseDegat(c1);
                listeCasesDegats.add(c1);
                c1.getDegatProperty().bind(this.getDegatProperty());
            }
            if ((x+i) < 40  && (terrain.getTabTerrain()[y][x + i] == 9 || terrain.getTabTerrain()[y][x + i] == 8)) {
                CasesDegats c2 = new CasesDegats(x, y, degat, this.getTypeAttaque(), Direction.Droite, i, isPoison(), getDegatPoison());
                terrain.ajouterCaseDegat(c2);
                listeCasesDegats.add(c2);
                c2.getDegatProperty().bind(this.getDegatProperty());
            }
            if ((y+i) < 30 &&  (terrain.getTabTerrain()[y + i][x] == 9 || terrain.getTabTerrain()[y + i][x] == 8)) {
                CasesDegats c3 = new CasesDegats(x, y, degat, this.getTypeAttaque(), Direction.Bas, i, isPoison(), getDegatPoison());
                terrain.ajouterCaseDegat(c3);
                listeCasesDegats.add(c3);
                c3.getDegatProperty().bind(this.getDegatProperty());
            }
            if ((x-i) > -1 &&  (terrain.getTabTerrain()[y][x - i] == 9 || terrain.getTabTerrain()[y][x - i] == 8)) {
                CasesDegats c4 = new CasesDegats(x, y, degat, this.getTypeAttaque(), Direction.Gauche, i, isPoison(), getDegatPoison());
                terrain.ajouterCaseDegat(c4);
                c4.getDegatProperty().bind(this.getDegatProperty());
            }
        }
    }


    public void TourDevientInoffensif(Terrain terrain, ArrayList<CasesDegats> listeCasesDegats) {          //Enleve toutes les cases dégats associées à une tour.
        terrain.getCasesDegats().removeAll(listeCasesDegats);
    }

    public ArrayList<CasesDegats> getListeCasesDegats() {
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

