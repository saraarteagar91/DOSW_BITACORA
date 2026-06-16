package main.dosw.semana_3.Taller4.Ejercicio2;

public class SmsMessageFactory implements MessageFactory {
    public String build(OrderEvent event) {
        String msg = "Pedido " + event.getOrderId() + ": " + event.getStatus();
        return msg.length() > 160 ? msg.substring(0, 160) : msg;
    }
}
