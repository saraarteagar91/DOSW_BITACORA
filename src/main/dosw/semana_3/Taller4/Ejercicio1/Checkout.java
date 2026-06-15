package main.dosw.semana_3.Taller4.Ejercicio1;

public class Checkout {
    private PaymentStrategy strategy;
    public Checkout(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void completePurchase(double amount) {
        System.out.println("Procesando la compra");
        strategy.process(amount);
        System.out.println("Compra exitosa");
    }
}
