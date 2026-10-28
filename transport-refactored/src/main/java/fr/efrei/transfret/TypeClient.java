package fr.efrei.transfret;

public enum TypeClient {
    PARTICULIER(new SansRemise()),
    ENTREPRISE(new RemiseEntreprise()),
    PREMIUM(new RemisePremium());

    private final PolitiqueRemise politiqueRemise;

    TypeClient(PolitiqueRemise politiqueRemise) {
        this.politiqueRemise = politiqueRemise;
    }

    public PolitiqueRemise getPolitiqueRemise() {
        return politiqueRemise;
    }
}
