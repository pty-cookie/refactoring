package fr.efrei.transfret;

public class Notificateur {

    private CanalEmail email;
    private CanalSms sms;

    public Notificateur(CanalEmail email, CanalSms sms) {
        this.email = email;
        this.sms = sms;
    }

    public void notifier(Client client, String sujet, String corps, String sms) {
        email.envoyer(client.getEmail(), sujet, corps);
        if (client.getType() == TypeClient.PREMIUM) {
            this.sms.envoyerSms(client.getTelephone(), sms);
        }
    }
}
