package fr.efrei.transfret;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Parcours complet d'une expédition fluviale, à travers les vrais services.
 */
class ExtensionFluvialTest {

    private ServiceExpedition serviceExpedition;
    private Client client;

    @BeforeEach
    void construireLeGraphe() {
        Database database = new Database();
        EmailService email = new EmailService();
        serviceExpedition = new ServiceExpedition(database, new ValidateurExpedition(),
                new CalculateurPrix(new AssembleurPrix().assembler()), new AffectationVehicule(new Flotte()),
                new EstimateurDelai(), new Notificateur(email, new SmsService()));
        client = new ServiceClient(database, new ValidateurClient(), email)
                .creerClient("Jean Dupont", "jean.dupont@mail.fr", "0601020304", "Paris", TypeClient.PARTICULIER, null);
    }

    static List<Colis> colis(double poids, TypeMarchandise type) {
        List<Colis> colis = new ArrayList<>();
        colis.add(new Colis("Céréales", poids, 120, 100, 100, type, 1000));
        return colis;
    }

    @Test
    void paris_le_havre_par_peniche() {
        Expedition e = serviceExpedition.creerExpedition(client, colis(20000, TypeMarchandise.STANDARD),
                "Paris", "Le Havre", ModeTransport.FLUVIAL, false, false);
        assertEquals("PEN-0001", e.getVehicule().getImmatriculation());
        assertEquals(546.0, e.getPrixHT(), 0.001);
        assertEquals(3, ChronoUnit.DAYS.between(jour(e.getDateCreation()), jour(e.getDateLivraisonPrevue())));
        assertTrue(serviceExpedition.demarrerExpedition(e.getId()));
        assertTrue(serviceExpedition.livrerExpedition(e.getId()));
    }

    @Test
    void minimum_de_facturation() {
        Expedition e = serviceExpedition.creerExpedition(client, colis(1000, TypeMarchandise.STANDARD),
                "Paris", "Le Havre", ModeTransport.FLUVIAL, false, false);
        assertEquals(300.0, e.getPrixHT(), 0.001);
    }

    @Test
    void refrigere_interdit() {
        assertNull(serviceExpedition.creerExpedition(client, colis(1000, TypeMarchandise.REFRIGERE),
                "Paris", "Le Havre", ModeTransport.FLUVIAL, false, false));
    }

    @Test
    void pas_d_urgence() {
        assertNull(serviceExpedition.creerExpedition(client, colis(1000, TypeMarchandise.STANDARD),
                "Paris", "Le Havre", ModeTransport.FLUVIAL, true, false));
    }

    private static LocalDate jour(java.util.Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
