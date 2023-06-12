package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.Ennemis;
import fr.montreuil.iut.RoyalElphia.modele.jeu;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

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
                    try {
                        vueEnm.créerSprite(a);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (c.wasRemoved()) {
                for (Ennemis a : c.getRemoved()
                ) {
                    jeu.setArgent(a.getButin());
                    jeu.ajoutEnnemisMort(a);
                    this.jeu.setNbEnnemisRestant(this.jeu.getNbEnnemisRestant() - 1);
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getId()+"L"));
                }
            }
        }

    }
}
