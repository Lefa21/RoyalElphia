package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

import fr.montreuil.iut.RoyalElphia.modele.Items.Items;
import fr.montreuil.iut.RoyalElphia.modele.Jeu;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

// La classe obstacle permet de donner une position ainsi que des points aux obstacles qui vont être créer.
// Les obstacles peuvent seulement être posé sur le chemin des ennemis.
public class Obstacle extends Items {

    private int Materiaux;
    private IntegerProperty  PointDeVie;
    public Obstacle(int materiaux,int PointDeVie) {
        super(0,0,0,0,0,0,0);
        this.Materiaux = materiaux;
        this.PointDeVie = new SimpleIntegerProperty(PointDeVie);
    }

    public int getMateriaux() {
        return Materiaux;
    }

    public int getPointDeVie() {
        return this.PointDeVie.getValue();
    }

    public IntegerProperty getPvProperty() {
        return this.PointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.PointDeVie.setValue(pointDeVie);
    }



    @Override
    public String toString() {
        return "Obstacle{" +
                ", ID=" + super.getID() +
                ", PointDeVie=" + PointDeVie +
                ", ID=" + super.getID() +
                ", posX=" + super.getPosX() +
                ", posY=" + super.getPosY() +
                '}';
    }

    public void ameliotation(Jeu jeu) {
        if (getNiveauAmelioration() != getNiveauMaxAmelioration()) {
            if (getCoutAmelioration() <= jeu.getArgent()) {
                jeu.setArgent(getCoutAmelioration());
                setNiveauAmelioration(getNiveauAmelioration() + 1);
                setPointDeVie((int) (getPointDeVie() * 1.5));
                setCoutAmelioration((int) (getCoutAmelioration() * 1.5));
            }
    }else
            System.out.println("niv MAX");

    }
}
