package main.dosw.semana_3.Taller4.Ejercicio8;

public class KitchenService implements OrderObserver {
    public void onOrderConfirmed(Order o) {
        System.out.println("Cocina - Preparando: " + o.getSummary());
    }
}
