package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ListObservableObstacle implements  ListChangeListener<Obstacle> {

    private Pane panneauJeu;
    private jeu jeu;

    public ListObservableObstacle(jeu jeu,Pane panneauJeu){
        this.panneauJeu = panneauJeu;
        this.jeu = jeu;
    }

    @Override
    public void onChanged(ListChangeListener.Change<? extends Obstacle> c) {
        System.out.println("changement");
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
