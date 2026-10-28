package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SansRemiseTest {

    private static final double PRECISION = 0.001;

    @Test
    void le_prix_est_inchange() {
        assertEquals(1000, new SansRemise().appliquer(1000), PRECISION);
    }
}
