package fr.montreuil.iut.RoyalElphia.modele.Niveau;

public abstract class Niveau {
    private int nbEnnemis,nbSquelette,nbGobelins,nbGeant,nbSorciere,nbGeantRoyale;

    public Niveau(int nbEnnemis, int nbGobelins, int nbSquelette, int nbGeant,int nbSorciere,int nbGeantRoyale){
        this.nbEnnemis = nbEnnemis;
        this.nbGeant = nbGeant;
        this.nbSorciere = nbSorciere;
        this.nbGobelins = nbGobelins;
        this.nbSquelette = nbSquelette;
        this.nbGeantRoyale = nbGeantRoyale;
    }

    public int getNbEnnemis() {
        return nbEnnemis;
    }

    public int getNbSquelette() {
        return nbSquelette;
    }

    public int getNbGobelins() {
        return nbGobelins;
    }

    public int getNbGeant() {
        return nbGeant;
    }

    public int getNbSorciere() {
        return nbSorciere;
    }

    public int getNbGeantRoyale() {
        return nbGeantRoyale;
    }

    public void setNbEnnemis(int nbEnnemis) {
        this.nbEnnemis = nbEnnemis;
    }

    public void setNbSquelette(int nbSquelette) {
        this.nbSquelette = nbSquelette;
    }

    public void setNbGobelins(int nbGobelins) {
        this.nbGobelins = nbGobelins;
    }

    public void setNbGeant(int nbGeant) {
        this.nbGeant = nbGeant;
    }

    public void setNbSorciere(int nbSorciere) {
        this.nbSorciere = nbSorciere;
    }

    public void setNbGeantRoyale(int nbGeantRoyale) {
        this.nbGeantRoyale = nbGeantRoyale;
    }
}
