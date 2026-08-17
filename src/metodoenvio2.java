public interface metodoenvio2 {
    double calcularcosto(double distancia);
}
public class enviomotocicleta implements metodoenvio2 {
    @Override
    public double calcularcosto( double distancia) {
        return distancia * 2.5;
    }
}
public class enviobicicleta implements metodoenvio2 {
    @Override
    public double calcularcosto (double distancia) {
        return distancia * 1.25;
    }
}
public class calculadoratarifa {
    public double calcularcosto(metodoenvio2 metodo, double distancia){
        return metodo.calcularcosto(distancia);
    }
}