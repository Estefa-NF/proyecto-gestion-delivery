package dinamico;

public class NodoPedido {
    private Pedido pedidoActual;
    private NodoPedido siguiente;

    public NodoPedido(Pedido pedido){
        this.pedidoActual=pedido;
        this.siguiente= null;
    }
    public Pedido getPedidoActual() {
        return pedidoActual;
    }
    public NodoPedido getSiguiente(){
        return siguiente;

    }
    public void setSiguiente(NodoPedido siguiente){
        this.siguiente =siguiente;
    }
}
