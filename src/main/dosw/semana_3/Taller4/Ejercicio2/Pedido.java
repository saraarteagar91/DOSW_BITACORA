package main.dosw.semana_3.Taller4.Ejercicio2;

import java.util.ArrayList;
import java.util.List;
public class Pedido {
    private String id;
    private String status;
    private List<NotificationObserver> observers = new ArrayList<>();
    public Pedido(String id) {
        this.id = id; this.status = "PENDIENTE";
    }
    public void addObserver(NotificationObserver o) {
        observers.add(o);
    }
    public void removeObserver(NotificationObserver o) {
        observers.remove(o);
    }
    private void notifyObservers() {
        OrderEvent e = new OrderEvent(id, status);
        for (NotificationObserver o : observers) o.notify(e);
    }
    public void cambiarEstado(String nuevoEstado) {
        this.status = nuevoEstado;
        System.out.println("\nPedido " + id + " -> " + status);
        notifyObservers();
    }
}