package fr.montreuil.iut.RoyalElphia.modele.Tour;

public class Tour {

    private String Nom;
    private int CoutAchat;
    private int PorteeAttaque;
    private String TypeAttaque;
    private int CoutVente;
    private int CoutAmelioration;
    private int NiveauAmelioration;
    private int NiveauMaxAmelioration;
    private int DureeINtervalleAttaque;
    private int NombreAttaqueMax;
    private int TempsRecharge;

    public Tour(String nom, int coutAchat, int porteeAttaque, String typeAttaque, int coutVente, int coutAmelioration, int niveauAmelioration, int niveauMaxAmelioration, int dureeINtervalleAttaque, int nombreAttaqueMax, int tempsRecharge) {
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

    public void setCoutAchat(int coutAchat) {
        CoutAchat = coutAchat;
    }

    public int getPorteeAttaque() {
        return PorteeAttaque;
    }

    public void setPorteeAttaque(int porteeAttaque) {
        PorteeAttaque = porteeAttaque;
    }

    public String getTypeAttaque() {
        return TypeAttaque;
    }

    public void setTypeAttaque(String typeAttaque) {
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
}
