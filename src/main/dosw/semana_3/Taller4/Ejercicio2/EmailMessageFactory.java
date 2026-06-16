package main.dosw.semana_3.Taller4.Ejercicio2;

public class EmailMessageFactory implements MessageFactory {
    public String build(OrderEvent event) {
        return "<html><p>Pedido <b>" + event.getOrderId() + "</b> -> <b>" + event.getStatus() + "</b></p></html>";
    }
}
