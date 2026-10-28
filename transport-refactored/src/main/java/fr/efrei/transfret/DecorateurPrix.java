package fr.efrei.transfret;

/**
 * Enveloppe un autre composant du prix et ajoute son propre calcul (patron Decorator).
 */
public abstract class DecorateurPrix implements ComposantPrix {

    protected final ComposantPrix composant;

    protected DecorateurPrix(ComposantPrix composant) {
        this.composant = composant;
    }
}
