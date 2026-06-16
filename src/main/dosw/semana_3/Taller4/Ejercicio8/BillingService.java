package main.dosw.semana_3.Taller4.Ejercicio8;

public class BillingService implements OrderObserver {
    public void onOrderConfirmed(Order o) {
        System.out.printf("Facturacion - Total: $%.2f%n", o.getTotal());
    }
}
