package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplementFragileTest {

    private static final double PRECISION = 0.001;
    private static final ComposantPrix MILLE_EUROS = demande -> 1000;

    static DemandeTarif demande(TypeMarchandise type, boolean urgent) {
        return new DemandeTarif(List.of(new Colis("Colis", 100, 50, 40, 30, type, 500)), 465, ModeTransport.ROUTE,
                urgent, false, TypeClient.PARTICULIER);
    }

    private final ComposantPrix prix = new SupplementFragile(MILLE_EUROS);

    @Test
    void majore_le_prix_quand_l_expedition_est_concernee() {
        assertEquals(1150, prix.calculer(demande(TypeMarchandise.FRAGILE, false)), PRECISION);
    }

    @Test
    void ne_change_rien_sinon() {
        assertEquals(1000, prix.calculer(demande(TypeMarchandise.STANDARD, false)), PRECISION);
    }
}
