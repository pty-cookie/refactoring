package fr.efrei.transfret;

public class CamionFrigorifique extends Camion {

    public CamionFrigorifique(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, false);
    }

    @Override
    protected boolean accepte(boolean dangereux, boolean refrigere) {
        return refrigere;
    }

    // un camion frigo ne prend QUE des colis réfrigérés
    @Override
    protected boolean accepteMarchandise(TypeMarchandise type) {
        return type == TypeMarchandise.REFRIGERE;
    }

    @Override
    protected String messageMarchandiseRefusee() {
        return "Un camion frigorifique ne transporte que des produits réfrigérés";
    }

    @Override
    public void activerRefrigeration(double temperature) {
        System.out.println("Réfrigération activée à " + temperature + "°C sur " + immatriculation);
    }
}
