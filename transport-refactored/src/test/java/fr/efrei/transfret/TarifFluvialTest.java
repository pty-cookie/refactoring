package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifFluvialTest {

    private static final double PRECISION = 0.001;

    private final TarifTransport tarif = new TarifFluvial();

    @Test
    void quarante_centimes_par_km_et_deux_centimes_par_kg() {
        assertEquals(365 * 0.40 + 20000 * 0.02, tarif.calculer(365, 20000, 30), PRECISION);
    }

    @Test
    void minimum_de_300_euros() {
        assertEquals(300, tarif.calculer(365, 1000, 1), PRECISION);
    }
}
