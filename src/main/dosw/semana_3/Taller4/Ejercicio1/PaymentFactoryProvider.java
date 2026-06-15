package main.dosw.semana_3.Taller4.Ejercicio1;

public class PaymentFactoryProvider {
    public static PaymentFactory getFactory(String country) {
        return switch (country.toLowerCase()) {
            case "colombia" -> new ColombiaPaymentFactory();
            case "usa" -> new UsaPaymentFactory();
            default -> throw new IllegalArgumentException("País no soportado: " + country);
        };
    }
}
