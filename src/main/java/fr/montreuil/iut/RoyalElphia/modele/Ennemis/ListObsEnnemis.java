package fr.montreuil.iut.RoyalElphia.modele.Ennemis;

import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import fr.montreuil.iut.RoyalElphia.modele.Jeu;
import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;

public class ListObsEnnemis implements ListChangeListener<Ennemis> {
    private Pane panneauJeu;
    private Jeu jeu;

    public ListObsEnnemis(Jeu jeu, Pane panneauJeu){
        this.panneauJeu = panneauJeu;
        this.jeu = jeu;
    }

    @Override
    public void onChanged(Change<? extends Ennemis> c) {

        while (c.next()) {

            if (c.wasAdded()) {
                for (Ennemis a : c.getAddedSubList()) {
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
                    // On augmente le compteur de mort
                    jeu.setComptEnnemiTue();

                    // On récupère le butin de l'ennemi et on l'ajoute à la cagnotte
                    jeu.setArgent(-a.getButin());

                    // On ajoute un ennemi à la liste des morts du jeu
                    jeu.ajoutEnnemisMort(a);

                    // On retire l'ennemi du nombre d'ennemi restant
                    jeu.setNbEnnemisRestant(jeu.getNbEnnemisRestant() - 1);

                    // On supprime l'image de l'ennemi dans la map
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
                    // On supprime la barre de vie sur l'ennemi
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#" + a.getId()));
                    // On supprime le label (indiquant les pv) de l'ennemi dans la map
                    panneauJeu.getChildren().remove(panneauJeu.lookup("#"+a.getId()+"L"));
                }
            }
        }
    }
}