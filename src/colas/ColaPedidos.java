package colas;

import dinamico.NodoPedido;
import dinamico.Pedido;


public class ColaPedidos {
    private NodoPedido frente;
    private NodoPedido fin;
    public ColaPedidos() {
        this.frente = null;
        this.fin = null;
    }
    public boolean isEmpty() {
        return frente == null;
    }
    public void enqueue(Pedido nuevoPedido) {
        NodoPedido nuevoNodo = new NodoPedido(nuevoPedido);

        if (isEmpty()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {

            fin.setSiguiente(nuevoNodo);

            fin = nuevoNodo;
        }
        System.out.println(" Pedido #" + nuevoPedido.getIdPedido() + " ingresó al final de la cola de despacho.");
    }
    public Pedido dequeue() {
        if (isEmpty()) {
            System.out.println("❌ ERROR: La cola está vacía, no hay pedidos para despachar.");
            return null;
        }
        Pedido pedidoDespachado = frente.getPedidoActual();

        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        System.out.println("DEQUEUE: Pedido #" + pedidoDespachado.getIdPedido() + " despachado al motorizado.");
        return pedidoDespachado;
    }
    public void front() {
        if (isEmpty()) {
            System.out.println("FRONT: No hay pedidos en espera.");
        } else {
            System.out.println("FRONT: El próximo pedido a despachar es el " + frente.getPedidoActual().getIdPedido());
        }
    }
}