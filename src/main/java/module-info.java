module jeu.royalelphia {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.montreuil.iut.RoyalElphia to javafx.fxml;
    exports fr.montreuil.iut.RoyalElphia;
    exports fr.montreuil.iut.RoyalElphia.Controller;
    opens fr.montreuil.iut.RoyalElphia.Controller to javafx.fxml;
    exports fr.montreuil.iut.RoyalElphia.modele;
    opens fr.montreuil.iut.RoyalElphia.modele to javafx.fxml;
}