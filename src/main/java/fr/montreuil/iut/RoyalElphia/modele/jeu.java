package fr.montreuil.iut.RoyalElphia.modele;
import fr.montreuil.iut.RoyalElphia.Vue.VueEnnemi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public  class jeu {
    private Terrain terrain;
    private ObservableList<Ennemis> ennemis;

    private ArrayList<Ennemis> listeEnnemisTuée;

    private ArrayList<Ennemis> listeEnnemisSpawn;

    private int nbEnnemis,nbSquelette,nbGobelins,nbGeant,nbSorciere,nbGeantRoyale,nbTour;



    public jeu (Terrain terrain,int nbEnnemis, int nbGobelins, int nbSquelette, int nbGeant,int nbSorciere,int nbGeantRoyale) {
        this.terrain = terrain;
        this.ennemis = FXCollections.observableArrayList();
        this.nbEnnemis = nbEnnemis;
        this.listeEnnemisTuée = new ArrayList<>();
        this.listeEnnemisSpawn = new ArrayList<>();
        this.nbGeant = nbGeant;
        this.nbSorciere = nbSorciere;
        this.nbGobelins = nbGobelins;
        this.nbSquelette = nbSquelette;
        this.nbGeantRoyale = nbGeantRoyale;
        this.nbTour = 0;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public ArrayList<Ennemis> getListeEnnemisTuée() {
        return listeEnnemisTuée;
    }

    public int getNbEnnemis() {
        return nbEnnemis;
    }

    public int getNbSquelette() {
        return nbSquelette;
    }

    public int getNbGobelins() {
        return nbGobelins;
    }

    public int getNbGeant() {
        return nbGeant;
    }

    public int getNbSorciere() {
        return nbSorciere;
    }

    public int getNbGeantRoyale() {
        return nbGeantRoyale;
    }

    public void ajouter(Ennemis e) {
        this.ennemis.add(e);
    }

    // permet d'ajouter un ennemi qui a spawn sur le terrain dans la liste de notre modèle

    /*
    public void créerEnnemis(){
        for (int i = 0; i < getNbGeantRoyale(); i++) {
            Ennemis geantRoyale = new GéantRoyal(getTerrain(),16,48);
            ennemis.add(geantRoyale);
        }
        for (int i = 0; i < getNbGeant(); i++) {
            Ennemis geant = new Géant(getTerrain(),16,48);
            ennemis.add(geant);
        }

        for (int i = 0; i < getNbSorciere(); i++) {
            Ennemis sorcières = new Sorcières(getTerrain(),16,48);
            ennemis.add(sorcières);
        }
        for (int i = 0; i < getNbSquelette(); i++) {
            Ennemis squelette = new Squelette(getTerrain(),16,48);
            ennemis.add(squelette);

        }
        for (int i = 0; i < getNbGobelins(); i++) {
            Ennemis gobelins = new gobelins(getTerrain(),16,48);
            ennemis.add(gobelins);
        }

        System.out.println("Nombre ennemis" +ennemis.size());
    }

    */


    public void setNbSquelette(int nbSquelette) {
        this.nbSquelette = nbSquelette;
    }

    public void setNbGobelins(int nbGobelins) {
        this.nbGobelins = nbGobelins;
    }

    public void setNbGeant(int nbGeant) {
        this.nbGeant = nbGeant;
    }

    public void setNbSorciere(int nbSorciere) {
        this.nbSorciere = nbSorciere;
    }

    public void setNbGeantRoyale(int nbGeantRoyale) {
        this.nbGeantRoyale = nbGeantRoyale;
    }

    public void spwanEnnemi(){
        if(nbTour%2 == 0 && getNbSorciere() != 0){
            Ennemis enm = new Sorcières(terrain,16,48);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbSorciere(getNbSorciere() -1);
        }

        else if(nbTour%4 == 0 && getNbGeant() != 0){
            Ennemis  enm = new Géant(terrain,16,48);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbGeant(getNbGeant() -1);
        }

        else if(nbTour%8 == 0 && getNbGobelins() != 0){
            Ennemis enm = new gobelins(terrain,16,48);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbGobelins(getNbGobelins() -1);
        }

        else if(nbTour%16 == 0 && getNbSquelette() != 0){
            Ennemis enm = new Sorcières(terrain,16,48);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbSquelette(getNbSquelette() -1);
        }

        else if(nbTour%32 == 0 && getNbSorciere() != 0){
            Ennemis enm = new GéantRoyal(terrain,16,48);
            ennemis.add(enm);
            this.listeEnnemisSpawn.add(enm);
            this.setNbGeantRoyale(getNbGeantRoyale() -1);
        }

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
        nbTour++;
        }

    public ObservableList<Ennemis> getEnnemis() {
        return ennemis;
    }
}
