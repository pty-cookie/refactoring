package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemiseClientTest {

    private static final double PRECISION = 0.001;

    private final ComposantPrix prix = new RemiseClient(demande -> 1000);

    static DemandeTarif demande(TypeClient typeClient) {
        return new DemandeTarif(List.of(new Colis("Colis", 100, 50, 40, 30, TypeMarchandise.STANDARD, 500)), 465,
                ModeTransport.ROUTE, false, false, typeClient);
    }

    @Test
    void applique_la_politique_de_remise_du_client() {
        assertEquals(1000, prix.calculer(demande(TypeClient.PARTICULIER)), PRECISION);
        assertEquals(900, prix.calculer(demande(TypeClient.ENTREPRISE)), PRECISION);
        assertEquals(800, prix.calculer(demande(TypeClient.PREMIUM)), PRECISION);
    }
}
