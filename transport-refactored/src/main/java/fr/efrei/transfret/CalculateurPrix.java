package fr.efrei.transfret;

import java.util.List;

public class CalculateurPrix {

    private static final double COEFFICIENT_FRAGILE = 1.15;
    private static final double COEFFICIENT_DANGEREUX = 1.30;
    private static final double COEFFICIENT_REFRIGERE = 1.20;
    private static final double COEFFICIENT_URGENT = 1.5;

    private static final double TAUX_ASSURANCE = 0.02;
    private static final double MINIMUM_ASSURANCE = 15;

    public double calculerPrixHT(List<Colis> colis, int distance, ModeTransport mode, boolean urgent, boolean assurance, TypeClient typeClient) {
        DemandeTarif demande = new DemandeTarif(colis, distance, mode, urgent, assurance, typeClient);

        // tarif de base selon le mode
        double prix = mode.getTarif().calculer(distance, demande.poidsTotal(), demande.volumeTotal());

        // suppléments
        if (demande.contient(TypeMarchandise.FRAGILE)) prix = prix * COEFFICIENT_FRAGILE;
        if (demande.contient(TypeMarchandise.DANGEREUX)) prix = prix * COEFFICIENT_DANGEREUX;
        if (demande.contient(TypeMarchandise.REFRIGERE)) prix = prix * COEFFICIENT_REFRIGERE;
        if (urgent) prix = prix * COEFFICIENT_URGENT;

        // remise client
        prix = typeClient.getPolitiqueRemise().appliquer(prix);

        // assurance
        if (assurance) {
            double montantAssurance = demande.valeurTotale() * TAUX_ASSURANCE;
            if (montantAssurance < MINIMUM_ASSURANCE) montantAssurance = MINIMUM_ASSURANCE;
            prix = prix + montantAssurance;
        }
        return Utils.arrondir(prix);
    }
}
