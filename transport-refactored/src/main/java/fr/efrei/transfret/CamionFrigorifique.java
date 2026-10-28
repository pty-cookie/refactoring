package fr.efrei.transfret;

import java.util.Optional;

public class CamionFrigorifique extends Camion implements Refrigerant {

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
    public Optional<Refrigerant> refrigeration() {
        return Optional.of(this);
    }

    @Override
    public void activerRefrigeration(double temperature) {
        System.out.println("Réfrigération activée à " + temperature + "°C sur " + immatriculation);
    }
}
