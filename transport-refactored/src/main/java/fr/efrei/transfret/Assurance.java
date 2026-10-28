package fr.efrei.transfret;

public class Assurance extends DecorateurPrix {

    private static final double TAUX = 0.02;
    private static final double MINIMUM = 15;

    public Assurance(ComposantPrix composant) {
        super(composant);
    }

    @Override
    public double calculer(DemandeTarif demande) {
        double prix = composant.calculer(demande);
        if (demande.assurance()) {
            double montantAssurance = demande.valeurTotale() * TAUX;
            if (montantAssurance < MINIMUM) montantAssurance = MINIMUM;
            prix = prix + montantAssurance;
        }
        return prix;
    }
}
