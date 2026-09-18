package dinamico;

// molde
public class Pedido{

    private int idPedido;
    private String nombreRestaurante;
    private String estado;

    public Pedido(int idPedido, String nombreRestaurante) {
    this.idPedido = idPedido;
    this.nombreRestaurante = nombreRestaurante;
    this.estado = "Pendiente";
    }

    public int getIdPedido() {
        return idPedido;
    }
    public String getEstado() {
        return  estado;
    }
    public  void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    @Override
    public String toString() {
        return "pedido" + idPedido + "restaurante:" + nombreRestaurante + " estado" + estado;
    }
}