package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DelaiRailTest {

    private final DelaiLivraison delai = new DelaiRail();

    @Test
    void mille_quatre_cent_quarante_km_par_jour_plus_un_jour() {
        assertEquals(2, delai.calculerJours(465, false));
        assertEquals(3, delai.calculerJours(1500, false));
    }

    @Test
    void un_jour_de_moins_si_urgent() {
        assertEquals(1, delai.calculerJours(465, true));
    }
}
