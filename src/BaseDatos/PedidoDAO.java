package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public void insertarPedido(int idCliente, int idRepartidor, int idRestaurante, double total) {
        String sql = "INSERT INTO Pedidos (id_cliente, id_repartidor, id_restaurante, estado, total) VALUES (?, ?, ?, 'Pendiente', ?)";

        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCliente);
            pstmt.setInt(2, idRepartidor);
            pstmt.setInt(3, idRestaurante);
            pstmt.setDouble(4, total);

            pstmt.executeUpdate();
            System.out.println("¡Éxito! Pedido guardado en la base de datos.");

        } catch (SQLException e) {
            System.out.println("Error al guardar el pedido: " + e.getMessage());
        }
    }
}