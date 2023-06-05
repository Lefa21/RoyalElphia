package fr.montreuil.iut.RoyalElphia.modele.Map;

import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;

public class CasesDégats extends Cases {
    private int degat, typeAttaque;
    private String direction;

    public CasesDégats(int x, int y, int degat, int typeAttaque, String direction, int multi) {
        super(x, y);
        if (direction.equals("H")) {
            this.setX((this.getX() * 32) + 16);
            this.setY((this.getY() * 32) - (32 * multi) + 16);
        } else if (direction.equals("D")) {
            this.setX((this.getX() * 32) + (32 * multi) + 16);
            this.setY((this.getY() * 32) + 16);
        } else if (direction.equals("B")) {
            this.setX((this.getX() * 32) + 16);
            this.setY((this.getY() * 32) + (32 * multi) + 16);
        } else if (direction.equals("G")) {
            this.setX((this.getX() * 32) - (32 * multi) + 16);
            this.setY((this.getY() * 32) + 16);
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

    public boolean verifDegat(Ennemis e) {
        boolean verif = false;
        if (e.getX() == this.getX() && e.getY() == this.getY() && e.getImmunite() != this.getTypeAttaque())
            verif = true;
        return verif;
    }
}
