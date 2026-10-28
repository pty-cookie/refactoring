package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PenicheTest {

    private final Peniche peniche = new Peniche("PEN-0001", 2500000);

    @Test
    void prend_en_charge_le_fluvial_y_compris_les_matieres_dangereuses() {
        assertTrue(peniche.peutPrendreEnCharge(ModeTransport.FLUVIAL, 1000, false, false));
        assertTrue(peniche.peutPrendreEnCharge(ModeTransport.FLUVIAL, 1000, true, false));
    }

    @Test
    void refuse_les_autres_modes_le_refrigere_et_les_surcharges() {
        assertFalse(peniche.peutPrendreEnCharge(ModeTransport.MER, 1000, false, false));
        assertFalse(peniche.peutPrendreEnCharge(ModeTransport.FLUVIAL, 1000, false, true));
        assertFalse(peniche.peutPrendreEnCharge(ModeTransport.FLUVIAL, 2600000, false, false));
    }
}
