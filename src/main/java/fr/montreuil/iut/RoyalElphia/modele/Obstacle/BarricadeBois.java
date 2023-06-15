package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadeBois extends Obstacle{
    public BarricadeBois() {

        super( 1, 40);

        this.setCoutAchat(10);
        this.setCoutVente(3);
        this.setCoutAmelioration(2);
        this.setNiveauMaxAmelioration(3);
    }
}
