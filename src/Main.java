//el control
import dinamico.Pedido;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaLogistica sistema = new SistemaLogistica();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        sistema.registrarPedido(new Pedido(101, "Pollería El Gordo"));
        sistema.registrarPedido(new Pedido(102, "Chifa El Dragón"));

        System.out.println("BIENVENIDO AL SISTEMA DE DELIVERY");

        while (opcion != 6) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver pedidos pendientes ");
            System.out.println("2. Ingresar pedido express ");
            System.out.println("3. Actualizar estado de un pedido ");
            System.out.println("4. Cancelar un pedido ");
            System.out.println("5. Ver distancias de zonas ");
            System.out.println("6. Cerrar Turno y Salir");
            System.out.print(" Elige una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    sistema.mostrarPedidosPendientes();
                    break;
                case 2:
                    System.out.print("Ingresa el ID del nuevo pedido express: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Ingresa el nombre del restaurante: ");
                    String local = teclado.nextLine();
                    sistema.insertarPedidoExpress(0, new Pedido(id, local));
                    break;
                case 3:
                    System.out.print("ID del pedido a actualizar: ");
                    int idAct = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Nuevo estado (ej. 'En Camino'): ");
                    String estado = teclado.nextLine();
                    sistema.actualizarEstadoPedido(idAct, estado);
                    break;
                case 4:
                    System.out.print("ID del pedido que el cliente canceló: ");
                    int idCanc = teclado.nextInt();
                    sistema.cancerlarPedido(idCanc);
                    break;
                case 5:
                    sistema.mostrarMapaDistancias();
                    break;
                case 6:
                    System.out.println("Generando respaldo (Copia)...");
                    sistema.generarRespaldoRuta();
                    System.out.println("Cerrando sistema. ¡Buen descanso!");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intenta de nuevo.");
            }
        }
        teclado.close();
    }
}