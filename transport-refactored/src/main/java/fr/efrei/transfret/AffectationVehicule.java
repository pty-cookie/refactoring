package fr.efrei.transfret;

import java.util.List;

public class AffectationVehicule {

    private Flotte flotte;

    public AffectationVehicule(Flotte flotte) {
        this.flotte = flotte;
    }

    // retourne le premier véhicule disponible et compatible, null si aucun
    public Vehicule trouverVehicule(List<Colis> colis, ModeTransport mode) {
        double poids = 0;
        for (Colis c : colis) {
            poids = poids + c.getPoids();
        }
        boolean dangereux = Colis.auMoinsUn(colis, TypeMarchandise.DANGEREUX);
        boolean refrigere = Colis.auMoinsUn(colis, TypeMarchandise.REFRIGERE);
        for (Vehicule v : flotte.getVehicules()) {
            if (v.peutPrendreEnCharge(mode, poids, dangereux, refrigere)) {
                return v;
            }
        }
        return null;
    }
}
