package org.example;

public class Egreso extends Transaccion{

    //constructor para egresos
    public Egreso(double monto, String descripcion, String fecha) {
        super(monto, descripcion, fecha);
    }

    @Override
    public double calcularImpuesto() {
        //Un calculo al 5%
        return monto * 0.05;
    }

    @Override
    public double montoMasImpuesto() {
        //Calculo de monto mas impuesto
        return monto * 1.05;
    }

    //Procesar la transaccion de egreso
    @Override
    public void procesarTransaccion() {
        System.out.println("Procesando egreso de " + monto + " con la descripcion: " + descripcion + " con la fecha: " + fecha);
    }
}

