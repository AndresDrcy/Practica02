package org.example;

public abstract class Transaccion {

    //Variables
    protected double monto;
    protected String descripcion;
    protected String fecha;

    //constructor de transaccion
    public Transaccion(double monto, String descripcion, String fecha){
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    //metodos abstractos
    public abstract double calcularImpuesto ();
    public abstract void procesarTransaccion();
    public abstract double montoMasImpuesto ();

    //gets y sets
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
