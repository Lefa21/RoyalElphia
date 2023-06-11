package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public  class Tour extends Items {

    private int PorteeAttaque;
    private int TypeAttaque;
    private int DureeINtervalleAttaque;
    private int NombreAttaqueMax;
    private int TempsRecharge;
    private IntegerProperty degat;

    private int ID;
    private ArrayList<CasesDégats> listeCasesDegats;




    public Tour(int porteeAttaque, int typeAttaque, int dureeINtervalleAttaque, int nombreAttaqueMax, int tempsRecharge, int degat) {
        super(0,0,0,0,0);
        PorteeAttaque = porteeAttaque;
        TypeAttaque = typeAttaque;
        DureeINtervalleAttaque = dureeINtervalleAttaque;
        NombreAttaqueMax = nombreAttaqueMax;
        TempsRecharge = tempsRecharge;
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

    public void setTypeAttaque(int typeAttaque) {
        TypeAttaque = typeAttaque;
    }



    public int getDureeINtervalleAttaque() {
        return DureeINtervalleAttaque;
    }

    public void setDureeINtervalleAttaque(int dureeINtervalleAttaque) {
        DureeINtervalleAttaque = dureeINtervalleAttaque;
    }

    public void setPorteeAttaque(int porteeAttaque) {
        PorteeAttaque = porteeAttaque;
    }

    public int getNombreAttaqueMax() {
        return NombreAttaqueMax;
    }

    public void setNombreAttaqueMax(int nombreAttaqueMax) {
        NombreAttaqueMax = nombreAttaqueMax;
    }

    public int getTempsRecharge() {
        return TempsRecharge;
    }

    public void setTempsRecharge(int tempsRecharge) {
        TempsRecharge = tempsRecharge;
    }


    public ArrayList<CasesDégats> rayonDegat(Terrain terrain, int x, int y, int degat, Pane pane) {
        this.listeCasesDegats = new ArrayList<>();

        for (int i = 0; i <= this.getPorteeAttaque(); i++) {
            CasesDégats c1 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "H", i, pane);
            terrain.ajouterCaseDegat(c1);
            listeCasesDegats.add(c1);
            c1.getDegatProperty().bind(this.getDegatProperty());


            CasesDégats c2 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "D", i, pane);
            terrain.ajouterCaseDegat(c2);
            listeCasesDegats.add(c2);
            c2.getDegatProperty().bind(this.getDegatProperty());

            CasesDégats c3 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "B", i, pane);
            terrain.ajouterCaseDegat(c3);
            listeCasesDegats.add(c3);
            c3.getDegatProperty().bind(this.getDegatProperty());

            CasesDégats c4 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "G", i,pane);
            terrain.ajouterCaseDegat(c4);
            listeCasesDegats.add(c4);
            c4.getDegatProperty().bind(this.getDegatProperty());

           /*CasesDégats c5 = new CasesDégats((x * 32) - (32 * i) + 16, (y * 32) - (32 * i) + 16, degat, this.getTypeAttaque());
           terrain.ajouterCaseDegat(c5);
           listeCasesDegats.add(c5);

           CasesDégats c6 = new CasesDégats((x * 32) - (32 * i) + 16, (y * 32) + (32 * i) + 16, degat, this.getTypeAttaque());
           terrain.ajouterCaseDegat(c6);
           listeCasesDegats.add(c6);

           CasesDégats c7 = new CasesDégats((x * 32) + (32 * i) + 16, (y * 32) + (32 * i) + 16, degat, this.getTypeAttaque());
           terrain.ajouterCaseDegat(c7);
           listeCasesDegats.add(c7);

           CasesDégats c8 = new CasesDégats((x * 32) + (32 * i) + 16, (y * 32) - (32 * i) + 16, degat, this.getTypeAttaque());
           terrain.ajouterCaseDegat(c8);
           listeCasesDegats.add(c8);*/
        }

        return listeCasesDegats;
    }

    public void TourDevientInoffensif(Terrain terrain, ArrayList<CasesDégats> listeCasesDegats) {
        terrain.getCasesDégats().removeAll(listeCasesDegats);
    }
    public ArrayList<CasesDégats> getListeCasesDegats() {
        return listeCasesDegats;
    }

}

