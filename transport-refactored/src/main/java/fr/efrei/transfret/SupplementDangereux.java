package fr.efrei.transfret;

public class SupplementDangereux extends SupplementMultiplicatif {

    private static final double COEFFICIENT = 1.30;

    public SupplementDangereux(ComposantPrix composant) {
        super(composant, COEFFICIENT);
    }

    @Override
    protected boolean concerne(DemandeTarif demande) {
        return demande.contient(TypeMarchandise.DANGEREUX);
    }
}
