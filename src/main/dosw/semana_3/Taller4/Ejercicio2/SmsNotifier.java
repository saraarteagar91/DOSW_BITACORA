package main.dosw.semana_3.Taller4.Ejercicio2;

public class SmsNotifier implements NotificationObserver {
    private MessageFactory factory = new SmsMessageFactory();
    public void notify(OrderEvent event) {
        System.out.println("SMS -  " + factory.build(event));
    }
}
