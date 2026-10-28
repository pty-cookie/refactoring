package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemisePremiumTest {

    private static final double PRECISION = 0.001;

    @Test
    void vingt_pourcent() {
        assertEquals(800, new RemisePremium().appliquer(1000), PRECISION);
    }
}
