package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifRailTest {

    private static final double PRECISION = 0.001;

    private final TarifTransport tarif = new TarifRail();

    @Test
    void quatre_vingts_centimes_par_km_et_sept_centimes_par_kg() {
        assertEquals(465 * 0.8 + 100 * 0.07, tarif.calculer(465, 100, 0.5), PRECISION);
    }

    @Test
    void minimum_de_150_euros() {
        assertEquals(150, tarif.calculer(100, 10, 0.1), PRECISION);
    }
}
