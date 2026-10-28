package fr.efrei.transfret;

import java.util.List;

public class CalculateurPrix {

    private final ComposantPrix prix;

    public CalculateurPrix(ComposantPrix prix) {
        this.prix = prix;
    }

    public double calculerPrixHT(List<Colis> colis, int distance, ModeTransport mode, boolean urgent, boolean assurance, TypeClient typeClient) {
        return Utils.arrondir(prix.calculer(new DemandeTarif(colis, distance, mode, urgent, assurance, typeClient)));
    }
}
