package fr.efrei.transfret;

/**
 * Élément de la chaîne de calcul du prix HT : le tarif de base ou un décorateur qui l'enveloppe.
 */
public interface ComposantPrix {

    double calculer(DemandeTarif demande);
}
