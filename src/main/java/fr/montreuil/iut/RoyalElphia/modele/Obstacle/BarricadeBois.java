package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadeBois extends Obstacle{
    public BarricadeBois() {
        super( 1, 100,0,0);
        this.setCoutAchat(7);
        this.setCoutVente(3);
        this.setCoutAmelioration(2);
        this.setNiveauMaxAmelioration(3);
    }
}
