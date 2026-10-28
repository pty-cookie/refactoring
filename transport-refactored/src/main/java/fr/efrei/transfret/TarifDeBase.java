package fr.efrei.transfret;

public class TarifDeBase implements ComposantPrix {

    @Override
    public double calculer(DemandeTarif demande) {
        return demande.mode().getTarif().calculer(demande.distance(), demande.poidsTotal(), demande.volumeTotal());
    }
}
