package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifDeBaseTest {

    @Test
    void delegue_au_tarif_du_mode_avec_le_poids_et_le_volume_totaux() {
        List<Colis> colis = List.of(
                new Colis("A", 60, 100, 100, 100, TypeMarchandise.STANDARD, 0),
                new Colis("B", 40, 100, 100, 100, TypeMarchandise.STANDARD, 0));
        DemandeTarif demande = new DemandeTarif(colis, 5840, ModeTransport.AIR, false, false, TypeClient.PARTICULIER);
        assertEquals(new TarifAir().calculer(5840, 100, 2), new TarifDeBase().calculer(demande), 0.001);
    }
}
