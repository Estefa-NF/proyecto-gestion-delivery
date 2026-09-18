package listas;

import dinamico.NodoPedido;
import dinamico.Pedido;
public class RutaReparto {
    private NodoPedido head;
    public RutaReparto() {
        this.head = null;
    }
    public void insertarInicio(Pedido nuevoPedido) {
        NodoPedido nuevoNodo = new NodoPedido(nuevoPedido);
        nuevoNodo.setSiguiente(head);
        head = nuevoNodo;
        System.out.println(" URGENTE: Pedido #" + nuevoPedido.getIdPedido() + " insertado al inicio de la ruta.");
    }
    public void insertarFinal(Pedido nuevoPedido) {
        NodoPedido nuevoNodo = new NodoPedido(nuevoPedido);

        if (head == null) {
            head = nuevoNodo;
        } else {
            NodoPedido actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        System.out.println(" RUTA: Pedido #" + nuevoPedido.getIdPedido() + " agregado al final del recorrido.");
    }

    public void eliminarPorId(int idBuscado) {
        NodoPedido actual = head;
        NodoPedido anterior = null;

        while (actual != null) {
            if (actual.getPedidoActual().getIdPedido() == idBuscado) {
                if (anterior == null) {

                    head = actual.getSiguiente();
                } else {

                    anterior.setSiguiente(actual.getSiguiente());
                }
                System.out.println("❌ CANCELADO: Pedido #" + idBuscado + " eliminado de la ruta.");
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        System.out.println("ERROR: El pedido #" + idBuscado + " no se encontró en la ruta.");
    }
    public void mostrarRuta() {
        System.out.print(" MAPA DE RUTA: [Head] -> ");
        NodoPedido actual = head;
        while (actual != null) {
            System.out.print("(" + actual.getPedidoActual().getNombreRestaurante() + ") -> ");
            actual = actual.getSiguiente();
        }

        System.out.println("null");
    }
}