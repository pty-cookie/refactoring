package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplementHorsGabaritTest {

    private static final double PRECISION = 0.001;

    private final ComposantPrix prix = new SupplementHorsGabarit(demande -> 1000);

    static DemandeTarif demande(double longueur, double largeur, double hauteur) {
        return new DemandeTarif(List.of(new Colis("Colis", 100, longueur, largeur, hauteur, TypeMarchandise.STANDARD, 500)),
                465, ModeTransport.ROUTE, false, false, TypeClient.PARTICULIER);
    }

    @Test
    void dix_pourcent_si_un_colis_depasse_200_cm_sur_une_dimension() {
        assertEquals(1100, prix.calculer(demande(240, 120, 150)), PRECISION);
        assertEquals(1100, prix.calculer(demande(100, 201, 100)), PRECISION);
        assertEquals(1100, prix.calculer(demande(100, 100, 250)), PRECISION);
    }

    @Test
    void rien_jusqu_a_200_cm() {
        assertEquals(1000, prix.calculer(demande(200, 200, 200)), PRECISION);
    }
}
