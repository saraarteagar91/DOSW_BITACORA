package main.dosw.semana_3.Taller4.Ejercicio1;

public class StripeStrategy implements PaymentStrategy {
    public void process(double amount) {
        System.out.printf("Stripe - Pago de $%.2f completado.%n", amount);
    }
}
