package fr.montreuil.iut.RoyalElphia.modele;
import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class jeu {
    private Terrain terrain;
    private ObservableList<Ennemis> ennemis;

    private ArrayList<Ennemis> listeEnnemisTuée;



    static int id;
    private int nbEnnemis;

    public jeu (Terrain terrain,int nbEnnemis) {
        this.terrain = terrain;
        this.ennemis = FXCollections.observableArrayList();
        this.nbEnnemis = nbEnnemis;
        this.listeEnnemisTuée = new ArrayList<>();
    }

    public void ajouter(Ennemis e) {
        this.ennemis.add(e);
    }

    public void spwanEnnemi(){
            Ennemis enm = new Ennemis(terrain);
            ennemis.add(enm);
    }

    public void ajoutEnnemisMort(Ennemis enm){
        listeEnnemisTuée.add(enm);
    }

    public ArrayList<Ennemis> getEnnemisTué(){
        return listeEnnemisTuée;
    }

    public int getNbEnnemisMax(){
        return nbEnnemis;
    }

    public void unTour() {
        for (int i = 0; i < ennemis.size(); i++) {
            this.ennemis.get(i).seDeplace();
            if (this.ennemis.get(i).getX()== (this.terrain.getPointArv().getX()*32+16) && this.ennemis.get(i).getY() == (this.terrain.getPointArv().getY()*32+16)) {
                System.out.println("-1 PV");
                this.getEnnemis().remove(this.getEnnemis().get(i));
            }
        }
    }

    public ObservableList<Ennemis> getEnnemis() {
        return ennemis;
    }
}
