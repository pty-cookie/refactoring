package fr.efrei.transfret;

public enum ModeTransport {
    //    tarif             délai             dangereux  réfrigéré  urgence
    ROUTE(new TarifRoute(), new DelaiRoute(), true,      true,      true),
    RAIL(new TarifRail(),   new DelaiRail(),  true,      false,     true),
    MER(new TarifMer(),     new DelaiMer(),   true,      true,      false),
    AIR(new TarifAir(),     new DelaiAir(),   false,     false,     true),
    FLUVIAL(new TarifFluvial(), new DelaiFluvial(), true,  false,     false);

    private final TarifTransport tarif;
    private final DelaiLivraison delai;
    private final boolean accepteMatieresDangereuses;
    private final boolean accepteRefrigere;
    private final boolean accepteUrgence;

    ModeTransport(TarifTransport tarif, DelaiLivraison delai, boolean accepteMatieresDangereuses,
                  boolean accepteRefrigere, boolean accepteUrgence) {
        this.tarif = tarif;
        this.delai = delai;
        this.accepteMatieresDangereuses = accepteMatieresDangereuses;
        this.accepteRefrigere = accepteRefrigere;
        this.accepteUrgence = accepteUrgence;
    }

    public TarifTransport getTarif() {
        return tarif;
    }

    public DelaiLivraison getDelai() {
        return delai;
    }

    public boolean accepteMatieresDangereuses() {
        return accepteMatieresDangereuses;
    }

    public boolean accepteRefrigere() {
        return accepteRefrigere;
    }

    public boolean accepteUrgence() {
        return accepteUrgence;
    }
}
