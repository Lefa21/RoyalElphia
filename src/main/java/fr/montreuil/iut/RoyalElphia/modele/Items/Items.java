package fr.montreuil.iut.RoyalElphia.modele.Items;

import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;

public abstract class Items {

    private int CoutAchat;
    private int CoutVente;
    private int CoutAmelioration;
    private int NiveauAmelioration;
    private int NiveauMaxAmelioration;
    private int ID;



    public Items(int CoutAchat, int CoutVente, int CoutAmelioration, int NiveauAmelioration, int NiveauMaxAmelioration) {
        this.CoutAchat = CoutAchat;
        this.CoutVente = CoutVente;
        this.CoutAmelioration = CoutAmelioration;
        this.NiveauAmelioration = NiveauAmelioration;
        this.NiveauMaxAmelioration = NiveauMaxAmelioration;
    }
    public void setID(int i) {
        this.ID = i;
    }

    public int getID() {
        return ID;
    }

    public int getCoutAchat() {
        return CoutAchat;
    }

    public void setCoutAchat(int coutAchat) {
        CoutAchat = coutAchat;
    }


    public int getCoutVente() {
        return CoutVente;
    }

    public void setCoutVente(int coutVente) {
        CoutVente = coutVente;
    }

    public int getCoutAmelioration() {
        return CoutAmelioration;
    }

    public void setCoutAmelioration(int coutAmelioration) {
        CoutAmelioration = coutAmelioration;
    }

    public int getNiveauAmelioration() {
        return NiveauAmelioration;
    }

    public void setNiveauAmelioration(int niveauAmelioration) {
        NiveauAmelioration = niveauAmelioration;
    }

    public int getNiveauMaxAmelioration() {
        return NiveauMaxAmelioration;
    }

    public void setNiveauMaxAmelioration(int niveauMaxAmelioration) {
        NiveauMaxAmelioration = niveauMaxAmelioration;
    }

}
