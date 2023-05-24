package fr.montreuil.iut.RoyalElphia.modele;

import java.util.ArrayList;

public class CasesParcourues {

    private ArrayList<Cases> casesParcourues;

    public CasesParcourues(){
        this.casesParcourues = new ArrayList<>();
    }

    public void ajouterCase(Cases cases) {
        this.casesParcourues.add(cases);
    }

    public boolean verif (int x, int y) {
        boolean verif = false;
        for (int i = 0; i < this.casesParcourues.size(); i++) {
            Cases cases = casesParcourues.get(i);
            if (cases.getX() == x && cases.getY() == y) {
                verif = true;
            }
        }
        return verif;
    }
}