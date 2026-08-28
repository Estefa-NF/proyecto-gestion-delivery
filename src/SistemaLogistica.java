

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
    public Pedido [] fusionarRutas(Pedido[] ruta1, Pedido[] ruta2){
        int tamañoTotal = ruta1.length + ruta2.length;
        Pedido [] rutaFusionada = new Pedido[tamañoTotal];
        System.arraycopy(ruta1,0,rutaFusionada,0,ruta1.length);
        System.arraycopy(ruta2,0,rutaFusionada,ruta1.length,ruta2.length);
        System.out.println("se fusiono" + ruta1.length + "y" + ruta2.length +"pedido en una sola ruta");
        return rutaFusionada;

    }


    }

