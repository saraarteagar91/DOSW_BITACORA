package main.dosw.semana_3.Taller4.Ejercicio1;

public class ColombiaPaymentFactory implements PaymentFactory {
    public PaymentStrategy create(String type) {
        return switch (type.toLowerCase()) {
            case "pse" -> new PseStrategy();
            case "nequi" -> new NequiStrategy();
            case "tarjeta" -> new TarjetaStrategy();
            default -> throw new IllegalArgumentException("Método de pago no disponible en Colombia: " + type);
        };
    }
}
