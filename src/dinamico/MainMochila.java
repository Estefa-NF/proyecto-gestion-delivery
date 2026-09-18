package dinamico;

public class MainMochila {
    public static void main(String[] args) {
        System.out.println("MOCHILA (PILA / LIFO)");
        //el ultimo elemento en  entrar es el primero en salir

        MochilaReparto mochila = new MochilaReparto();

        Pedido p1 = new Pedido(1, "KFC");
        Pedido p2 = new Pedido(2, "Bembos");
        Pedido p3 = new Pedido(3, "Pizza Hut");

        mochila.push(p1);
        mochila.push(p2);
        mochila.push(p3);

        System.out.println("EN RUTA");
        mochila.top();

        System.out.println("LLEGANDO A LOS CLIENTES" );
        mochila.pop();
        mochila.pop();

        mochila.top();
        mochila.pop();
        mochila.pop();
    }
}