package fr.montreuil.iut.RoyalElphia.modele.Map;

import fr.montreuil.iut.RoyalElphia.modele.Direction;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CasesDégats extends Cases {
    /*
    Classe permmettant de gérer les dégâts des tours
    */
    private IntegerProperty degat;
    private int typeAttaque; // Permet de savoir sur quel ennemi la tour va faire des dégâts


    // On récupère la position de la tour et ses attribut pour créer une case dégât
    public CasesDégats(int x, int y, int degat, int typeAttaque, Direction d, int multi) {
        super(x, y);
        // Le paramètre multi sert à calculer la portée de la tour

        /*
        En fonction de la direction on crée une case plus loin que la tour
        */

        if (d.equals(Direction.Haut)) {
            this.setX(transitionFormat(x));
            this.setY(transitionFormatCaseSuivante(y,multi,2));

        } else if (d.equals(Direction.Droite)) {
            this.setX(transitionFormatCaseSuivante(x,multi,1));
            this.setY(transitionFormat(y));

        } else if (d.equals(Direction.Bas)) {
            this.setX(transitionFormat(x));
            this.setY(transitionFormatCaseSuivante(y,multi,1));
        } else if (d.equals(Direction.Gauche)) {
            this.setX(transitionFormatCaseSuivante(x,multi,2));
            this.setY(transitionFormat(y));
        }
        this.degat = new SimpleIntegerProperty(degat);
        this.typeAttaque = typeAttaque;
    }

    // Méthode qui permet de changer de dimension pour alléger le constructeur
    public int transitionFormat(int i) {
        return  ((i*32)+16);
    }

    /*
    Méthode qui permet de changer de dimension pour alléger le constructeur
    (on obtient une des cases se trouvant autour de la tour)
    */
    public int transitionFormatCaseSuivante(int position, int multi, int choix) {
        int retour = 0;
        if (choix == 1) {
            retour = ((position*32) + (32 * multi) + 16);
        }
        else if (choix == 2) {
            retour = ((position*32) - (32 * multi) + 16);
        }
        return retour;
    }

    public int getDegat() {
        return this.degat.getValue();
    }

    public IntegerProperty getDegatProperty() {
        return this.degat;
    }

    public int getTypeAttaque() {
        return this.typeAttaque;
    }

    // Méthode qui permet de vérifier si l'ennemi se trouve sur une case ou il subit des dégâts et de vérifier son immunité
    public boolean verifDegat(Ennemis e) {
        return e.getX() == this.getX() && e.getY() == this.getY() && e.getImmunite() != this.getTypeAttaque();
    }

    @Override
    public String toString() {
        return super.toString() + " ,degat = " + this.getDegat() + ", typeAttaque = " + typeAttaque;
    }
}

