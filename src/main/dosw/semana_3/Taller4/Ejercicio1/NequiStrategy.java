package main.dosw.semana_3.Taller4.Ejercicio1;

public class NequiStrategy implements PaymentStrategy {
    public void process(double amount) {
        System.out.printf("Nequi - Pago de $%.2f enviado.%n", amount);
    }
}
