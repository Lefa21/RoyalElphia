package fr.montreuil.iut.RoyalElphia.modele.Map;

public class CasesObstacles extends Cases{

    private int pointDeVie;

    public CasesObstacles(int x, int y,int pointDeVie) {
        super(x, y);
        this.pointDeVie = pointDeVie;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }
    
}
