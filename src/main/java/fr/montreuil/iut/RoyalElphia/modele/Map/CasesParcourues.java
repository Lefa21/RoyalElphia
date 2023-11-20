package fr.montreuil.iut.RoyalElphia.modele.Map;


import java.util.LinkedList;

public class CasesParcourues {

    /*
    Classe permettant d'utiliser des méthodes sur une liste de Case pour simplifier le code
     */

    private LinkedList<Cases> casesParcourues;

    public CasesParcourues() {
        this.casesParcourues = new LinkedList<>();
    }

    public void ajouterCase(Cases cases) {
        this.casesParcourues.addFirst(cases);
    }

    // Méthode qui vérifie si une case c est contenue dans la liste de cases parcourues et renvoie un boolean
    public boolean verif(Cases c) {
        boolean verif = false;
        for (Cases cases : this.casesParcourues) {
            if (cases.getX() == c.getX() && cases.getY() == c.getY()) {
                verif = true;
            }
        }
        return verif;
    }

    public LinkedList<Cases> getCasesParcourues() {
        return casesParcourues;
    }

}