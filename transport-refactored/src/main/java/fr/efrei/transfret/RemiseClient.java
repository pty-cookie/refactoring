package fr.efrei.transfret;

/**
 * Applique la politique de remise du type de client au prix obtenu après suppléments.
 */
public class RemiseClient extends DecorateurPrix {

    public RemiseClient(ComposantPrix composant) {
        super(composant);
    }

    @Override
    public double calculer(DemandeTarif demande) {
        return demande.typeClient().getPolitiqueRemise().appliquer(composant.calculer(demande));
    }
}
