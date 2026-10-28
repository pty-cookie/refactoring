package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemiseEntrepriseTest {

    private static final double PRECISION = 0.001;

    private final PolitiqueRemise remise = new RemiseEntreprise();

    @Test
    void dix_pourcent_jusqu_a_5000_euros() {
        assertEquals(900, remise.appliquer(1000), PRECISION);
        assertEquals(4500, remise.appliquer(5000), PRECISION);
    }

    @Test
    void quinze_pourcent_au_dela_de_5000_euros() {
        assertEquals(8500, remise.appliquer(10000), PRECISION);
    }
}
