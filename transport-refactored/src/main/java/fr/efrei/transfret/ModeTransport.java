package fr.efrei.transfret;

public enum ModeTransport {
    ROUTE(new TarifRoute(), new DelaiRoute()),
    RAIL(new TarifRail(), new DelaiRail()),
    MER(new TarifMer(), new DelaiMer()),
    AIR(new TarifAir(), new DelaiAir());

    private final TarifTransport tarif;
    private final DelaiLivraison delai;

    ModeTransport(TarifTransport tarif, DelaiLivraison delai) {
        this.tarif = tarif;
        this.delai = delai;
    }

    public TarifTransport getTarif() {
        return tarif;
    }

    public DelaiLivraison getDelai() {
        return delai;
    }
}
