package fr.montreuil.iut.RoyalElphia.modele.Niveau;

public abstract class Niveau {
    private int nbEnnemis;

    public Niveau(int nbEnnemis){
        this.nbEnnemis = nbEnnemis;
    }

    public int getNbEnnemis() {
        return nbEnnemis;
    }

    public void setNbEnnemis(int nbEnnemis) {
        this.nbEnnemis = nbEnnemis;
    }
}
