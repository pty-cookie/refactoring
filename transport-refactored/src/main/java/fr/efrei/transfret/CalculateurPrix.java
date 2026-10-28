package fr.efrei.transfret;

import java.util.List;

public class CalculateurPrix {

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
        double prix;
        if (mode == ModeTransport.ROUTE) {
            prix = distance * 1.2 + poids * 0.10;
        } else if (mode == ModeTransport.RAIL) {
            prix = distance * 0.8 + poids * 0.07;
            if (prix < 150) prix = 150;
        } else if (mode == ModeTransport.MER) {
            prix = distance * 0.5 + poids * 0.03;
            if (prix < 500) prix = 500;
        } else if (mode == ModeTransport.AIR) {
            double poidsTaxable = poids;
            if (volume * 167 > poids) {
                poidsTaxable = volume * 167;
            }
            prix = distance * 0.6 + poidsTaxable * 4.5;
        } else {
            throw new IllegalArgumentException("Mode inconnu : " + mode);
        }

        // suppléments
        if (fragile) prix = prix * 1.15;
        if (dangereux) prix = prix * 1.30;
        if (refrigere) prix = prix * 1.20;
        if (urgent) prix = prix * 1.5;

        // remise client
        if (typeClient == TypeClient.ENTREPRISE) {
            if (prix > 5000) {
                prix = prix * 0.85;
            } else {
                prix = prix * 0.90;
            }
        } else if (typeClient == TypeClient.PREMIUM) {
            prix = prix * 0.80;
        }

        // assurance
        if (assurance) {
            double montantAssurance = valeur * 0.02;
            if (montantAssurance < 15) montantAssurance = 15;
            prix = prix + montantAssurance;
        }
        return Utils.arrondir(prix);
    }
}
