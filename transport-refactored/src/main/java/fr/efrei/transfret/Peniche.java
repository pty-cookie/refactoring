package fr.efrei.transfret;

public class Peniche extends Vehicule {

    public Peniche(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, ModeTransport.FLUVIAL);
    }

    // pas de cale réfrigérée
    @Override
    protected boolean accepte(boolean dangereux, boolean refrigere) {
        return !refrigere;
    }

    @Override
    public void partir(int distanceKm) {
        System.out.println("La péniche " + immatriculation + " navigue sur " + distanceKm + " km de voies fluviales");
    }
}
