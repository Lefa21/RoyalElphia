package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class BarricadePierre extends Obstacle {

    public BarricadePierre() {

        super(4,100);

        this.setCoutAchat(50);
        this.setCoutVente(4);
        this.setCoutAmelioration(2);
        this.setNiveauMaxAmelioration(4);
    }
}