package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;

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
    private int degat;

    private int ID;
    private ArrayList<CasesDégats> listeCasesDegats;

    private CasesDégats c1,c2,c3,c4,c5,c6,c7,c8;


    public Tour(int degat, String nom, int coutAchat, int porteeAttaque, int typeAttaque, int coutVente, int coutAmelioration, int niveauAmelioration, int niveauMaxAmelioration, int dureeINtervalleAttaque, int nombreAttaqueMax, int tempsRecharge) {
        Nom = nom;
        CoutAchat = coutAchat;
        PorteeAttaque = porteeAttaque;
        TypeAttaque = typeAttaque;
        CoutVente = coutVente;
        CoutAmelioration = coutAmelioration;
        NiveauAmelioration = niveauAmelioration;
        NiveauMaxAmelioration = niveauMaxAmelioration;
        DureeINtervalleAttaque = dureeINtervalleAttaque;
        NombreAttaqueMax = nombreAttaqueMax;
        TempsRecharge = tempsRecharge;
        this.degat = degat;

    }
    public void setID(int i){
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
        return degat;
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

    public void setDegat(int degat) {
        this.degat = degat;
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

   /* public void rayonDegat(Terrain Terrain, int x, int y, int degat) {
        for (int i = 0; i <= this.getPorteeAttaque(); i++) {

            this.c1 = new CasesDégats((x * 32) + 16, (y * 32) - (32 * i) + 16, degat, this.getTypeAttaque());
            Terrain.ajouterCaseDegat(c1);
            ListeCasesDegats.add(c1);

            this.c2 = new CasesDégats((x * 32) + 16, (y * 32) + (32 * i) + 16, degat, this.getTypeAttaque());
            Terrain.ajouterCaseDegat(c2);
            ListeCasesDegats.add(c2);

            this.c3 = new CasesDégats((x * 32) + (32 * i) + 16, (y * 32) + 16, degat, this.getTypeAttaque());
            Terrain.ajouterCaseDegat(c3);
            ListeCasesDegats.add(c3);

            this.c4 = new CasesDégats((x * 32) - (32 * i) + 16, (y * 32) + 16, degat, this.getTypeAttaque());
            Terrain.ajouterCaseDegat(c4);
            ListeCasesDegats.add(c4);

            this.c5 = new CasesDégats((x * 32) - (32 * i) + 16, (y * 32) - (32 * i) + 16, degat, this.getTypeAttaque());
            Terrain.ajouterCaseDegat(c5);
            ListeCasesDegats.add(c5);

            this.c6 = new CasesDégats((x * 32) - (32 * i) + 16, (y * 32) + (32 * i) + 16, degat, this.getTypeAttaque());
            Terrain.ajouterCaseDegat(c6);
            ListeCasesDegats.add(c6);

            this.c7 = new CasesDégats((x * 32) + (32 * i) + 16, (y * 32) + (32 * i) + 16, degat, this.getTypeAttaque());
            Terrain.ajouterCaseDegat(c7);
            ListeCasesDegats.add(c7);

            this.c8 = new CasesDégats((x * 32) + (32 * i) + 16, (y * 32) - (32 * i) + 16, degat, this.getTypeAttaque());
            Terrain.ajouterCaseDegat(c8);
            ListeCasesDegats.add(c8);
        }
    }
    public void TourDevientInoffensif(Terrain t){
        for (int i = 0; i < t.getCasesDégats().size(); i++) {
            if (t.getCasesDégats().contains(this.c1)){
                t.getCasesDégats().remove(i);
            } else if (t.getCasesDégats().contains(this.c2)) {
                t.getCasesDégats().remove(i);
            } else if (t.getCasesDégats().contains(this.c3)) {
                t.getCasesDégats().remove(i);
            } else if (t.getCasesDégats().contains(this.c4)) {
                t.getCasesDégats().remove(i);
            } else if (t.getCasesDégats().contains(this.c5)) {
                t.getCasesDégats().remove(i);
            } else if (t.getCasesDégats().contains(this.c6)) {
                t.getCasesDégats().remove(i);
            } else if (t.getCasesDégats().contains(this.c7)) {
                t.getCasesDégats().remove(i);
            } else if (t.getCasesDégats().contains(this.c8)) {
                t.getCasesDégats().remove(i);
            }
        }
    }
    public void TourDevientInoffensif(Terrain t) {
        ArrayList<CasesDégats> casesASupprimer = new ArrayList<>();

        for (CasesDégats caseDegat : t.getCasesDégats()) {
            if (caseDegat.equals(this.c1) || caseDegat.equals(this.c2) || caseDegat.equals(this.c3)
                    || caseDegat.equals(this.c4) || caseDegat.equals(this.c5) || caseDegat.equals(this.c6)
                    || caseDegat.equals(this.c7) || caseDegat.equals(this.c8)) {
                casesASupprimer.add(caseDegat);
            }
        }

        // Supprimer les cases de dégâts de la liste
        t.getCasesDégats().removeAll(casesASupprimer);
    }*/
   public ArrayList<CasesDégats> rayonDegat(Terrain terrain, int x, int y, int degat) {
       this.listeCasesDegats = new ArrayList<>();

       for (int i = 0; i <= this.getPorteeAttaque(); i++) {
           CasesDégats c1 = new CasesDégats((x * 32) + 16, (y * 32) - (32 * i) + 16, degat, this.getTypeAttaque());
           terrain.ajouterCaseDegat(c1);
           listeCasesDegats.add(c1);

           CasesDégats c2 = new CasesDégats((x * 32) + 16, (y * 32) + (32 * i) + 16, degat, this.getTypeAttaque());
           terrain.ajouterCaseDegat(c2);
           listeCasesDegats.add(c2);

           CasesDégats c3 = new CasesDégats((x * 32) + (32 * i) + 16, (y * 32) + 16, degat, this.getTypeAttaque());
           terrain.ajouterCaseDegat(c3);
           listeCasesDegats.add(c3);

           CasesDégats c4 = new CasesDégats((x * 32) - (32 * i) + 16, (y * 32) + 16, degat, this.getTypeAttaque());
           terrain.ajouterCaseDegat(c4);
           listeCasesDegats.add(c4);

           CasesDégats c5 = new CasesDégats((x * 32) - (32 * i) + 16, (y * 32) - (32 * i) + 16, degat, this.getTypeAttaque());
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
           listeCasesDegats.add(c8);
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

