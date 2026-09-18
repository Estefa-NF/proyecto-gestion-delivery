package colas;

import dinamico.NodoPedido;
import dinamico.Pedido;

public class MainCola {
    public static void main(String[] args) {
        System.out.println("DESPACHO (COLA / FIFO) ");
        //primer elemento que entra es el primero en salir

        ColaPedidos colaRestaurante = new ColaPedidos();

        Pedido p1 = new Pedido(1, "Pollo a la Brasa");
        Pedido p2 = new Pedido(2, "Salchipapa");
        Pedido p3 = new Pedido(3, "Gaseosa 1.5L");


        colaRestaurante.enqueue(p1);
        colaRestaurante.enqueue(p2);
        colaRestaurante.enqueue(p3);

        System.out.println(" ESTADO DE LA COCINA ");

        colaRestaurante.front();

        System.out.println("INICIANDO DESPACHOS ");

        colaRestaurante.dequeue();
        colaRestaurante.dequeue();

        colaRestaurante.front();

        colaRestaurante.dequeue();
    }
}