package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadeBois extends Obstacle{
    public BarricadeBois() {

        super( 1, 20);
        this.setCoutAchat(15);
        this.setCoutVente(5);
        this.setCoutAmelioration(5);
        this.setNiveauMaxAmelioration(4);
    }
}
