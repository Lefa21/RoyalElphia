package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadeMetal extends Obstacle{
    public BarricadeMetal() {

        super(3, 100);

        this.setCoutAchat(32);
        this.setCoutVente(15);
        this.setCoutAmelioration(10);
        this.setNiveauMaxAmelioration(8);
    }
}
