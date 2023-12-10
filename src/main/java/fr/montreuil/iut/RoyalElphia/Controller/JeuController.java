package fr.montreuil.iut.RoyalElphia.Controller;

import fr.montreuil.iut.RoyalElphia.LancementJeu;
import fr.montreuil.iut.RoyalElphia.Vue.*;
import fr.montreuil.iut.RoyalElphia.modele.*;
import fr.montreuil.iut.RoyalElphia.modele.Ennemis.*;
import fr.montreuil.iut.RoyalElphia.modele.JDBC.DefenseDAO;
import fr.montreuil.iut.RoyalElphia.modele.JDBC.EnnemiDAO;
import fr.montreuil.iut.RoyalElphia.modele.JDBC.NiveauDAO;
import fr.montreuil.iut.RoyalElphia.modele.Map.Maps;
import fr.montreuil.iut.RoyalElphia.modele.Map.Terrain;
import fr.montreuil.iut.RoyalElphia.modele.Niveau.Niveau;
import fr.montreuil.iut.RoyalElphia.modele.Obstacle.*;
import fr.montreuil.iut.RoyalElphia.modele.Tour.*;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/*
La classe JeuController à pour but de récuperer les données choisis par le joueur est créer le jeu.
 */

public class JeuController implements Initializable {


    private Terrain terrain;
    @FXML
    private TilePane map;

    public static Stage stage;
    @FXML
    public static Button ButtonRejouer;
    @FXML
    public Button ButtonQuitter;
    @FXML
    public Button ButtonPause;
    @FXML
    private VBox menuEnnemi;
    private Jeu jeu;
    private Niveau niveau;

    @FXML
    private Label LabelPV, LabelnbEnnemisRestant, LabelArgent, LabelVague, LabelMort;
    @FXML
    private Pane panneauJeu;

    private Tour tour;
    private Obstacle obstacle;

    private boolean TourPose = true;

    private boolean ObstaclePose = true;
    private VueTour vt = new VueTour();
    private VueObstacle vo = new VueObstacle();

    // La méthode cliqueObstacle permet de récuperer l'obstacle choisi par le joueur et le créer.


    @FXML
    public void cliqueObstacle(MouseEvent mouseEvent) throws FileNotFoundException {
        if (this.ObstaclePose && obstacle == null && mouseEvent.getClickCount() == 2) {
            String imageId = ((ImageView) mouseEvent.getSource()).getId();
            Obstacle obstacle = null;

            switch (imageId) {
                case "bois":
                    obstacle = new BarricadeBois();
                    break;
                case "fer":
                    obstacle = new BarricadeFer();
                    break;
                case "metal":
                    obstacle = new BarricadeMetal();
                    break;
                case "pierre":
                    obstacle = new BarricadePierre();
                    break;
            }
            if (obstacle != null && jeu.verifArgentObstacle(obstacle)) {
                vo.CliqueObstacle(this.jeu, imageId);
                this.obstacle = vo.getObstacle();
                this.ObstaclePose = false;
            }
        }
    }

    // La méthode TourClique permet de récuperer la tour  choisi par le joueur et la créer.

    @FXML
    public void TourClique(MouseEvent mouseEvent) {
        if (this.TourPose && tour == null && mouseEvent.getClickCount() == 2) {
            String imageId = ((ImageView) mouseEvent.getSource()).getId();
            Tour tour = null;

            switch (imageId) {
                case "bombe":
                    tour = new TourABombe();
                    break;
                case "feu":
                    tour = new TourBouleDeFeu();
                    break;
                case "fleche":
                    tour = new TourFleche();
                    break;
                case "eclair":
                    tour = new TourElectrique();
                    break;
                case "laser":
                    tour = new TourLaser();
                    break;
            }
            if (tour != null && jeu.verifArgent(tour)) {
                System.out.println();
                vt.CliqueTour(this.jeu, imageId);
                this.tour = vt.getTour();
                this.TourPose = false;
            }
        }
    }

    // la méthode poser Item récupère le clique sur la map du joueur afin de créer la vue de l'obstacle et le poser sur la map
    @FXML
    public void poserItem(MouseEvent mouseEvent) throws FileNotFoundException {
        double cliqueX = mouseEvent.getX();
        double cliqueY = mouseEvent.getY();
        if(this.obstacle != null){
            VueObstacle vueObstacle = new VueObstacle(panneauJeu, obstacle, cliqueX, cliqueY, terrain,jeu);
            vueObstacle.PoserObstacle();
            this.ObstaclePose = true;
            this.obstacle = vueObstacle.getObstacle();
        }
        if(this.tour != null){
            VueTour vueTour = new VueTour(panneauJeu, tour, cliqueX, cliqueY, terrain, jeu);
            vueTour.PoserTour();
            this.TourPose = true;
            this.tour = vueTour.getTour();
        }

        }

        // La méthode créerNiveau récupère  le choix du joueur entrer sur la page ChoixMap et créer le niveau associé.

    public void créerNiveau(){
        int niveau = ChoixMapController.getNiveau();
        if (niveau == 1) {
            this.niveau = new Niveau(1);
        } else if (niveau == 2) {
            this.niveau = new Niveau(5);
        } else if (niveau == 3) {
            this.niveau = new Niveau(10);
        }
    }

    // La méthode créerTerrain récupère le choix de map du joueur entrer sur la page ChoixMap et créer le terrain associé.

    public void créerTerrain() {
        int terrain = ChoixMapController.getTerrain();
        if (terrain == 1) {
            this.terrain = new Maps(2);
        } else if (terrain == 2) {
            this.terrain = new Maps(1);
        }
    }

    // La méthode création Partie permet de créer le niveau et le terrain et l'affecter à la nouvelle partie

    public void créationPartie() {
        créerNiveau();
        créerTerrain();
        this.jeu = Jeu.getInstance(this.terrain,this.niveau,this.menuEnnemi);
    }


    // La méthode boutonCaractéristique permet charge la page Caractéristiques des tours.
    @FXML
    public void BoutonCaracteristiques(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Caractéristiques des tours");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/CaracteristiquesTours.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }



    // La méthode permet de gérer les écouteur entre le modèle et la vue et de lancer le jeu.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        créationPartie();

        envoieDonneeBD();

        jeu.initAnimation();
        TerrainVue terrainVue = new TerrainVue(terrain, map);
        this.LabelVague.textProperty().bind(this.jeu.getNbVagueProperty().asString());
        this.LabelArgent.textProperty().bind(this.jeu.getArgentProperty().asString().concat(" $"));
        this.LabelPV.textProperty().bind(this.jeu.getPvJoueurProperty().asString().concat(" pv"));
        this.LabelnbEnnemisRestant.textProperty().bind(this.jeu.nbEnnemisRestantProperty().asString());
        this.LabelMort.textProperty().bind(this.jeu.ComptEnnemiTueProperty().asString());

        ListChangeListener<Ennemis> listenerEnnemis = new ListObsEnnemis(this.jeu, this.panneauJeu);
        jeu.getEnnemis().addListener(listenerEnnemis);

        ListChangeListener<Obstacle> listenerObstacle = new ListObservableObstacle(this.jeu, this.panneauJeu);
        jeu.getListeObstacle().addListener(listenerObstacle);

        ListChangeListener<Tour> listenerTour = new ListObservableTour(this.jeu, this.panneauJeu);
        jeu.getListeDeTour().addListener(listenerTour);

        ListChangeListener<BarreDeVie> listenB = new ListObsBarreDeVie(panneauJeu);
        jeu.getBarreDeVies().addListener(listenB);
    }

    private void envoieDonneeBD() {
        EnnemiDAO ennemiDAO = new EnnemiDAO();
        Ennemis e;
        e = new Géant(terrain);
        ennemiDAO.envoieDonnerDebut("Geant", e.getPv(), e.getPtsDefense(), e.getDegatBase(), e.getDegatObstacle(), e.getButin(), String.valueOf(e.getImmunite()), e.getCapaciteObstacle(), String.valueOf(e.getSt()), String.valueOf(e.getStd()));
        e = new gobelins(terrain);
        ennemiDAO.envoieDonnerDebut("Gobelin", e.getPv(), e.getPtsDefense(), e.getDegatBase(), e.getDegatObstacle(), e.getButin(), String.valueOf(e.getImmunite()), e.getCapaciteObstacle(), String.valueOf(e.getSt()), String.valueOf(e.getStd()));
        e = new GéantRoyal(terrain);
        ennemiDAO.envoieDonnerDebut("GéantRoyal", e.getPv(), e.getPtsDefense(), e.getDegatBase(), e.getDegatObstacle(), e.getButin(), String.valueOf(e.getImmunite()), e.getCapaciteObstacle(), String.valueOf(e.getSt()), String.valueOf(e.getStd()));
        e = new Sorcières(terrain);
        ennemiDAO.envoieDonnerDebut("Sorcières", e.getPv(), e.getPtsDefense(), e.getDegatBase(), e.getDegatObstacle(), e.getButin(), String.valueOf(e.getImmunite()), e.getCapaciteObstacle(), String.valueOf(e.getSt()), String.valueOf(e.getStd()));
        e = new Squelette(terrain);
        ennemiDAO.envoieDonnerDebut("Squelette", e.getPv(), e.getPtsDefense(), e.getDegatBase(), e.getDegatObstacle(), e.getButin(), String.valueOf(e.getImmunite()), e.getCapaciteObstacle(), String.valueOf(e.getSt()), String.valueOf(e.getStd()));

        DefenseDAO defenseDAO = new DefenseDAO();
        Tour d;
        d = new TourABombe();
        defenseDAO.envoieDonnerDebut("TourABombe", d.getCoutAchat(), d.getCoutVente(), d.getNiveauAmelioration(), d.getNiveauMaxAmelioration(), String.valueOf(d.getSt()));
        d = new TourElectrique();
        defenseDAO.envoieDonnerDebut("TourElectrique", d.getCoutAchat(), d.getCoutVente(), d.getNiveauAmelioration(), d.getNiveauMaxAmelioration(), String.valueOf(d.getSt()));
        d = new TourBouleDeFeu();
        defenseDAO.envoieDonnerDebut("TourBouleDeFeu", d.getCoutAchat(), d.getCoutVente(), d.getNiveauAmelioration(), d.getNiveauMaxAmelioration(), String.valueOf(d.getSt()));
        d = new TourFleche();
        defenseDAO.envoieDonnerDebut("TourFleche", d.getCoutAchat(), d.getCoutVente(), d.getNiveauAmelioration(), d.getNiveauMaxAmelioration(), String.valueOf(d.getSt()));
        d = new TourLaser();
        defenseDAO.envoieDonnerDebut("TourLaser", d.getCoutAchat(), d.getCoutVente(), d.getNiveauAmelioration(), d.getNiveauMaxAmelioration(), String.valueOf(d.getSt()));

        Obstacle o;
        o = new BarricadeBois();
        defenseDAO.envoieDonnerDebut("BarricadeBois", o.getCoutAchat(), o.getCoutVente(), o.getNiveauAmelioration(), o.getNiveauMaxAmelioration(), "null");
        o = new BarricadeFer();
        defenseDAO.envoieDonnerDebut("BarricadeFer", o.getCoutAchat(), o.getCoutVente(), o.getNiveauAmelioration(), o.getNiveauMaxAmelioration(), "null");
        o = new BarricadeMetal();
        defenseDAO.envoieDonnerDebut("BarricadeMetal", o.getCoutAchat(), o.getCoutVente(), o.getNiveauAmelioration(), o.getNiveauMaxAmelioration(), "null");
        o = new BarricadePierre();
        defenseDAO.envoieDonnerDebut("BarricadePierre", o.getCoutAchat(), o.getCoutVente(), o.getNiveauAmelioration(), o.getNiveauMaxAmelioration(), "null");

        NiveauDAO niveauDAO = new NiveauDAO();
        Niveau n;
        n = new Niveau(1);
        niveauDAO.envoieDonnerDebut("Facile", n.getNbEnnemis()*36);
        n = new Niveau(5);
        niveauDAO.envoieDonnerDebut("Moyen", n.getNbEnnemis()*36);
        n = new Niveau(10);
        niveauDAO.envoieDonnerDebut("Difficile", n.getNbEnnemis()*36);
    }

    // La méthode démarrer permet de lancer la gameloop lors du click sur le bouton démarrer
    @FXML
    public void Demarrer(Event event) {
        stage = (Stage)this.panneauJeu.getScene().getWindow();
        jeu.lancementLoop();
    }

    // La méthode pause permet d'arrêter la gameloop
    @FXML
    public void Pause(Event event) {
        jeu.arretLoop();
    }

    //La méthode rejouer permet de charger la page ChoixMap afin que le joueur puisse rejouer une partie
    public void Rejouer(ActionEvent actionEvent) throws IOException{
        Stage newWindow = new Stage();
        newWindow.setTitle("Paramètres de ma partie");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/ChoixMap.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
        ((Stage)  LabelPV.getScene().getWindow()).close();
    }

    // La méthode  caracteristiqueObstacle permet charger la page Caractéristiques des obstacles.
    public void caracteristiqueObstacle(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Caractéristiques des obstacles");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/CaracteristiquesObstacles.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
    }

    // La méthode Quitter permet au clique sur le bouton quitter de revenir à la page d'accueil.
    public void Quitter(ActionEvent actionEvent) throws IOException {
        Stage newWindow = new Stage();
        newWindow.setTitle("Paramètres de ma partie");
        FXMLLoader loader = new FXMLLoader(LancementJeu.class.getResource("Page_Fxml/Acceuil.fxml"));
        newWindow.setScene(new Scene(loader.load()));
        newWindow.show();
        ((Stage)  LabelPV.getScene().getWindow()).close();
    }
}

