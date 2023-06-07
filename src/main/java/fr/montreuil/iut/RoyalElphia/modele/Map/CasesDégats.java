package fr.montreuil.iut.RoyalElphia.modele.Map;

public class CasesDégats extends Cases {
    private int degat, typeAttaque;

    public CasesDégats(int x, int y, int degat, int typeAttaque) {
        super(x, y);
        this.degat = degat;
        this.typeAttaque = typeAttaque;
    }

    public int getDegat() {
        return this.degat;
    }

    public int getTypeAttaque (){
        return this.typeAttaque;
    }

    public void setDegat(int i){
        this.degat = getDegat() + i;
    }
}