



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
            System.out.println("Exito" + nuevoPedido.toString() + "registro sistema");
        } else {
            System.out.println("El arreglo está lleno. No se pueden recibir más pedidos.");
        }
    }

    public void mostrarPedidosPendientes() {
        System.out.println("Lista pedidos");
        for (int i = 0; i < cantidadActual; i++) {

            if (listaPedidos[i] != null) {
                System.out.println(listaPedidos[i].toString());
            }
        }
    }


    public void actualizarEstadoPedido(int idBuscado, String nuevoEstado) {
        boolean encontrado = false;
        for (int i = 0; i < cantidadActual; i++) {
            if (listaPedidos[i] != null && listaPedidos[i].getIdPedido() == idBuscado) {
                listaPedidos[i].setEstado(nuevoEstado);
                System.out.println("estado actualizado" + idBuscado + "ahora esta" + nuevoEstado + ".");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("error de pedido" + idBuscado + "en el sistema");
        }
    }
}
