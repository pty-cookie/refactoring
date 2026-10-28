package fr.efrei.transfret;

public class DelaiRail implements DelaiLivraison {

    private static final double KM_PAR_JOUR = 1440.0;
    private static final int JOURS_MANUTENTION = 1;
    private static final int JOURS_GAGNES_URGENT = 1;

    @Override
    public int calculerJours(int distance, boolean urgent) {
        int jours = (int) Math.ceil(distance / KM_PAR_JOUR) + JOURS_MANUTENTION;
        if (urgent) jours = jours - JOURS_GAGNES_URGENT;
        return jours;
    }
}
