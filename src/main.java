//el control

public class main {
    public static void main(String[] args) {
        SistemaLogistica sistema = new SistemaLogistica();
        System.out.println("inciciar turno");

        Pedido pedido1 = new Pedido(101, "polleria el gordo");
        Pedido pedido2 = new Pedido(102, "chifa el dragon");
        Pedido pedido3 = new Pedido(103, "burger king");

        sistema.registrarPedido(pedido1);
        sistema.registrarPedido(pedido2);
        sistema.registrarPedido(pedido3);
        System.out.println("estado inicial");

        sistema.mostrarPedidosPendientes();

        System.out.println("ACTUALIXADOP  EN TIEMPO REAL");

        sistema.actualizarEstadoPedido(101, "en camino");
        sistema.actualizarEstadoPedido(102, "entregado");
        sistema.actualizarEstadoPedido(103, "en camino");
        System.out.println("estado final");
        sistema.mostrarPedidosPendientes();

        System.out.println("cancelado un pedido");
        sistema.cancerlarPedido(103);
        System.out.println("estado despues de la cancelacion ");
        sistema.mostrarPedidosPendientes();

        System.out.println("generar respaldo del cierre turno");
        Pedido[] rutaRespaldo = sistema.generarRespaldoRuta();
        System.out.println("estructura clonada");
        for (int i = 0; i < rutaRespaldo.length; i++) {
            if (rutaRespaldo[i] != null) {
                System.out.println("respaldo" + rutaRespaldo[i].toString());
            }
        }
        System.out.println("f");

        System.out.println("alerta ingreso pedido");
        Pedido pedidoUrgente = new Pedido(999, "kfc");
        sistema.insertarPedidoExpress(0, pedidoUrgente);
        System.out.println("rutear con pedido");
        sistema.mostrarPedidosPendientes();

        //fusiom para no equivarcme
        System.out.println("fusionando");
        Pedido[] rutaRepartidorA = {
                new Pedido(201, "PIZZA"),
                new Pedido(202, "hamborgueas")
        };
        Pedido[] rutaRepartidorB = {
                new Pedido(301, "PAN"),
                new Pedido(302, "CHICHARRON")
        };
        Pedido[] rutaMaestra = sistema.fusionarRutas(rutaRepartidorA, rutaRepartidorB);
        System.out.println("ruta fusion");
        for (int i = 1; i < rutaMaestra.length; i++) {
            if (rutaMaestra[i] != null) {
                System.out.println(rutaMaestra[i].toString());
            }
        }

        System.out.println("compaacion y clonacion ");
        Pedido[] rutaOriginal = {
                new Pedido(401, "bombos"),
                new Pedido(402, "papa jonsh")
        };
        Pedido[] rutaClonada = sistema.clonarRutaEspecial(rutaOriginal);
        System.out.println("comparando ruta original");
        sistema.compararRutas(rutaOriginal, rutaClonada);

        Pedido[] rutaDiferente = {
                new Pedido(999, "restaurante"),
                new Pedido(123, "papajons")

        };

        System.out.println("comparacion ruta original con ruda diferente ");
        sistema.compararRutas(rutaOriginal, rutaDiferente);

        sistema.mostrarMapaDistancias();


    }

}