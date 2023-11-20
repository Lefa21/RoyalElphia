package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadePierre extends Obstacle {

    public BarricadePierre() {

        super(4,40);

        this.setCoutAchat(100);
        this.setCoutVente(50);
        this.setCoutAmelioration(70);
        this.setNiveauMaxAmelioration(2);
    }
}