package fr.efrei.transfret;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicule implements IVehicule {

    protected String immatriculation;
    protected double capaciteMax;
    protected double chargeActuelle;
    protected boolean disponible = true;
    protected List<Colis> chargement = new ArrayList<Colis>();
    private final ModeTransport mode;

    public Vehicule(String immatriculation, double capaciteMax, ModeTransport mode) {
        this.immatriculation = immatriculation;
        this.capaciteMax = capaciteMax;
        this.mode = mode;
    }

    // vrai si le véhicule est disponible, a la place et sait transporter ces marchandises dans ce mode
    public boolean peutPrendreEnCharge(ModeTransport mode, double poids, boolean dangereux, boolean refrigere) {
        return disponible
                && capaciteMax - chargeActuelle >= poids
                && this.mode == mode
                && accepte(dangereux, refrigere);
    }

    // vrai si le véhicule sait transporter un chargement avec (ou sans) matières dangereuses et réfrigérées
    protected abstract boolean accepte(boolean dangereux, boolean refrigere);

    // vrai si ce type de marchandise peut être chargé dans le véhicule
    protected boolean accepteMarchandise(TypeMarchandise type) {
        return true;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public double getCapaciteMax() {
        return capaciteMax;
    }

    public double getChargeActuelle() {
        return chargeActuelle;
    }

    public boolean estDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Charge un colis.
     *
     * @throws IllegalArgumentException si le véhicule n'accepte pas ce type de marchandise
     */
    public void charger(Colis colis) {
        if (!accepteMarchandise(colis.getType())) {
            throw new IllegalArgumentException(messageMarchandiseRefusee());
        }
        if (chargeActuelle + colis.getPoids() > capaciteMax) {
            System.out.println("ERREUR : capacité dépassée pour " + immatriculation);
            return;
        }
        chargement.add(colis);
        chargeActuelle = chargeActuelle + colis.getPoids();
    }

    public void decharger(Colis colis) {
        if (chargement.remove(colis)) {
            chargeActuelle = chargeActuelle - colis.getPoids();
        }
    }

    protected String messageMarchandiseRefusee() {
        return "Marchandise refusée par " + immatriculation;
    }

    // fait partir le véhicule pour un trajet de distanceKm kilomètres
    public abstract void partir(int distanceKm);

    // fait le plein avant le départ
    public void preparerDepart() {
        System.out.println("Plein effectué pour " + immatriculation);
    }
}
