package fr.montreuil.iut.RoyalElphia.modele;

import fr.montreuil.iut.RoyalElphia.Controller.JeuController;
import fr.montreuil.iut.RoyalElphia.LancementJeu;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.AttaqueCorpsAcorps;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.AttaqueEnFonctionDeLaBase;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.StrategieAttaque.StrategieChangeante;
import fr.montreuil.iut.RoyalElphia.modele.Map.CasesDégats;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.*;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.AmeliorationPVObstacle;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.Obstacle;
import fr.montreuil.iut.RoyalElphia.modele.Tour.AmeliorationDegatTour;
import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.AttaqueEvolutive;
import fr.montreuil.iut.RoyalElphia.modele.Tour.Tour;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// La classe jeu est notre environnement.

public class Jeu {
    private static Jeu uniqueInstance=null;
    private Terrain terrain;
    private ObservableList<Ennemis> ennemis;
    private ArrayList<Ennemis> listeEnnemisTuée;
    private ArrayList<Ennemis> listeEnnemisSpawn;
    private Timeline gameLoop;
    private IntegerProperty pvJoueur;
    private ObservableList<Tour> listeDeTour;
    private ObservableList<Obstacle> listeObstacle;
    private IntegerProperty argent;
    private Niveau niveau;
    private IntegerProperty nbVague, nbEnnemisRestant;
    private VBox vBox;
    private IntegerProperty comptEnnemiTue = new SimpleIntegerProperty(0);
    private int temps, nbTour;
    private Vague vague;
    private ObservableList<BarreDeVie> barreDeVies;
    private AmeliorationDegatTour ameliorationDegatTour;
    private AmeliorationPVObstacle ameliorationPVObstacle;


    private Jeu(Terrain terrain, Niveau niveau, VBox vBox) {
        this.terrain = terrain;
        this.ennemis = FXCollections.observableArrayList();
        this.listeEnnemisTuée = new ArrayList<>();
        this.listeEnnemisSpawn = new ArrayList<>();
        this.niveau = niveau;
        this.nbTour = 0;
        this.nbEnnemisRestant = new SimpleIntegerProperty(this.niveau.getNbEnnemis());
        this.nbVague = new SimpleIntegerProperty(1);
        this.pvJoueur = new SimpleIntegerProperty(10);
        this.listeDeTour = FXCollections.observableArrayList();
        this.listeObstacle = FXCollections.observableArrayList();
        this.argent = new SimpleIntegerProperty(20000);
        this.vague = new Vague(new FacileStrategy());
        this.vague.créerVague(this.niveau.getNbEnnemis(), this.terrain);
        this.vBox = vBox;
        this.barreDeVies = FXCollections.observableArrayList();

    }

    public static Jeu getInstance(Terrain terrain, Niveau niveau, VBox vBox) {
        if (uniqueInstance==null) {
            uniqueInstance=new Jeu(terrain,niveau,vBox);
        }
        return uniqueInstance;
    }


    // La méthode enleveObstacleDetruit permet à un ennemi de détruire un obstacle présent sur le chemin.

    public void enleveObstacleDetruit(int[][] tab, Ennemis e) {
        for (int j = 0; j < this.listeObstacle.size(); j++) {
            Obstacle obstacle = this.listeObstacle.get(j);
            if (obstacle.getPointDeVie() <= 0) {
                tab[obstacle.getPosY()][obstacle.getPosX()] = 9;
                this.listeObstacle.remove(this.listeObstacle.get(j));
            }
            e.strategieAttaque(obstacle);
        }
    }
    // La méthode dégâtsEnnemis permet de vérifier si l'ennemis s'est déplacé sur une case dégats et de lui attribuer les dégats de la tour à qui la case dégâts est attribuer.
    public void degatEnnemis(Ennemis e) {
        for (int j = 0; j < this.terrain.getCasesDegats().size(); j++) {
            CasesDégats c = this.terrain.getCasesDegats().get(j);
            if (c.verifDegat(e))
                e.setPv(this.terrain.getCasesDegats().get(j).getDegat());
        }
    }
    // La méthode dégatBase permet que lorsque l'ennemi arrive à la base il inflige ces dégâts de base et meurt.
    public void degatBase(Ennemis e) {
        if (this.terrain.verifPArv(e.getX(), e.getY())) {
            setPvJoueur(this.getPvJoueur() - e.getDegatBase());
            this.getEnnemis().remove(e);
        }
    }
    //Cette méthode enlève les ennemis mort de la liste d'ennemis
    public void enleveEnnemisMort() {
        for (int i = this.ennemis.size() - 1; i >= 0; i--) {
            if (this.ennemis.get(i).getPv() == 0)
                this.ennemis.remove(i);
        }
    }
    //Cette méthode augment aléatoire les capacité d'un ennemis durant un tour

    public void augmentationCapacité(int nbTour, Ennemis e) {

        if (nbTour % 128 == 0) {

            e.setDegatObstacle((e.getDegatObstacle() + (e.getDegatObstacle() * 50 / 100)));
            e.améliorationPv((e.getPv() + (e.getPv() * 50 / 100)));
            e.setDegatBase((e.getDegatBase() + (e.getDegatBase() * 50 / 100)));
        }
    }


    public void ajouterTour(Tour t) {
        listeDeTour.add(t);
    }

    public void ajouterObstacle(Obstacle O) {
        listeObstacle.add(O);
    }

    public final ObservableList<Obstacle> getListeObstacle() {
        return listeObstacle;
    }

    public IntegerProperty getArgentProperty() {
        return argent;
    }

    public void setArgent(int prix) {
        this.argent.setValue(this.argent.getValue() - prix);
    }

    public void setArgentAZero() {
        this.argent.setValue(0);
    }

    public void setPvZero() {
        this.pvJoueur.setValue(0);
    }

    public int getArgent() {
        return this.argent.getValue();
    }

    public boolean verifArgent(Tour t) {
        if (t.getCoutAchat() > getArgent()) {
            return false;
        }
        return true;
    }

    public boolean verifArgentObstacle(Obstacle O) {
        if (O.getCoutAchat() > getArgent()) {
            return false;
        }
        return true;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public final IntegerProperty getNbVagueProperty() {
        return this.nbVague;
    }

    public ObservableList<BarreDeVie> getBarreDeVies() {
        return barreDeVies;
    }

    // Cette méthode permet de passer à la vague suivante et en même temps d'augmenter la difficulté du jeu.
    public void vagueSuivante() {

        listeEnnemisSpawn.clear();
        ennemis.clear();
        this.nbVague.setValue(this.nbVague.getValue() + 1);
        this.niveau.setNbEnnemis(this.niveau.getNbEnnemis() * 2);
        this.nbEnnemisRestant.setValue(this.niveau.getNbEnnemis());
        this.vague = new Vague(new MoyenneStrategy());
        this.vague.créerVague(this.niveau.getNbEnnemis(), this.terrain);
        if (this.nbVague.getValue() > 4) {
            this.vague = new Vague(new DifficileStrategy());
            this.vague.créerVague(this.niveau.getNbEnnemis(), this.terrain);        }
    }

    public void ajouterBarreDeVie(BarreDeVie b) {
        barreDeVies.add(b);
    }


    // permet d'ajouter un ennemi qui a spawn sur le terrain dans la liste de notre modèle
    public void spwanEnnemi() {
        Ennemis e = this.vague.getListeEnnemis().pollLast();
        ennemis.add(e);
        assert e != null;
        ajouterBarreDeVie(e.getBarreDeVie());
        this.listeEnnemisSpawn.add(e);
    }

    //permet de récuperer la liste des ennemis ayant spawn
    public ArrayList<Ennemis> getListeEnnemisSpawn() {
        return listeEnnemisSpawn;
    }

    public void ajoutEnnemisMort(Ennemis enm) {
        listeEnnemisTuée.add(enm);
    }

    public ArrayList<Ennemis> getEnnemisTue() {
        return listeEnnemisTuée;
    }


    public void lancementLoop() {
        gameLoop.play();
    }

    public void arretLoop() {
        gameLoop.stop();
    }


    public ObservableList<Ennemis> getEnnemis() {
        return ennemis;
    }

    public IntegerProperty ComptEnnemiTueProperty() {
        return comptEnnemiTue;
    }

    public int getComptEnnemiTue() {
        return this.comptEnnemiTue.getValue();
    }

    public void setComptEnnemiTue() {
        this.comptEnnemiTue.setValue(getComptEnnemiTue() + 1);
    }

    public IntegerProperty getPvJoueurProperty() {
        return this.pvJoueur;
    }

    public int getPvJoueur() {
        return this.pvJoueur.getValue();
    }

    public void setPvJoueur(int pvJoueur) {
        this.pvJoueur.setValue(pvJoueur);
    }

    public ObservableList<Tour> getListeDeTour() {
        return listeDeTour;
    }

    public final void setNbEnnemisRestant(int nbEnnemisRestant) {
        this.nbEnnemisRestant.setValue(nbEnnemisRestant);
    }

    public IntegerProperty nbEnnemisRestantProperty() {
        return nbEnnemisRestant;
    }

    public int getNbEnnemisRestant() {
        return this.nbEnnemisRestant.getValue();
    }

    public void unTour() {
        int[][] tab = terrain.getTabTerrain();
        gererTours();
        for (int i = 0; i < this.ennemis.size(); i++) {
            Ennemis e = this.ennemis.get(i);
            augmentationCapacité(this.nbTour, e);
            if (e.EstBloque()==false) {
                e.seDeplace();
            }
            attaqueEnnemi(e);
            degatBase(e);
            enleveObstacleDetruit(tab, e);
            degatEnnemis(e);
            e.getBarreDeVie().setX(e.getX());
            e.getBarreDeVie().setY(e.getY());
            e.getBarreDeVie().setVie(e.getPv());
            e.getBarreDeVie().miseAJourVieTotale();
        }
        enleveEnnemisMort();
        ajusterArgentEtPv();
        nbTour++;
    }

    private void gererTours() {
        for (Tour tour : this.listeDeTour) {
            tour.strategieAttaque(tour);
            if (tour.getSt() instanceof AttaqueEvolutive) {
                ((AttaqueEvolutive) tour.getSt()).setT(terrain);
                ((AttaqueEvolutive) tour.getSt()).setNbEnnemis(getComptEnnemiTue());
                tour.strategieAttaque(tour);
            }
        }
    }

    private void attaqueEnnemi(Ennemis e) {
        e.setEstBloque(false);
        if (e.getSt() instanceof StrategieChangeante) {
            ((StrategieChangeante) e.getSt()).setNbTour(nbTour);
        }

        for (int j = 0; j < this.listeObstacle.size(); j++){
            Obstacle o = this.listeObstacle.get(j);
            if (e.getSt() instanceof AttaqueCorpsAcorps) {
                e.jeSuisBloque(o);
                e.strategieAttaque(o);
            }
            e.strategieAttaque(o);
        }
    }

    private void ajusterArgentEtPv() {
        if (getArgent() < 0) {
            setArgentAZero();
        }
        if (getPvJoueur() < 0) {
            setPvZero();
        }
    }

    public void gagne() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Bravo !");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/Gagne.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
        JeuController.stage.close();
    }

    public void perdu() throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Mince !");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/Perdu.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
        JeuController.stage.close();
    }

    // La méthode initAnimation permet de faire tourner la gameloop et le jeu par la même occasion.
    public void initAnimation() {
        gameLoop = new Timeline();
        temps = 0;
        gameLoop.setCycleCount(Timeline.INDEFINITE);


        KeyFrame kf = new KeyFrame(
// on définit le FPS (nbre de frame par seconde)

                Duration.seconds(0.09),

                // on définit ce qui se passe à chaque frame
                // c'est un eventHandler d'ou le lambda

                //Si le joueur à gagner ou à perdu la gameloop s'arrête
                (ev -> {
                    if (this.getPvJoueur() == 0 || (this.nbVague.getValue() == 5 && this.getNbEnnemisRestant() == 0)) {
                        menuEnnemiS(vBox);
                        gameLoop.stop();
                    } else if (getNbEnnemisRestant() == 0) {
                        vagueSuivante();
                        getEnnemisTue().removeAll(getEnnemisTue());
                    } else if (temps % 3 == 0) {
                        unTour();
                    } else if (temps % 10 == 0 && getListeEnnemisSpawn().size() < this.niveau.getNbEnnemis()) {
                        spwanEnnemi();
                        menuEnnemiS(vBox);
                        try {
                            menuEnnemiA(vBox);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        temps++;
                    }
                    if (this.getPvJoueur() > 0 && (this.nbVague.getValue() == 5 && getNbEnnemisRestant() == 0)) {
                        try {
                            gagne();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        gameLoop.stop();
                    } else if (this.getPvJoueur() == 0 && getNbEnnemisRestant() >= 0) {
                        try {
                            perdu();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        gameLoop.stop();
                    }
                    temps++;
                })
        );
        gameLoop.getKeyFrames().add(kf);
    }

    // Les ennemis présent sur la map sont ajouté aux menus des ennemis.
    public void menuEnnemiA(VBox vBox) throws FileNotFoundException {

        for (int i = 0; i < ennemis.size(); i++) {
            Ennemis en = ennemis.get(i);
            Image im = new Image(new FileInputStream(en.getChemin()));

            ImageView imV = new ImageView(im);
            vBox.getChildren().add(imV);
            Popup popup = new Popup();
            Label label = new Label("" + en.affichageImmunité());
            label.minHeight(180);
            label.minWidth(180);
            label.setBackground(Background.fill(Color.WHITE));
            popup.getContent().add(label);
            Stage stage = (Stage) vBox.getScene().getWindow();


            imV.setOnMouseEntered(e -> popup.show(stage));
            imV.setOnMouseExited(e -> popup.hide());
            Label l = new Label();
            l.textProperty().bind(en.getPvProperty().asString());
            vBox.getChildren().add(l);
        }
    }

    public void menuEnnemiS(VBox vBox) {
        vBox.getChildren().removeAll(vBox.getChildren());
    }


    public void ameliorationObstacle(ImageView x) {
        for (int i = 0; i < this.listeObstacle.size(); i++) {
            Obstacle o = this.listeObstacle.get(i);
            if (Integer.toString(o.getID()).equals(x.getId())){
                ameliorationPVObstacle = new AmeliorationPVObstacle(o);
                ameliorationPVObstacle.ameliorationObstacle(this);
            }
        }
    }

    public boolean venteObstacle(ImageView x) {
        for (int j = 0; j < getListeObstacle().size(); j++) {
            Obstacle o = getListeObstacle().get(j);
            if (Integer.toString(o.getID()).equals(x.getId())) {
                terrain.getTabTerrain()[o.getPosY()][o.getPosX()] = 9;
                getListeObstacle().remove(o);
                setArgent(-o.getCoutVente());
                return true;
            }
        }
        return false;
    }

    public void ameliorationTour(ImageView x) {
        for (int i = 0; i < getListeDeTour().size(); i++) {
            Tour t = getListeDeTour().get(i);
            if (Integer.toString(t.getID()).equals(x.getId())) {
                if (t.getNiveauAmelioration() != t.getNiveauMaxAmelioration()) {
                    ameliorationDegatTour = new AmeliorationDegatTour(t);
                    ameliorationDegatTour.ameliorationTour(this);
                }
                else
                    System.out.println("niv MAX");
            }
        }
    }

    public boolean venteTour(ImageView x) {
        for (int j = 0; j < getListeDeTour().size(); j++) {
            Tour t = getListeDeTour().get(j);

            if (Integer.toString(t.getID()).equals(x.getId())) {
                getListeDeTour().remove(t);
                setArgent(-t.getCoutVente());
                t.TourDevientInoffensif(terrain, t.getListeCasesDegats());
                return true;
            }
        }
        return false;
    }

    public boolean VerifEtAchatTour(Tour tour) {
        if (verifArgent(tour)) {
            setArgent(tour.getCoutAchat());
            ajouterTour(tour);
            return true;
        }
        return false;
    }

    public boolean VerifEtAchatObstacle(Obstacle obstacle) {
        if (verifArgentObstacle(obstacle)) {
            setArgent(obstacle.getCoutAchat());
            ajouterObstacle(obstacle);
            return true;
        }
        return false;
    }
}
