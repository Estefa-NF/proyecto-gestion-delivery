import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class ConexionDB {
        private static final String URL = "jdbc:sqlite:delivery.db";

        public static Connection conectar() {
            Connection conexion = null;
            try {
                conexion = DriverManager.getConnection(URL);
                System.out.println("Conectado a la base de datos del delivery.");
            } catch (SQLException e) {
                System.out.println("Error de conexión" + e.getMessage());
            }
            return conexion;
        }

        public static void main(String[] args) {
            conectar();
        }
    }

