package dinamico;

public class MochilaReparto {
    private NodoPedido cima;
    public MochilaReparto() {
        this.cima = null;
    }
    public boolean isEmpty() {
        return cima == null;
    }
    public void push(Pedido nuevoPedido) {
        NodoPedido nuevaCaja = new NodoPedido(nuevoPedido);
        nuevaCaja.setSiguiente(cima);
        cima = nuevaCaja;
        System.out.println(" dinamico.Pedido " + nuevoPedido.getIdPedido() + " guardado arriba en la mochila.");
    }
    public Pedido pop() {
        if (isEmpty()) {
            System.out.println("ERROR: No hay nada que sacar, la mochila está vacía.");
            return null;
        }

        Pedido pedidoAEntregar = cima.getPedidoActual();
        cima = cima.getSiguiente();

        System.out.println(" POP: dinamico.Pedido " + pedidoAEntregar.getIdPedido() + " sacado para entregar al cliente.");
        return pedidoAEntregar;
    }
    public void top() {
        if (isEmpty()) {
            System.out.println("La mochila está vacía.");
        } else {
            System.out.println("El pedido que está más arriba es el " + cima.getPedidoActual().getIdPedido());
        }
    }
}