package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssuranceTest {

    private static final double PRECISION = 0.001;

    private final ComposantPrix prix = new Assurance(demande -> 1000);

    static DemandeTarif demande(double valeurDeclaree, boolean assurance) {
        return new DemandeTarif(List.of(new Colis("Colis", 100, 50, 40, 30, TypeMarchandise.STANDARD, valeurDeclaree)),
                465, ModeTransport.ROUTE, false, assurance, TypeClient.PARTICULIER);
    }

    @Test
    void ajoute_deux_pourcent_de_la_valeur_declaree() {
        assertEquals(1000 + 20000 * 0.02, prix.calculer(demande(20000, true)), PRECISION);
    }

    @Test
    void minimum_de_15_euros() {
        assertEquals(1015, prix.calculer(demande(100, true)), PRECISION);
    }

    @Test
    void ne_change_rien_sans_assurance() {
        assertEquals(1000, prix.calculer(demande(20000, false)), PRECISION);
    }
}
