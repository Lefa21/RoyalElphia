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

    public Obstacle(String nomObstacle, int materiaux, int pointDeVie, int coutObstacle, int coutVente, int coutAmelioration, int maxAmelioration, int niveauMaxAmelioration) {
        NomObstacle = nomObstacle;
        Materiaux = materiaux;
        PointDeVie = pointDeVie;
        CoutObstacle = coutObstacle;
        this.coutVente = coutVente;
        CoutAmelioration = coutAmelioration;
        MaxAmelioration = maxAmelioration;
        NiveauMaxAmelioration = niveauMaxAmelioration;
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
        return PointDeVie;
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
}
