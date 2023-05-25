package fr.montreuil.iut.RoyalElphia.modele;
import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class jeu {
    private Terrain terrain;
    private ObservableList<Ennemis> ennemis;

    private ArrayList<Ennemis> listeEnnemisTuée;

    private ArrayList<Ennemis> listeEnnemisSpawn;



    static int id;
    private int nbEnnemis;

    public jeu (Terrain terrain,int nbEnnemis) {
        this.terrain = terrain;
        this.ennemis = FXCollections.observableArrayList();
        this.nbEnnemis = nbEnnemis;
        this.listeEnnemisTuée = new ArrayList<>();
        this.listeEnnemisSpawn = new ArrayList<>();
    }



    public void ajouter(Ennemis e) {
        this.ennemis.add(e);
    }

    // permet d'ajouter un ennemi qui a spawn sur le terrain dans la liste de notre modèle
    public void spwanEnnemi(){
        /*
        Ennemis enm = new Ennemis(terrain, 16, 48);
            ennemis.add(enm);
            listeEnnemisSpawn.add(enm);*

         */
    }


   //permet de récuperer la liste des ennemis ayant spawn
    public ArrayList<Ennemis> getListeEnnemisSpawn(){
        return listeEnnemisSpawn;
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
            if (this.ennemis.get(i).getX()==592 && this.ennemis.get(i).getY() == 624) {
                System.out.println("-1 PV");
                this.getEnnemis().remove(this.getEnnemis().get(i));
            }
        }
        }

    public ObservableList<Ennemis> getEnnemis() {
        return ennemis;
    }

}
