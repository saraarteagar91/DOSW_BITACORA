package main.dosw.semana_3.Taller4.Ejercicio2;

public class PushMessageFactory implements MessageFactory {
    public String build(OrderEvent event) {
        return "Pedido " + event.getOrderId() + ": " + event.getStatus();
    }
}
