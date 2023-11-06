package fr.montreuil.iut.RoyalElphia.modele.Tour;


import fr.montreuil.iut.RoyalElphia.modele.Jeu;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ListObservableTour implements ListChangeListener<Tour> {

    private Pane panneauJeu;
    private Jeu jeu;

    public ListObservableTour(Jeu jeu, Pane panneauJeu){
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
                    for (int i = 0; i < a.getListeCasesDegats().size(); i++) {
                        panneauJeu.getChildren().remove(panneauJeu.lookup("#"+i+"P"+a.getID()));
                    }
                }
            }
        }

    }
}
