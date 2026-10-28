package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DelaiRouteTest {

    private final DelaiLivraison delai = new DelaiRoute();

    @Test
    void neuf_heures_de_conduite_par_jour_a_70_km_h() {
        assertEquals(1, delai.calculerJours(465, false));
        assertEquals(3, delai.calculerJours(1400, false));
    }

    @Test
    void dix_huit_heures_de_conduite_par_jour_si_urgent() {
        assertEquals(2, delai.calculerJours(1400, true));
    }
}
