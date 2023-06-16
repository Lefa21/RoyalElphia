package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

// Cette classe permet d'écouter notre liste observable d'obstacles.
// lorsque les pv d'un obstacle tombe à zéro alors on le supprime de la vue, ainsi que son label.
public class ListObservableObstacle implements  ListChangeListener<Obstacle> {

    private Pane panneauJeu;
    private jeu jeu;

    public ListObservableObstacle(jeu jeu,Pane panneauJeu){
        this.panneauJeu = panneauJeu;
        this.jeu = jeu;
    }

    @Override
    public void onChanged(ListChangeListener.Change<? extends Obstacle> c) {
        while (c.next()) {
            if (c.wasRemoved()) {
                for (Obstacle a : c.getRemoved()
                ) {
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getID()));
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getID()+"L"));
                }
            }
        }

    }
}
