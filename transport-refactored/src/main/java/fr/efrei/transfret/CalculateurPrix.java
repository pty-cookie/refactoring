package fr.efrei.transfret;

import java.util.List;

public class CalculateurPrix {

    private static final double TAUX_ASSURANCE = 0.02;
    private static final double MINIMUM_ASSURANCE = 15;

    private final ComposantPrix tarifAvecSupplements =
            new SupplementUrgence(new SupplementRefrigere(new SupplementDangereux(new SupplementFragile(new TarifDeBase()))));

    public double calculerPrixHT(List<Colis> colis, int distance, ModeTransport mode, boolean urgent, boolean assurance, TypeClient typeClient) {
        DemandeTarif demande = new DemandeTarif(colis, distance, mode, urgent, assurance, typeClient);

        // tarif de base selon le mode, puis suppléments
        double prix = tarifAvecSupplements.calculer(demande);

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
