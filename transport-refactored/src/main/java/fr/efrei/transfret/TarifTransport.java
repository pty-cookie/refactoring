package fr.efrei.transfret;

/**
 * Tarif de base d'un mode de transport (patron Strategy).
 */
public interface TarifTransport {

    double calculer(int distance, double poids, double volume);
}
