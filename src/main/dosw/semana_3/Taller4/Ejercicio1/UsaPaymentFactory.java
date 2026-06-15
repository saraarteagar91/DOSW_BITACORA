package main.dosw.semana_3.Taller4.Ejercicio1;

public class UsaPaymentFactory implements PaymentFactory {
    public PaymentStrategy create(String type) {
        return switch (type.toLowerCase()) {
            case "paypal" -> new PaypalStrategy();
            case "stripe" -> new StripeStrategy();
            default -> throw new IllegalArgumentException("Método no disponible en Estados Unidos: " + type);
        };
    }
}
