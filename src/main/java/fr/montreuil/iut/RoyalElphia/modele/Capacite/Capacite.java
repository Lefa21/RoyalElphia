package fr.montreuil.iut.RoyalElphia.modele.Capacite;

public class Capacite {

    private int destruction;
    private int immuniteObstacle;
    private int augmentationDegat;
    private int augmentationVitesse;
    private int augmentationPv;

    public Capacite(int capaciteObstacle, int capaciteStat) {
        if (capaciteObstacle == 1){
            this.destruction = 10;
            this.immuniteObstacle = 5;
            this.augmentationDegat = 0;
            this.augmentationVitesse = 0;
            this.augmentationPv = 0;
        } else if (capaciteStat == 1) {
            this.destruction = 0;
            this.immuniteObstacle = 0;
            this.augmentationDegat = 10;
            this.augmentationVitesse = 5;
            this.augmentationPv = 15;
        } else if (capaciteObstacle == 1 && capaciteStat == 1) {
            this.destruction = 10;
            this.immuniteObstacle = 5;
            this.augmentationDegat = 10;
            this.augmentationVitesse = 5;
            this.augmentationPv = 15;
        }
    }

    public int getDestruction() {
        return destruction;
    }

    public void setDestruction(int destruction) {
        this.destruction = destruction;
    }

    public int getImmuniteObstacle() {
        return immuniteObstacle;
    }

    public void setImmuniteObstacle(int immuniteObstacle) {
        this.immuniteObstacle = immuniteObstacle;
    }

    public int getAugmentationDegat() {
        return augmentationDegat;
    }

    public void setAugmentationDegat(int augmentationDegat) {
        this.augmentationDegat = augmentationDegat;
    }

    public int getAugmentationVitesse() {
        return augmentationVitesse;
    }

    public void setAugmentationVitesse(int augmentationVitesse) {
        this.augmentationVitesse = augmentationVitesse;
    }

    public int getAugmentationPv() {
        return augmentationPv;
    }

    public void setAugmentationPv(int augmentationPv) {
        this.augmentationPv = augmentationPv;
    }
}
