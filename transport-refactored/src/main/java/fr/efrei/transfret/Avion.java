package fr.efrei.transfret;

public class Avion extends Vehicule {

    private static final int DISTANCE_ROULAGE_PISTE_KM = 2;
    private static final int ALTITUDE_CROISIERE_PIEDS = 35000;

    public Avion(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, ModeTransport.AIR);
    }

    @Override
    protected boolean accepte(boolean dangereux, boolean refrigere) {
        return true;
    }

    @Override
    public void partir(int distanceKm) {
        rouler(DISTANCE_ROULAGE_PISTE_KM);
        voler(ALTITUDE_CROISIERE_PIEDS);
    }

    private void rouler(int km) {
        // roulage sur la piste
        System.out.println("L'avion " + immatriculation + " roule sur la piste");
    }

    private void voler(int altitude) {
        System.out.println("L'avion " + immatriculation + " vole à " + altitude + " pieds");
    }
}
