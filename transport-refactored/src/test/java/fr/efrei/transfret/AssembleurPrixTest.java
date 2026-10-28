package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssembleurPrixTest {

    @Test
    void remise_apres_supplements_et_urgence_puis_assurance() {
        // tarif route : 465 km x 1,20 + 1 000 kg x 0,10 = 658 € ; x1,30 dangereux ; x1,5 urgent = 1 283,10 €
        // remise entreprise 10 % = 1 154,79 € ; assurance 2 % de 20 000 € = 400 € -> 1 554,79 €
        DemandeTarif demande = new DemandeTarif(
                List.of(new Colis("Fûts", 1000, 100, 100, 100, TypeMarchandise.DANGEREUX, 20000)),
                465, ModeTransport.ROUTE, true, true, TypeClient.ENTREPRISE);
        assertEquals(1554.79, new AssembleurPrix().assembler().calculer(demande), 0.001);
    }
}
