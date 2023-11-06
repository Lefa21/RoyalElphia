package fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieDeplacement;

import fr.montreuil.iut.RoyalElphia.modele.Direction;
import fr.montreuil.iut.RoyalElphia.modele.Map.Cases;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesParcourues;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import java.util.LinkedList;

import static fr.montreuil.iut.RoyalElphia.modele.Direction.*;

public class DeplacementAlterne implements StrategieDeplacement {

    private boolean use = false;

    @Override
    public int[] deplacement(CasesParcourues casesParcourues, LinkedList<Cases> chemin, Terrain terrain) {
        int[] tab = new int[2];
        Cases cases = chemin.pollLast();
        Cases c = null;

        Direction direction;

        double random = Math.random();

        if (random<0.25) {
            direction = Haut;
        } else if (random<0.5) {
            direction = Droite;
        } else if (random<0.75) {
            direction = Bas;
        } else {
            direction = Gauche;
        }

        switch (direction) {
            case Haut: {
                if (cases.getX() - 5 > -1 )
                    c = new Cases((cases.getY()*32)+16,((cases.getX() - 5)*32)+16, terrain.getTabTerrain()[cases.getX() - 5][cases.getY()]);
                break;
            }
            case Droite: {
                if (cases.getY() + 5 < 40)
                    c = new Cases(((cases.getY() + 5)*32)+16, (cases.getX()*32)+16, terrain.getTabTerrain()[cases.getX()][cases.getY() + 5]);
                break;
            }
            case Bas: {
                if (cases.getX() + 5 < 30)
                    c = new Cases((cases.getY()*32)+16,((cases.getX() + 5)*32)+16, terrain.getTabTerrain()[cases.getX() + 5][cases.getY()]);
                break;
            }
            case Gauche: {
                if (cases.getY() - 5 > -1)
                    c = new Cases( ((cases.getY() - 5)*32)+16,(cases.getX()*32)+16, terrain.getTabTerrain()[cases.getX()][cases.getY() - 5]);
                break;
            }

        }


        if (!use && c!=null && !casesParcourues.verif(c) && c.getValeur() == 9) {
            int tampon = cases.getX();
            cases.setX((cases.getY()*32)+16);
            cases.setY((tampon*32)+16);
                while (!c.compare(cases)) {
                    cases = chemin.pollLast();
                    tampon = cases.getX();
                    cases.setX((cases.getY()*32)+16);
                    cases.setY((tampon*32)+16);
                }
                tab[0] = (cases.getX());
                tab[1] = (cases.getY());
                use = true;
        }
        else {
            tab[0] = (cases.getY() * 32) + 16;
            tab[1] = (cases.getX() * 32) + 16;
        }
        return tab;
    }



    /*
    Regarder X cases plus loin si la case est un chemin, ensuite regarder si cette cases est dans la liste,
    et vider la liste jusqu'à arriver à cette case
     */
}
