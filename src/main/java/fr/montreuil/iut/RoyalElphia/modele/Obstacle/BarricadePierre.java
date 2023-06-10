package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadePierre extends Obstacle {

    public BarricadePierre() {
        super(4,100,0,0);
        this.setCoutAchat(10);
        this.setCoutVente(4);
        this.setCoutAmelioration(2);
        this.setNiveauMaxAmelioration(4);
    }
}