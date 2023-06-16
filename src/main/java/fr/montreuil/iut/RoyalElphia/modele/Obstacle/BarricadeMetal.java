package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadeMetal extends Obstacle{
    public BarricadeMetal() {

        super(3, 80);

        this.setCoutAchat(60);
        this.setCoutVente(40);
        this.setCoutAmelioration(25);
        this.setNiveauMaxAmelioration(3);
    }
}
