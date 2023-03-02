package dvidmontoyaexamen1;

import java.util.Scanner;

public class DvidMontoyaExamen1 {

    static final int MAX_VENTAS = 10; // Máximo número de ventas
    static int[] localidadesCantidad = new int[3]; // Cantidad de entradas vendidas por localidad
    static int[] localidadesAcumulado = new int[3]; // Acumulado de dinero por localidad
    static byte numVentas = 0; // Número actual de ventas
    static int[][] ventas = new int[MAX_VENTAS][10]; // Información de cada venta
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }
    

    
    public static void menu(){
    byte opcion;
        do {
            opcion = 0;
            System.out.println("1-Ingrese su Compra");
            System.out.println("2-Inicializar vectores");
            System.out.println("3-Estadisticas");
            System.out.println("4-Salir");
           System.out.println("Digite una opcion");
            opcion = scanner.nextByte();
            switch (opcion) {
                case 1 : ingresarVenta();
                    break;
                case 2: inicializarArreglos();
                    break;
                case 3: mostrarEstadisticas();
                    break;
                
                    
               
                
                default:
                    throw new AssertionError();
            }
        } while (opcion != 4);
    
    
    }
    
    
    
    
    
    
     public static void ingresarVenta() {
        if (numVentas == MAX_VENTAS) {
            System.out.println("No se pueden ingresar más ventas");
            return;
        }
        System.out.println("Ingrese número de factura:");
        ventas[numVentas][0] = scanner.nextInt();
        System.out.println("Ingrese cédula del comprador:");
        ventas[numVentas][1] = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea
        System.out.println("Ingrese nombre del comprador:");
        ventas[numVentas][2] = scanner.next().charAt(0);
        System.out.println("Ingrese localidad (1. Sol Norte/Sur, 2. Sombra Este/Oeste, 3. Preferencial):");
        int localidad = scanner.nextInt() - 1;
        if (localidad < 0 || localidad > 2) {
            System.out.println("Localidad inválida");
            return;
        }
        ventas[numVentas][3] = localidad;
        System.out.println("Ingrese cantidad de entradas:");
        int cantidad = scanner.nextInt();
        if (cantidad < 1 || cantidad > 4) {
            System.out.println("Cantidad inválida");
            return;
        }
        ventas[numVentas][4] = cantidad;
        int precio;
        String nombreLocalidad;
        switch (localidad) {
            case 0:
                precio = 10500;
                nombreLocalidad = "Sol Norte/Sur";
                break;
            case 1:
                precio = 20500;
                nombreLocalidad = "Sombra Este/Oeste";
                break;
            case 2:
                precio = 25500;
                nombreLocalidad = "Preferencial";
                break;
            default:
                precio = 0; 
                nombreLocalidad = "";
        }
        int subtotal = cantidad * precio;
        int cargosServicios = cantidad * 1000;
        int total = subtotal + cargosServicios;
        ventas[numVentas][5] = subtotal;
        ventas[numVentas][6] = cargosServicios;
        ventas[numVentas][7] = total;
        ventas[numVentas][8] = precio;
        ventas[numVentas][9] = localidad;
        numVentas++;
        System.out.println("Venta registrada con éxito");
    }


public static void inicializarArreglos() {
        for (int i = 0; i < MAX_VENTAS; i++) {
            ventas[i][0] = 0; // Número de factura
            ventas[i][1] = 0; // Cédula del comprador
            ventas[i][2] = 0; // Nombre del comprador
            ventas[i][3] = -1; // Localidad (-1 indica que no se ha vendido nada)
            ventas[i][4] = 0; // Cantidad de entradas
            ventas[i][5] = 0; // Subtotal
        }

        for (int i = 0; i < 3; i++) {
            
        }
    }




public static void mostrarEstadisticas() {
    int totalEntradas = 0;
    int totalVentas = 0;
    int[] entradasPorLocalidad = new int[3];
    int[] ventasPorLocalidad = new int[3];
    int[] ingresosPorLocalidad = new int[3];

    for (int i = 0; i < numVentas; i++) {
        int localidad = ventas[i][3];
        int cantidad = ventas[i][4];
        int subtotal = ventas[i][5];
        totalEntradas += cantidad;
        totalVentas += subtotal;

        entradasPorLocalidad[localidad] += cantidad;
        ventasPorLocalidad[localidad]++;
        ingresosPorLocalidad[localidad] += subtotal;
    }

    System.out.println("=== ESTADÍSTICAS ===");
    System.out.println("Total de entradas vendidas: " + totalEntradas);
    System.out.println("Total de ventas: " + totalVentas);

    System.out.println("Entradas vendidas por localidad:");
    System.out.println("Sol Norte/Sur: " + entradasPorLocalidad[0]);
    System.out.println("Sombra Este/Oeste: " + entradasPorLocalidad[1]);
    System.out.println("Preferencial: " + entradasPorLocalidad[2]);

    System.out.println("Ventas por localidad:");
    System.out.println("Sol Norte/Sur: " + ventasPorLocalidad[0]);
    System.out.println("Sombra Este/Oeste: " + ventasPorLocalidad[1]);
    System.out.println("Preferencial: " + ventasPorLocalidad[2]);

    System.out.println("Ingresos por localidad:");
    System.out.println("Sol Norte/Sur: " + ingresosPorLocalidad[0]);
    System.out.println("Sombra Este/Oeste: " + ingresosPorLocalidad[1]);
    System.out.println("Preferencial: " + ingresosPorLocalidad[2]);
}


}

