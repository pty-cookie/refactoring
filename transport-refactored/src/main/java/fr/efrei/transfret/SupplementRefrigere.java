package fr.efrei.transfret;

public class SupplementRefrigere extends SupplementMultiplicatif {

    private static final double COEFFICIENT = 1.20;

    public SupplementRefrigere(ComposantPrix composant) {
        super(composant, COEFFICIENT);
    }

    @Override
    protected boolean concerne(DemandeTarif demande) {
        return demande.contient(TypeMarchandise.REFRIGERE);
    }
}
