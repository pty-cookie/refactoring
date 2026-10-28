package fr.efrei.transfret;

public class Camion extends Vehicule {

    protected boolean adr; // certification matières dangereuses

    public Camion(String immatriculation, double capaciteMax, boolean adr) {
        super(immatriculation, capaciteMax, ModeTransport.ROUTE);
        this.adr = adr;
    }

    @Override
    protected boolean accepte(boolean dangereux, boolean refrigere) {
        return !refrigere && (!dangereux || adr);
    }

    @Override
    public void partir(int distanceKm) {
        rouler(distanceKm);
    }

    private void rouler(int km) {
        System.out.println("Le camion " + immatriculation + " roule sur " + km + " km");
    }
}
