package fr.efrei.transfret;

public class Avion extends Vehicule {

    private static final int DISTANCE_ROULAGE_PISTE_KM = 2;
    private static final int ALTITUDE_CROISIERE_PIEDS = 35000;

    public Avion(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax);
    }

    @Override
    public void partir(int distanceKm) {
        rouler(DISTANCE_ROULAGE_PISTE_KM);
        voler(ALTITUDE_CROISIERE_PIEDS);
    }

    public void rouler(int km) {
        // roulage sur la piste
        System.out.println("L'avion " + immatriculation + " roule sur la piste");
    }

    public void naviguer(int milesNautiques) {
        throw new UnsupportedOperationException("Un avion ne navigue pas");
    }

    public void voler(int altitude) {
        System.out.println("L'avion " + immatriculation + " vole à " + altitude + " pieds");
    }

    public void activerRefrigeration(double temperature) {
        throw new UnsupportedOperationException("Pas de soute réfrigérée");
    }

    public boolean peutTransporterMatieresDangereuses() {
        return false;
    }
}
