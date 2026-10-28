package fr.efrei.transfret;

public class Train extends Vehicule {

    public Train(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, ModeTransport.RAIL);
    }

    @Override
    protected boolean accepte(boolean dangereux, boolean refrigere) {
        return true;
    }

    @Override
    public void partir(int distanceKm) {
        rouler(distanceKm);
    }

    public void rouler(int km) {
        System.out.println("Le train " + immatriculation + " circule sur " + km + " km de voies ferrées");
    }

    public void naviguer(int milesNautiques) {
        throw new UnsupportedOperationException("Un train ne navigue pas");
    }

    public void voler(int altitude) {
        throw new UnsupportedOperationException("Un train ne vole pas");
    }

    public void activerRefrigeration(double temperature) {
        throw new UnsupportedOperationException("Pas de wagons frigorifiques");
    }

    public boolean peutTransporterMatieresDangereuses() {
        return true;
    }

    @Override
    public void preparerDepart() {
        // un train électrique ne fait pas le plein
    }
}
