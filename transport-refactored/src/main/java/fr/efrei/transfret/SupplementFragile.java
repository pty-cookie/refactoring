package fr.efrei.transfret;

public class SupplementFragile extends SupplementMultiplicatif {

    private static final double COEFFICIENT = 1.15;

    public SupplementFragile(ComposantPrix composant) {
        super(composant, COEFFICIENT);
    }

    @Override
    protected boolean concerne(DemandeTarif demande) {
        return demande.contient(TypeMarchandise.FRAGILE);
    }
}
