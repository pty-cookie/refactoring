package fr.efrei.transfret;

import java.util.List;

public class ValidateurExpedition {

    public boolean estValide(Client client, List<Colis> colis, ModeTransport mode, boolean urgent) {
        if (client == null) {
            System.out.println("ERREUR : client obligatoire");
            return false;
        }
        if (colis == null || colis.isEmpty()) {
            System.out.println("ERREUR : au moins un colis est nécessaire");
            return false;
        }
        for (Colis c : colis) {
            if (c.getPoids() <= 0) {
                System.out.println("ERREUR : poids invalide pour " + c.getDescription());
                return false;
            }
        }
        boolean dangereux = Colis.auMoinsUn(colis, TypeMarchandise.DANGEREUX);
        boolean refrigere = Colis.auMoinsUn(colis, TypeMarchandise.REFRIGERE);
        if (dangereux && !mode.accepteMatieresDangereuses()) {
            System.out.println("ERREUR : les matières dangereuses sont interdites en transport aérien");
            return false;
        }
        if (refrigere && !mode.accepteRefrigere()) {
            System.out.println("ERREUR : le transport réfrigéré n'est possible que par route ou par mer");
            return false;
        }
        if (urgent && !mode.accepteUrgence()) {
            System.out.println("ERREUR : pas d'option urgente pour le transport maritime");
            return false;
        }
        return true;
    }
}
