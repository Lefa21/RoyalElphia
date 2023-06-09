package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadeMetal extends Obstacle{
    public BarricadeMetal() {
        super(4, 100,0,0);
        this.setCoutAchat(32);
        this.setCoutVente(15);
        this.setCoutAmelioration(10);
        this.setNiveauMaxAmelioration(8);
    }
}
