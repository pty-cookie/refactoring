package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DelaiFluvialTest {

    private final DelaiLivraison delai = new DelaiFluvial();

    @Test
    void trois_cent_soixante_km_par_jour_plus_un_jour() {
        assertEquals(2, delai.calculerJours(360, false));
        assertEquals(3, delai.calculerJours(365, false));
    }
}
