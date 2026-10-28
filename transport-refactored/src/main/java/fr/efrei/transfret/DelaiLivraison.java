package fr.efrei.transfret;

/**
 * Délai de livraison d'un mode de transport, en jours (patron Strategy).
 */
public interface DelaiLivraison {

    int calculerJours(int distance, boolean urgent);
}
