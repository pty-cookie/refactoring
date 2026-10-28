package fr.efrei.transfret;

/**
 * Remise accordée selon le type de client (patron Strategy).
 */
public interface PolitiqueRemise {

    double appliquer(double prix);
}
