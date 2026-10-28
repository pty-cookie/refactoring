package fr.efrei.transfret;

public class ServiceClient {

    private ClientRepository clients;
    private ValidateurClient validateur = new ValidateurClient();

    public ServiceClient(ClientRepository clients) {
        this.clients = clients;
    }

    public Client creerClient(String nom, String email, String telephone, String adresse, TypeClient type, String siret) {
        if (!validateur.estValide(nom, email, type, siret)) {
            return null;
        }
        Client c = new Client(nom, email, telephone, adresse, type, siret);
        clients.sauvegarderClient(c);
        EmailService.envoyer(c.getEmail(), "Bienvenue chez TransFret", "Bonjour " + c.getNom() + ", votre compte " + c.getType().name().toLowerCase() + " a été créé.");
        return c;
    }
}
