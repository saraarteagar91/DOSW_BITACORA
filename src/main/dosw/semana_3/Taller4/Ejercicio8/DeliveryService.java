package main.dosw.semana_3.Taller4.Ejercicio8;

public class DeliveryService implements OrderObserver {
    public void onOrderConfirmed(Order o) {
        System.out.println("Domicilio - Ruta para: " + o.getAddress());
    }
}
