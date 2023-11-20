package fr.montreuil.iut.RoyalElphia.modele.Items;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/*
La classe Items regroupe les différents item tel que obstacle.
Elle regroupe comme attribut, les attributs communs aux différents items.
Cette classe a pour responsabilité  de récuperer le niveau d'amélioration des items, de les améliorer etcc.
 */
public abstract class Items {

    private int CoutAchat;
    private int CoutVente;
    private int CoutAmelioration;
    private int NiveauAmelioration;
    private int NiveauMaxAmelioration;

    private IntegerProperty posX,posY;
    private int ID;

protected Items(){}

    public Items(int CoutAchat, int CoutVente, int CoutAmelioration, int NiveauAmelioration, int NiveauMaxAmelioration,int posX,int posY) {
        this.CoutAchat = CoutAchat;
        this.CoutVente = CoutVente;
        this.CoutAmelioration = CoutAmelioration;
        this.NiveauAmelioration = NiveauAmelioration;
        this.NiveauMaxAmelioration = NiveauMaxAmelioration;
        this.posX = new SimpleIntegerProperty(posX);
        this.posY = new SimpleIntegerProperty(posY);
    }
    public void setID(int i) {
        this.ID = i;
    }

    public int getID() {
        return ID;
    }

    public final IntegerProperty getPosXProperty(){
        return this.posX;
    }

    public final int getPosX(){
        return  this.posX.getValue();
    }

    public final void setPosX(int posX){
        this.posX.setValue(posX);
    }

    public final IntegerProperty getPosYProperty(){
        return this.posY;
    }

    public final int getPosY(){
        return  this.posY.getValue();
    }

    public final void setPosy(int posy){
        this.posY.setValue(posy);
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
