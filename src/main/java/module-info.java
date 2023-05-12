module jeu.royalelphia {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens jeu.royalelphia to javafx.fxml;
    exports jeu.royalelphia;
    exports jeu.royalelphia.Controller;
    opens jeu.royalelphia.Controller to javafx.fxml;
}