package listas;

import dinamico.Pedido;

public class MainRuta {
    public static void main(String[] args) {
        System.out.println("LISTA ENLAZADA SIMPLE ");

        RutaReparto ruta = new RutaReparto();

        Pedido p1 = new Pedido(10, "Burger King");
        Pedido p2 = new Pedido(20, "KFC");
        Pedido p3 = new Pedido(30, "Starbucks (VIP)");

        ruta.insertarFinal(p1);
        ruta.insertarFinal(p2);

        ruta.mostrarRuta();

        System.out.println("ALERTA: NUEVO PEDIDO PRIORITARIO");
        ruta.insertarInicio(p3);
        ruta.mostrarRuta();

        System.out.println("ALERTA: CANCELACIÓN DE CLIENTE");
        ruta.eliminarPorId(10);
        ruta.mostrarRuta();
    }
}