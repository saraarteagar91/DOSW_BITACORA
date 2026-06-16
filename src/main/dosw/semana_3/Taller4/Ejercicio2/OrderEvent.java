package main.dosw.semana_3.Taller4.Ejercicio2;

public class OrderEvent {
    private String orderId;
    private String status;
    public OrderEvent(String orderId, String status) {
        this.orderId = orderId; this.status = status;
    }
    public String getOrderId() {
        return orderId;
    }
    public String getStatus() {
        return status;
    }
}
