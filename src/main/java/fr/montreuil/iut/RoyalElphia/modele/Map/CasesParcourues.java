package fr.montreuil.iut.RoyalElphia.modele.Map;

import java.util.ArrayList;

public class CasesParcourues {

    private ArrayList<Cases> casesParcourues;

    public CasesParcourues() {
        this.casesParcourues = new ArrayList<>();
    }

    public void ajouterCase(Cases cases) {
        this.casesParcourues.add(cases);
    }

    public boolean verif(Cases c) {
        boolean verif = false;
        for (int i = 0; i < this.casesParcourues.size(); i++) {
            Cases cases = casesParcourues.get(i);
            if (cases.getX() == c.getX() && cases.getY() == c.getY()) {
                verif = true;
            }
        }
        return verif;
    }
}