package fr.montreuil.iut.RoyalElphia.modele.Obstacle;

public class Obstacle {

    private String NomObstacle;
    private int Materiaux;
    private int PointDeVie;
    private int CoutObstacle;
    private int coutVente;
    private int CoutAmelioration;
    private int MaxAmelioration;
    private int NiveauMaxAmelioration;

    private int ID;

    private int posX,posY;

    public Obstacle(String nomObstacle, int materiaux, int coutObstacle, int coutVente,int PointDeVie, int coutAmelioration, int maxAmelioration, int niveauMaxAmelioration,int posX,int posY) {
        this.NomObstacle = nomObstacle;
        this.Materiaux = materiaux;
        this.PointDeVie = PointDeVie;
        this.CoutObstacle = coutObstacle;
        this.coutVente = coutVente;
        this.CoutAmelioration = coutAmelioration;
        this.MaxAmelioration = maxAmelioration;
        this.NiveauMaxAmelioration = niveauMaxAmelioration;
        this.posX = posX;
        this.posY = posY;
    }

    public void setID(int i){
        this.ID = i;
    }

    public int getID() {
        return ID;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getNomObstacle() {
        return NomObstacle;
    }

    public void setNomObstacle(String nomObstacle) {
        NomObstacle = nomObstacle;
    }

    public int getMateriaux() {
        return Materiaux;
    }

    public void setMateriaux(int materiaux) {
        Materiaux = materiaux;
    }

    public int getPointDeVie() {
        return this.PointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        PointDeVie = pointDeVie;
    }

    public int getCoutObstacle() {
        return CoutObstacle;
    }

    public void setCoutObstacle(int coutObstacle) {
        CoutObstacle = coutObstacle;
    }

    public int getCoutVente() {
        return coutVente;
    }

    public void setCoutVente(int coutVente) {
        this.coutVente = coutVente;
    }

    public int getCoutAmelioration() {
        return CoutAmelioration;
    }

    public void setCoutAmelioration(int coutAmelioration) {
        CoutAmelioration = coutAmelioration;
    }

    public int getMaxAmelioration() {
        return MaxAmelioration;
    }

    public void setMaxAmelioration(int maxAmelioration) {
        MaxAmelioration = maxAmelioration;
    }

    public int getNiveauMaxAmelioration() {
        return NiveauMaxAmelioration;
    }

    public void setNiveauMaxAmelioration(int niveauMaxAmelioration) {
        NiveauMaxAmelioration = niveauMaxAmelioration;
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                "NomObstacle='" + NomObstacle + '\'' +
                ", PointDeVie=" + PointDeVie +
                ", ID=" + ID +
                ", posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}
