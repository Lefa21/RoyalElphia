package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public class Tour {

    private String Nom;
    private int CoutAchat;
    private int PorteeAttaque;
    private int TypeAttaque;
    private int CoutVente;
    private int CoutAmelioration;
    private int NiveauAmelioration;
    private int NiveauMaxAmelioration;
    private int DureeINtervalleAttaque;
    private int NombreAttaqueMax;
    private int TempsRecharge;
    private IntegerProperty degat;

    private int ID;
    private ArrayList<CasesDégats> listeCasesDegats;

    private CasesDégats c1, c2, c3, c4, c5, c6, c7, c8;


    public Tour(int degat, String nom, int coutAchat, int porteeAttaque, int typeAttaque, int coutVente, int coutAmelioration, int niveauMaxAmelioration, int dureeINtervalleAttaque, int nombreAttaqueMax, int tempsRecharge) {
        Nom = nom;
        CoutAchat = coutAchat;
        PorteeAttaque = porteeAttaque;
        TypeAttaque = typeAttaque;
        CoutVente = coutVente;
        CoutAmelioration = coutAmelioration;
        NiveauAmelioration = 1;
        NiveauMaxAmelioration = niveauMaxAmelioration;
        DureeINtervalleAttaque = dureeINtervalleAttaque;
        NombreAttaqueMax = nombreAttaqueMax;
        TempsRecharge = tempsRecharge;
        this.degat = new SimpleIntegerProperty(degat);
    }

    public void setID(int i) {
        this.ID = i;
    }

    public int getID() {
        return ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getCoutAchat() {
        return CoutAchat;
    }

    public int getDegat() {
        return degat.getValue();
    }

    public IntegerProperty getDegatProperty() {
        return this.degat;
    }

    public void setDegat() {
        this.degat.setValue(this.degat.getValue() * 3);
    }

    public void setCoutAchat(int coutAchat) {
        CoutAchat = coutAchat;
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

    public int getCoutVente() {
        return CoutVente;
    }

    public void setCoutVente(int coutVente) {
        CoutVente = coutVente;
    }

    public int getCoutAmelioration() {
        return CoutAmelioration;
    }

    public void setCoutAmelioration(int coutAmelioration) {
        CoutAmelioration = coutAmelioration;
    }

    public int getNiveauAmelioration() {
        return NiveauAmelioration;
    }

    public void setNiveauAmelioration(int niveauAmelioration) {
        NiveauAmelioration = niveauAmelioration;
    }

    public int getNiveauMaxAmelioration() {
        return NiveauMaxAmelioration;
    }

    public void setNiveauMaxAmelioration(int niveauMaxAmelioration) {
        NiveauMaxAmelioration = niveauMaxAmelioration;
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


   public ArrayList<CasesDégats> rayonDegat(Terrain terrain, int x, int y, int degat) {
       this.listeCasesDegats = new ArrayList<>();

       for (int i = 0; i <= this.getPorteeAttaque(); i++) {
           CasesDégats c1 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "H", i);
           terrain.ajouterCaseDegat(c1);
           listeCasesDegats.add(c1);

           CasesDégats c2 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "D", i);
           terrain.ajouterCaseDegat(c2);
           listeCasesDegats.add(c2);

           CasesDégats c3 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "B", i);
           terrain.ajouterCaseDegat(c3);
           listeCasesDegats.add(c3);

           CasesDégats c4 = new CasesDégats(x, y, degat, this.getTypeAttaque(), "G", i);
           terrain.ajouterCaseDegat(c4);
           listeCasesDegats.add(c4);

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

