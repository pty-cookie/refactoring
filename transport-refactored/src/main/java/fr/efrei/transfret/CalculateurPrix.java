package fr.efrei.transfret;

import java.util.List;

public class CalculateurPrix {

    private static final double COEFFICIENT_FRAGILE = 1.15;
    private static final double COEFFICIENT_DANGEREUX = 1.30;
    private static final double COEFFICIENT_REFRIGERE = 1.20;
    private static final double COEFFICIENT_URGENT = 1.5;

    private static final double SEUIL_REMISE_ENTREPRISE_MAJOREE = 5000;
    private static final double COEFFICIENT_REMISE_ENTREPRISE_MAJOREE = 0.85;
    private static final double COEFFICIENT_REMISE_ENTREPRISE = 0.90;
    private static final double COEFFICIENT_REMISE_PREMIUM = 0.80;

    private static final double TAUX_ASSURANCE = 0.02;
    private static final double MINIMUM_ASSURANCE = 15;

    public double calculerPrixHT(List<Colis> colis, int distance, ModeTransport mode, boolean urgent, boolean assurance, TypeClient typeClient) {
        double poids = 0;
        double volume = 0;
        double valeur = 0;
        boolean fragile = false;
        boolean dangereux = false;
        boolean refrigere = false;
        for (Colis c : colis) {
            poids = poids + c.getPoids();
            volume = volume + c.getVolume();
            valeur = valeur + c.getValeurDeclaree();
            if (c.getType() == TypeMarchandise.FRAGILE) fragile = true;
            if (c.getType() == TypeMarchandise.DANGEREUX) dangereux = true;
            if (c.getType() == TypeMarchandise.REFRIGERE) refrigere = true;
        }

        // tarif de base selon le mode
        double prix = mode.getTarif().calculer(distance, poids, volume);

        // suppléments
        if (fragile) prix = prix * COEFFICIENT_FRAGILE;
        if (dangereux) prix = prix * COEFFICIENT_DANGEREUX;
        if (refrigere) prix = prix * COEFFICIENT_REFRIGERE;
        if (urgent) prix = prix * COEFFICIENT_URGENT;

        // remise client
        if (typeClient == TypeClient.ENTREPRISE) {
            if (prix > SEUIL_REMISE_ENTREPRISE_MAJOREE) {
                prix = prix * COEFFICIENT_REMISE_ENTREPRISE_MAJOREE;
            } else {
                prix = prix * COEFFICIENT_REMISE_ENTREPRISE;
            }
        } else if (typeClient == TypeClient.PREMIUM) {
            prix = prix * COEFFICIENT_REMISE_PREMIUM;
        }

        // assurance
        if (assurance) {
            double montantAssurance = valeur * TAUX_ASSURANCE;
            if (montantAssurance < MINIMUM_ASSURANCE) montantAssurance = MINIMUM_ASSURANCE;
            prix = prix + montantAssurance;
        }
        return Utils.arrondir(prix);
    }
}
