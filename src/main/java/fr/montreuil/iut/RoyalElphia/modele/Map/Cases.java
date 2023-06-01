package fr.montreuil.iut.RoyalElphia.modele.Map;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Cases {
    private IntegerProperty x,y;

    public Cases(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public int getX() {
        return x.getValue();
    }

    public int getY() {
        return y.getValue();
    }

    public IntegerProperty getXProperty() {
        return this.x;
    }

    public IntegerProperty getYProperty(){
        return this.y;
    }
}