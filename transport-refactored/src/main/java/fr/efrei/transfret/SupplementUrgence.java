package fr.efrei.transfret;

public class SupplementUrgence extends SupplementMultiplicatif {

    private static final double COEFFICIENT = 1.5;

    public SupplementUrgence(ComposantPrix composant) {
        super(composant, COEFFICIENT);
    }

    @Override
    protected boolean concerne(DemandeTarif demande) {
        return demande.urgent();
    }
}
