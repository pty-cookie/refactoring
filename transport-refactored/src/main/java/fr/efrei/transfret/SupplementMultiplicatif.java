package fr.efrei.transfret;

/**
 * Supplément qui multiplie le prix par un coefficient lorsque l'expédition est concernée.
 */
public abstract class SupplementMultiplicatif extends DecorateurPrix {

    private final double coefficient;

    protected SupplementMultiplicatif(ComposantPrix composant, double coefficient) {
        super(composant);
        this.coefficient = coefficient;
    }

    protected abstract boolean concerne(DemandeTarif demande);

    @Override
    public double calculer(DemandeTarif demande) {
        double prix = composant.calculer(demande);
        if (concerne(demande)) prix = prix * coefficient;
        return prix;
    }
}
