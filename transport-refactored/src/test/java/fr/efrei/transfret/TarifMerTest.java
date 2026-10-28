package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifMerTest {

    private static final double PRECISION = 0.001;

    private final TarifTransport tarif = new TarifMer();

    @Test
    void cinquante_centimes_par_km_et_trois_centimes_par_kg() {
        assertEquals(5850 * 0.5 + 15000 * 0.03, tarif.calculer(5850, 15000, 67), PRECISION);
    }

    @Test
    void minimum_de_500_euros() {
        assertEquals(500, tarif.calculer(100, 10, 0.1), PRECISION);
    }
}
