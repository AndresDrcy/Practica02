package org.example;
import java.util.Scanner;

public class Gestión_de_Transacciones_Financieras{

//esto es una prueba
    public static void main(String[] args) {

        Login login = new Login(); // llamamos al login

        // Esperamos hasta que el login sea exitoso
        while (!login.esAutenticado()) { //la variable en login debe cambiar a true
            // Continuar mostrando la ventana de login hasta que el usuario se autentique
            try {
                Thread.sleep(500); // Esperamos un poco antes de volver a revisar el estado
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }

        // Si la autenticación es correcta, pasamos al menú
        System.out.println("Login exitoso. Iniciando el sistema...");

        //Creamos una instancia de la gestion de transaccion
        gestionTransacciones gestion = new gestionTransacciones();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Realizar Ingreso");
            System.out.println("2. Realizar Egreso");
            System.out.println("3. Mostrar Transacciones");
            System.out.println("4. Eliminar Transacción");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); //limpiar pantalla
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el monto: ");
                        double montoIngreso = scanner.nextDouble();
                        scanner.nextLine(); //limpiar pantalla
                        System.out.print("Ingrese la descripción: ");
                        String descripcionIngreso = scanner.nextLine();
                        System.out.print("Ingrese la fecha: ");
                        String fechaIngreso = scanner.nextLine();
                        try {
                            Transaccion ingreso = new Ingreso(montoIngreso, descripcionIngreso, fechaIngreso);
                            gestion.realizarTransaccion(ingreso);
                            System.out.println("Ingreso realizado con éxito.");
                        } catch (ExcepcionTransaccion e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese el monto: ");
                        double montoEgreso = scanner.nextDouble();
                        scanner.nextLine(); //limpiar pantalla
                        System.out.print("Ingrese la descripción: ");
                        String descripcionEgreso = scanner.nextLine();
                        System.out.print("Ingrese la fecha: ");
                        String fechaEgreso = scanner.nextLine();
                        try {
                            Transaccion egreso = new Egreso(montoEgreso, descripcionEgreso, fechaEgreso);
                            gestion.realizarTransaccion(egreso);
                            System.out.println("Egreso realizado con éxito.");
                        } catch (ExcepcionTransaccion e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 3:
                        gestion.mostrarTransacciones();
                        break;

                    case 4:
                        gestion.mostrarTransacciones();
                        if (gestion.transaccionesVacias()) {
                            System.out.println("No hay transacciones para eliminar.");
                            break;
                        }

                        System.out.print("Ingrese el número de la transacción a eliminar: ");
                        int indiceEliminar = scanner.nextInt();
                        scanner.nextLine();

                        if (!gestion.eliminarTransaccion(indiceEliminar - 1)) {
                            System.out.println("No se pudo eliminar la transacción.");
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;


                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 5);

            scanner.close();

    }
}






