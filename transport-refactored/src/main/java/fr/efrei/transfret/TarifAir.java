package fr.efrei.transfret;

public class TarifAir implements TarifTransport {

    private static final double TARIF_KM = 0.6;
    private static final double TARIF_KG_TAXABLE = 4.5;
    private static final double KG_VOLUMETRIQUES_PAR_M3 = 167;

    @Override
    public double calculer(int distance, double poids, double volume) {
        double poidsTaxable = poids;
        if (volume * KG_VOLUMETRIQUES_PAR_M3 > poids) {
            poidsTaxable = volume * KG_VOLUMETRIQUES_PAR_M3;
        }
        return distance * TARIF_KM + poidsTaxable * TARIF_KG_TAXABLE;
    }
}
