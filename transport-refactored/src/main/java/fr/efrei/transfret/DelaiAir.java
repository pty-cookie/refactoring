package fr.efrei.transfret;

public class DelaiAir implements DelaiLivraison {

    private static final int JOURS = 1;
    private static final int JOURS_LONG_COURRIER = 2;
    private static final int JOURS_URGENT = 1;
    private static final int DISTANCE_LONG_COURRIER_KM = 3000;

    @Override
    public int calculerJours(int distance, boolean urgent) {
        int jours = JOURS;
        if (distance > DISTANCE_LONG_COURRIER_KM) jours = JOURS_LONG_COURRIER;
        if (urgent) jours = JOURS_URGENT;
        return jours;
    }
}
