module jeu.royalelphia {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    requires junit;


    opens fr.montreuil.iut.RoyalElphia to javafx.fxml;
    exports fr.montreuil.iut.RoyalElphia;
    exports fr.montreuil.iut.RoyalElphia.Controller;
    opens fr.montreuil.iut.RoyalElphia.Controller to javafx.fxml;
    exports fr.montreuil.iut.RoyalElphia.modele;
    opens fr.montreuil.iut.RoyalElphia.modele to javafx.fxml;
    exports fr.montreuil.iut.RoyalElphia.modele.Ennemis;
    opens fr.montreuil.iut.RoyalElphia.modele.Ennemis to javafx.fxml;
    exports fr.montreuil.iut.RoyalElphia.modele.Map;
    opens fr.montreuil.iut.RoyalElphia.modele.Map to javafx.fxml;
    exports fr.montreuil.iut.RoyalElphia.modele.Tour;
    opens fr.montreuil.iut.RoyalElphia.modele.Tour to javafx.fxml;
    exports fr.montreuil.iut.RoyalElphia.modele.Niveau;
    opens fr.montreuil.iut.RoyalElphia.modele.Niveau to javafx.fxml;
}