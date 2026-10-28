package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DelaiAirTest {

    private final DelaiLivraison delai = new DelaiAir();

    @Test
    void un_jour_en_court_courrier() {
        assertEquals(1, delai.calculerJours(465, false));
    }

    @Test
    void deux_jours_au_dela_de_3000_km() {
        assertEquals(2, delai.calculerJours(5840, false));
    }

    @Test
    void un_jour_si_urgent() {
        assertEquals(1, delai.calculerJours(5840, true));
    }
}
