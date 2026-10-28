package fr.efrei.transfret;

public enum TypeClient {
    //          remise                  SIRET  SMS
    PARTICULIER(new SansRemise(),       false, false),
    ENTREPRISE(new RemiseEntreprise(),  true,  false),
    PREMIUM(new RemisePremium(),        false, true);

    private final PolitiqueRemise politiqueRemise;
    private final boolean exigeSiret;
    private final boolean notifieParSms;

    TypeClient(PolitiqueRemise politiqueRemise, boolean exigeSiret, boolean notifieParSms) {
        this.politiqueRemise = politiqueRemise;
        this.exigeSiret = exigeSiret;
        this.notifieParSms = notifieParSms;
    }

    public PolitiqueRemise getPolitiqueRemise() {
        return politiqueRemise;
    }

    public boolean exigeSiret() {
        return exigeSiret;
    }

    public boolean estNotifieParSms() {
        return notifieParSms;
    }
}
