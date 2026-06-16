package main.dosw.semana_3.Taller4.Ejercicio8;
import java.util.*;

public class OrderBuilder {
    String size="MEDIANA", meat="Res", address="Recoger en tienda"; double total=15000;
    List<String> toppings=new ArrayList<>(), sides=new ArrayList<>();
    public OrderBuilder setSize(String s) {
        size=s;
        return this;
    }
    public OrderBuilder setMeat(String m) {
        meat=m;
        return this;
    }
    public OrderBuilder setAddress(String a) {
        address=a; return this;
    }
    public OrderBuilder setTotal(double t) {
        total=t;
        return this;
    }
    public OrderBuilder addTopping(String t) {
        toppings.add(t);
        return this;
    }
    public OrderBuilder addSide(String s) {
        sides.add(s);
        return this;
    }
    public Order build() {
        return new Order(this);
    }
}
