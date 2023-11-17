package fr.montreuil.iut.RoyalElphia.modele.Tour;

import fr.montreuil.iut.RoyalElphia.modele.Tour.StrategieTour.AttaqueRecharge;

public class TourFleche extends Tour {

    public TourFleche() {
        super(5,4,500, new AttaqueRecharge());
        setCoutAchat(20);
        setCoutVente(10);
        setCoutAmelioration(5);
        setNiveauMaxAmelioration(5);
    }
    public String getChemin() {
        return "src/main/resources/fr/montreuil/iut/RoyalElphia/ImageTour/TourFlecheM.png";
    }

    @Override
    public void strategieAttaque(Tour T) {
        st.attaque(T);
    }

}
