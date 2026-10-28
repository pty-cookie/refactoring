package fr.efrei.transfret;

import java.util.List;

/**
 * Tout ce qu'il faut savoir d'une expédition (ou d'un devis) pour en calculer le prix.
 */
public record DemandeTarif(List<Colis> colis, int distance, ModeTransport mode, boolean urgent, boolean assurance,
                           TypeClient typeClient) {

    public double poidsTotal() {
        double poids = 0;
        for (Colis c : colis) {
            poids = poids + c.getPoids();
        }
        return poids;
    }

    public double volumeTotal() {
        double volume = 0;
        for (Colis c : colis) {
            volume = volume + c.getVolume();
        }
        return volume;
    }

    public double valeurTotale() {
        double valeur = 0;
        for (Colis c : colis) {
            valeur = valeur + c.getValeurDeclaree();
        }
        return valeur;
    }

    public boolean contient(TypeMarchandise type) {
        return Colis.auMoinsUn(colis, type);
    }
}
