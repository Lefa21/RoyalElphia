package fr.montreuil.iut.RoyalElphia.modele.Niveau;


// La classe niveau permet de savoir quelle niveau l'utilisateur va choisir. Plus la difficulté est élevé, plus le nombre d'ennemis à la première vague est élevé.
public class Niveau {
    private int nbEnnemis;

    public Niveau(int diff){
        // 1 -> Facile , 2 -> Normal, 3 -> Difficile
        if (diff == 1) {
            setNbEnnemis(1);
        } else if (diff==2) {
            setNbEnnemis(5);
        } else
            setNbEnnemis(10);
    }

    public int getNbEnnemis() {
        return nbEnnemis;
    }

    public void setNbEnnemis(int nbEnnemis) {
        this.nbEnnemis = nbEnnemis;
    }

}
