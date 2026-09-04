

// el cerebro

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
            System.out.println("El arreglo está lleno. No hay pedidos");
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

    public void cancerlarPedido (int idBuscando) {
        boolean encontrado = false;
        int indiceAEliminar = -1;

        for (int i = 0; i < cantidadActual; i++) {
            if (listaPedidos[i] != null && listaPedidos[i].getIdPedido() == idBuscando) {
                indiceAEliminar = i;
                encontrado = true;
                break;
            }

        }
        if (encontrado) {
            for (int i = indiceAEliminar; i < cantidadActual - 1; i++) {
                listaPedidos[i] = listaPedidos[i + 1];
            }
                listaPedidos[cantidadActual - 1] = null;
                cantidadActual--;
                System.out.println("pedido cancelado" + idBuscando + "fue eliminado ");

            } else{
                System.out.println("erro al cancelar" + idBuscando + "no existe");
            }
        }
        public Pedido[] generarRespaldoRuta() {
        System.out.println("generar respaldo de la ruta ");
        return listaPedidos.clone();
        }

        public void insertarPedidoExpress(int indiceDeseaso, Pedido pedidoVIP){
        if (indiceDeseaso <0  || indiceDeseaso > cantidadActual){
        System.out.println("Error" + indiceDeseaso + "no es valida");
        return;
        }

        if (cantidadActual >= listaPedidos.length) {
            System.out.println("error del sistema de reparto");
            return;
        }
        for (int i= cantidadActual; i> indiceDeseaso; i--) {
            listaPedidos[i] = listaPedidos[i-1];
        }
        listaPedidos[indiceDeseaso] = pedidoVIP;
        cantidadActual++;
        System.out.println("pedido rapido" + pedidoVIP.toString() + " imsert pedido" + indiceDeseaso);


    }

    public Pedido[] fusionarRutas(Pedido[] ruta1, Pedido[] ruta2) {
        int tamañoTotal = ruta1.length + ruta2.length;
        Pedido[] rutaFusionada = new Pedido[tamañoTotal];
        System.arraycopy(ruta1, 0, rutaFusionada, 0, ruta1.length);
        System.arraycopy(ruta2, 0, rutaFusionada, ruta1.length, ruta2.length);
        System.out.println("se fusiono" + ruta1.length + "y" + ruta2.length + "pedido en una sola ruta");
        return rutaFusionada;

    }

    public boolean compararRutas(Pedido[] ruta1, Pedido[] ruta2 ){
        if (ruta1.length != ruta2.length) {
            System.out.println("comparacion falsa diferente tamaño");
            return false;
        }
        for (int i=0; i< ruta1.length; i++){
            if (ruta1[i] != null && ruta2[i] !=null){
                if (ruta1[i].getIdPedido() != ruta2[i].getIdPedido()){
                    System.out.println("comparacion verdadero ambas rutas son verdaderas ");
                    return false;
                }
            }
        }
        System.out.println("comparacion verdadero");
        return true;
    }

    public Pedido[] clonarRutaEspecial(Pedido[] rutaOriginal) {
        System.out.println("clonacion generando una nueva instancia");
        return rutaOriginal.clone();
    }

    public void mostrarMapaDistancias() {
        System.out.println(" MAPA  MATRIZ SIMÉTRICA");

        int n = 3;
        int[][] distancias = new int[n][n];

        distancias[0][0] = 0;
        distancias[1][1] = 0;
        distancias[2][2] = 0;

        distancias[0][1] = 4;
        distancias[1][0] = 4;

        distancias[0][2] = 6;
        distancias[2][0] = 6;

        distancias[1][2] = 2;
        distancias[2][1] = 2;

        String[] zonas = {"Centro", "Lambramani", "Porongoche"};

        System.out.println("Centro Lambram.Porongoche");
        for (int fila = 0; fila < n; fila++) {
            System.out.print(zonas[fila] + " finas");
            for (int columna = 0; columna < n; columna++) {
                System.out.print(distancias[fila][columna] + "km");
            }
            System.out.println();
        }
    }
}

