package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadeFer extends Obstacle{
    public BarricadeFer() {

        super(2, 40);
        this.setCoutAchat(30);
        this.setCoutVente(20);
        this.setCoutAmelioration(10);
        this.setNiveauMaxAmelioration(3);
    }
}
