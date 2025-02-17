package org.example;

public class Ingreso extends Transaccion{

    //constructor para ingresos
    public Ingreso(double monto, String descripcion, String fecha) {
        super(monto, descripcion, fecha);
    }

    //Calculo de impuestos
    @Override
    public double calcularImpuesto() {
        //Un calculo al 13%
        return monto * 0.13;
    }

    @Override
    public double montoMasImpuesto() {
        //Calculo de monto mas impuesto
        return monto * 1.13;
    }

    //Procesar la transaccion de ingreso
    @Override
    public void procesarTransaccion() {
        System.out.println("Procesando ingreso de "+ monto + " con la descripcion: " + descripcion + " con la fecha: " + fecha);
    }


}
