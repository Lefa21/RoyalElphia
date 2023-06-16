package fr.montreuil.iut.RoyalElphia.modele.Niveau;


// La classe niveau permet de savoir quelle niveau l'utilisateur va choisir. Plus la difficulté est élevé, plus le nombre d'ennemis à la première vague est élevé.
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
