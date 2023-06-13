package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ListObservableTour implements ListChangeListener<Tour> {

    private Pane panneauJeu;
    private  jeu jeu;

    public ListObservableTour(jeu jeu, Pane panneauJeu){
        this.panneauJeu = panneauJeu;
        this.jeu = jeu;
    }

    @Override
    public void onChanged(ListChangeListener.Change<? extends Tour> c) {
        System.out.println("changement");
        while (c.next()) {
            if (c.wasRemoved()) {
                for (Tour a : c.getRemoved()
                ) {
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getID()));
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getID()+"Lt"));
                }
            }
        }

    }
}
