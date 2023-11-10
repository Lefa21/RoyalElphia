package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

import fr.montreuil.iut.RoyalElphia.Vue.BarreDeVieVue;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.BarreDeVie;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;


public class ListObsBarreDeVie implements ListChangeListener<BarreDeVie> {

    private Pane panneauDeJeu;
    private BarreDeVieVue barreDeVieVue;

    public ListObsBarreDeVie(Pane PanneauJeu) {
        this.panneauDeJeu = PanneauJeu;
        barreDeVieVue = new BarreDeVieVue(PanneauJeu);
    }

    @Override
    public void onChanged(Change<? extends BarreDeVie> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (BarreDeVie b : change.getAddedSubList()) {
                    System.out.println("add");
                    barreDeVieVue.afficherBarreVie(b);
                }
            }
        }
    }
}
