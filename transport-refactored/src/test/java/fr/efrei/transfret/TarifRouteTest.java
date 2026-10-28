package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifRouteTest {

    private static final double PRECISION = 0.001;

    private final TarifTransport tarif = new TarifRoute();

    @Test
    void un_euro_vingt_par_km_et_dix_centimes_par_kg() {
        assertEquals(465 * 1.2 + 100 * 0.10, tarif.calculer(465, 100, 0.5), PRECISION);
    }
}
