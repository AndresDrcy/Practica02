package org.example;
import java.util.ArrayList;

public class gestionTransacciones {
    //Declaramos el Array
    private ArrayList<Transaccion> transacciones = new ArrayList<>();
    private static final double capitalEmpresa = 1500;
    private double capitalActual = capitalEmpresa;

    //Agregamos una transaccion

    //throws si sale mal el metodo lanza la excepcion
    public void realizarTransaccion(Transaccion transaccion) throws ExcepcionTransaccion {
        if (transaccion instanceof Ingreso) {
            if (transaccion.monto < 0) {
                throw new ExcepcionTransaccion("El monto no puede ser negativo para un ingreso.");
            }
            capitalActual += transaccion.monto;
        } else if (transaccion instanceof Egreso) {
            if (transaccion.monto > capitalActual) {
                throw new ExcepcionTransaccion("El egreso excede el capital disponible.");
            }
            capitalActual -= transaccion.monto;
        }
        transaccion.procesarTransaccion();
        transacciones.add(transaccion);
    }

    //Mostramos todas las transacciones y sus impuestos
    public void mostrarTransacciones() {
        System.out.println("Lista de transacciones:");
        for (int i = 0; i < transacciones.size(); i++) {
            Transaccion t = transacciones.get(i);
            System.out.println((i + 1) + ". Descripción: " + t.getDescripcion() +
                    ", Monto: " + t.getMonto() +
                    ", Fecha: " + t.getFecha());
        }
        System.out.println("Capital Actual: " + capitalActual);
    }

    public boolean eliminarTransaccion(int indice) {
        if (indice < 0 || indice >= transacciones.size()) {
            System.out.println("Índice inválido. No se pudo eliminar la transacción.");
            return false;
        }

        Transaccion transaccion = transacciones.get(indice);

        // Revertimos el impacto de la transacción en el capital actual
        if (transaccion instanceof Ingreso) {
            capitalActual -= transaccion.getMonto();
        } else if (transaccion instanceof Egreso) {
            capitalActual += transaccion.getMonto();
        }

        transacciones.remove(indice);
        System.out.println("Transacción eliminada con éxito.");
        return true;
    }

    public boolean transaccionesVacias() {
        return transacciones.isEmpty();
    }

}



