package fr.efrei.transfret;

public class Bateau extends Vehicule {

    private static final double KM_PAR_MILLE_NAUTIQUE = 1.852;

    private boolean conteneursRefrigeres;

    public Bateau(String immatriculation, double capaciteMax, boolean conteneursRefrigeres) {
        super(immatriculation, capaciteMax, ModeTransport.MER);
        this.conteneursRefrigeres = conteneursRefrigeres;
    }

    @Override
    protected boolean accepte(boolean dangereux, boolean refrigere) {
        return !refrigere || conteneursRefrigeres;
    }

    @Override
    public void partir(int distanceKm) {
        naviguer((int) (distanceKm / KM_PAR_MILLE_NAUTIQUE));
    }

    public void rouler(int km) {
        throw new UnsupportedOperationException("Un bateau ne roule pas");
    }

    public void naviguer(int milesNautiques) {
        System.out.println("Le navire " + immatriculation + " navigue sur " + milesNautiques + " milles nautiques");
    }

    public void voler(int altitude) {
        throw new UnsupportedOperationException("Un bateau ne vole pas");
    }

    public void activerRefrigeration(double temperature) {
        if (!conteneursRefrigeres) {
            throw new UnsupportedOperationException("Pas de conteneurs frigorifiques sur ce navire");
        }
        System.out.println("Conteneurs frigorifiques réglés à " + temperature + "°C");
    }

    public boolean peutTransporterMatieresDangereuses() {
        return true;
    }

    public boolean aConteneursRefrigeres() {
        return conteneursRefrigeres;
    }
}
