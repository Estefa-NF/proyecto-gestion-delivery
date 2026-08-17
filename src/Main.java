



public class SistemaLogistica {

    private Pedido[] listaPedidos;
    private int cantidadActual;

    public SistemaLogistica() {

        this.listaPedidos = new Pedido[50];
        this.cantidadActual = 0;
    }

    public void registrarPedido(Pedido nuevoPedido) {
        if (cantidadActual < listaPedidos.length) {
            listaPedidos[cantidadActual] = nuevoPedido;
            cantidadActual++;
            System.out.println("Pedido registrado con éxito.");
        } else {
            System.out.println("El arreglo está lleno. No se pueden recibir más pedidos.");
        }
    }
}