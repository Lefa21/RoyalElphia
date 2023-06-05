package fr.montreuil.iut.RoyalElphia.modele.Map;

public class CasesDégats extends Cases {
    private int degat, typeAttaque;
    private String direction;

    public CasesDégats(int x, int y, int degat, int typeAttaque, String direction) {
        super(x, y);
        if (direction.equals("H")) {
            this.getX();
            this.getY();
        } else if (direction.equals("D")) {
            this.getX();
            this.getY();
        }
        else if (direction.equals("B")) {
            this.getX();
            this.getY();
        }
        else if (direction.equals("G")) {
            this.set;
            this.getY();
        }
        this.degat = degat;
        this.typeAttaque = typeAttaque;
    }

    public int getDegat() {
        return this.degat;
    }

    public int getTypeAttaque() {
        return this.typeAttaque;
    }
}
