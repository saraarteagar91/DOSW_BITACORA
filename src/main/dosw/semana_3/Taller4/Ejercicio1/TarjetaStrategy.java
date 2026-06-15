package main.dosw.semana_3.Taller4.Ejercicio1;

public class TarjetaStrategy implements PaymentStrategy {
    public void process(double amount) {
        System.out.printf("Tarjeta - Pago de $%.2f aplicado a tarjeta de credito.%n", amount);
    }
}
