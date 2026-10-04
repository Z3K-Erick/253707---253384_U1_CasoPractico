import java.util.Scanner;

public class GestorFlotilla {
    private Vehiculo[] flotilla;
    private Scanner scanner;

    public GestorFlotilla() {
        // arreglo de objetos
        flotilla = new Vehiculo[5];
        scanner = new Scanner(System.in);
        
        flotilla[0] = new Vehiculo("ABC-101", 15000);
        flotilla[1] = new Vehiculo("DEF-202", 23500);
        flotilla[2] = new Vehiculo("GHI-303", 5000);
        flotilla[3] = new Vehiculo("JKL-404", 42100);
        flotilla[4] = new Vehiculo("MNO-505", 1200);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE FLOTILLA ---");
            System.out.println("1. Consultar unidades disponibles");
            System.out.println("2. Asignar chofer a una unidad");
            System.out.println("3. Ver todas las unidades (Estado general)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    consultarDisponibles();
                    break;
                case 2:
                    asignarChofer();
                    break;
                case 3:
                    mostrarInventario();
                    break;
                case 4:
                    System.out.println("Cerrando sistema de gestión...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private void consultarDisponibles() {
        System.out.println("\n--- FILTRO: VEHÍCULOS DISPONIBLES ---");
        boolean hayDisponibles = false;
        for (Vehiculo v : flotilla) {
            if (v.getEstatus().equals("disponible")) {
                System.out.println(v.toString());
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay vehículos disponibles en este momento.");
        }
    }

    private void asignarChofer() {
        System.out.print("\nIngrese la placa del vehículo al que desea asignar un chofer: ");
        String placaBuscada = scanner.nextLine();
        boolean encontrado = false;
        
        for (Vehiculo v : flotilla) {
            if (v.getPlaca().equalsIgnoreCase(placaBuscada)) {
                encontrado = true;
                if (v.getEstatus().equals("ocupado")) {
                    System.out.println("Error: El vehículo con placa " + placaBuscada + " ya está ocupado.");
                } else {
                    System.out.print("Ingrese nombre completo del chofer: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese número de licencia: ");
                    String licencia = scanner.nextLine();
                    
                    Chofer nuevoChofer = new Chofer(nombre, licencia);
                    v.asignarChofer(nuevoChofer);
                    System.out.println("¡Éxito! Chofer asignado. El estatus del vehículo cambió a 'ocupado'.");
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Vehículo no encontrado en la base de datos.");
        }
    }

    private void mostrarInventario() {
        System.out.println("\n--- INVENTARIO TOTAL DE LA FLOTILLA ---");
        for (Vehiculo v : flotilla) {
            System.out.println(v.toString());
        }
    }
}
