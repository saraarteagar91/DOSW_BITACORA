package main.dosw.semana_3.Taller4.Ejercicio8;
import java.util.*;

public class Order {
    private final String size, meat, address;
    private final List<String> toppings, sides;
    private final double total;
    private final List<OrderObserver> observers = new ArrayList<>();
    Order(OrderBuilder b) {
        size=b.size;
        meat=b.meat;
        toppings=new ArrayList<>(b.toppings);
        sides=new ArrayList<>(b.sides);
        address=b.address;
        total=b.total;
    }
    public void addObserver(OrderObserver o) { observers.add(o); }
    public void confirm() {
        for (OrderObserver o : observers) o.onOrderConfirmed(this);
        System.out.println("Pedido confirmado.");
    }
    public String getSummary() {
        return size+" , "+meat+" , toppings:" +toppings+ " , acompañamientos:"+sides;
    }
    public double getTotal() {
        return total;
    }
    public String getAddress() {
        return address;
    }
}
