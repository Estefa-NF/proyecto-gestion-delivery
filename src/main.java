public class main {
    public static void main(String[] args){
        SistemaLogistica sistema = new SistemaLogistica();
        System.out.println("inciciar turno");

        Pedido pedido1 =new Pedido (101,"polleria el gordo");
        Pedido pedido2 = new Pedido(102, "chifa el dragon");
        Pedido pedido3 = new Pedido(103, "burger king");

        sistema.registrarPedido(pedido1);
        sistema.registrarPedido(pedido2);
        sistema.registrarPedido(pedido3);
        System.out.println("estado inicial");

        sistema.mostrarPedidosPendientes();

        System.out.println("ACTUALIXADOP  EN TIEMPO REAL");

        sistema.actualizarEstadoPedido(101,"en camino");
        sistema.actualizarEstadoPedido(102,"entregado");
        sistema.actualizarEstadoPedido(103,"en camino");
        System.out.println("estado final");
        sistema.mostrarPedidosPendientes();
    }
}
