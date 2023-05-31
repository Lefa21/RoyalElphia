package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

public class ListObsEnnemis implements ListChangeListener<Ennemis> {
    private Pane panneauJeu;
    private jeu jeu;

    public ListObsEnnemis(jeu jeu,Pane panneauJeu){
        this.panneauJeu = panneauJeu;
        this.jeu = jeu;
    }

    @Override
    public void onChanged(Change<? extends Ennemis> c) {
        System.out.println("changement");
        while (c.next()) {
            if (c.wasAdded()) {
                for (Ennemis a : c.getAddedSubList()
                ) {
                    VueEnnemi vueEnm = new VueEnnemi(panneauJeu);
                    vueEnm.créerSprite(a);
                }
            } else if (c.wasRemoved()) {
                for (Ennemis a : c.getRemoved()
                ) {
                    jeu.setArgent(-a.getButin());
                    jeu.ajoutEnnemisMort(a);
                    panneauJeu.getChildren().remove((panneauJeu.lookup("#" + a.getId())));
                }
            }
        }

    }
}
