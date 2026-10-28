package fr.efrei.transfret;

/**
 * Assemble la chaîne de calcul du prix HT. L'ordre compte : la remise s'applique au prix après
 * suppléments et urgence, et l'assurance s'ajoute après la remise.
 */
public class AssembleurPrix {

    public ComposantPrix assembler() {
        ComposantPrix prix = new TarifDeBase();
        prix = new SupplementFragile(prix);
        prix = new SupplementDangereux(prix);
        prix = new SupplementRefrigere(prix);
        prix = new SupplementUrgence(prix);
        prix = new RemiseClient(prix);
        prix = new Assurance(prix);
        return prix;
    }
}
