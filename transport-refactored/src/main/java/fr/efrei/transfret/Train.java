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

    private void rouler(int km) {
        System.out.println("Le train " + immatriculation + " circule sur " + km + " km de voies ferrées");
    }

    @Override
    public void preparerDepart() {
        // un train électrique ne fait pas le plein
    }
}
