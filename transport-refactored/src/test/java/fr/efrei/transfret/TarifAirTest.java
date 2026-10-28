package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifAirTest {

    private static final double PRECISION = 0.001;

    private final TarifTransport tarif = new TarifAir();

    @Test
    void facture_au_poids_reel_quand_il_depasse_le_poids_volumetrique() {
        assertEquals(5840 * 0.6 + 100 * 4.5, tarif.calculer(5840, 100, 0.1), PRECISION);
    }

    @Test
    void facture_au_poids_volumetrique_quand_il_depasse_le_poids_reel() {
        assertEquals(5840 * 0.6 + 167 * 4.5, tarif.calculer(5840, 10, 1), PRECISION);
    }
}
