package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DelaiMerTest {

    @Test
    void sept_cent_vingt_km_par_jour_plus_deux_jours() {
        assertEquals(11, new DelaiMer().calculerJours(5850, false));
    }
}
