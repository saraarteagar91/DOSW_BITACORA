package main.dosw.semana_3.Taller4.Ejercicio1;

public class PaypalStrategy implements PaymentStrategy {
    public void process(double amount) {
        System.out.printf("PayPal - Pago de $%.2f procesado.%n", amount);
    }
}
