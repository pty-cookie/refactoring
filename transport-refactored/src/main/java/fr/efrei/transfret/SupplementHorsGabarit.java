package fr.efrei.transfret;

public class SupplementHorsGabarit extends SupplementMultiplicatif {

    private static final double COEFFICIENT = 1.10;
    private static final double DIMENSION_MAX_CM = 200;

    public SupplementHorsGabarit(ComposantPrix composant) {
        super(composant, COEFFICIENT);
    }

    @Override
    protected boolean concerne(DemandeTarif demande) {
        for (Colis c : demande.colis()) {
            if (c.getLongueur() > DIMENSION_MAX_CM || c.getLargeur() > DIMENSION_MAX_CM || c.getHauteur() > DIMENSION_MAX_CM) {
                return true;
            }
        }
        return false;
    }
}
