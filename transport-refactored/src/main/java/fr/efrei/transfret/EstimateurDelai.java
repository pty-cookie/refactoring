package fr.efrei.transfret;

public class EstimateurDelai {

    private static final int DELAI_MINIMUM_JOURS = 1;

    // retourne le délai de livraison en jours
    public int calculerDelai(int distance, ModeTransport mode, boolean urgent) {
        int jours = mode.getDelai().calculerJours(distance, urgent);
        if (jours < DELAI_MINIMUM_JOURS) jours = DELAI_MINIMUM_JOURS;
        return jours;
    }
}
