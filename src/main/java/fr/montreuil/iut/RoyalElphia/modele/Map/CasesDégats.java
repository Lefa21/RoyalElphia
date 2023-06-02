package fr.montreuil.iut.RoyalElphia.modele.Map;

public class CasesDégats extends Cases {
    private int degat;

    public CasesDégats(int x, int y, int degat) {
        super(x, y);
        this.degat = degat;
    }

    public int getDegat() {
        return this.degat;
    }
}
