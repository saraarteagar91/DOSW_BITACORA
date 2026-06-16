package main.dosw.semana_3.Taller4.Ejercicio2;

public class PushNotifier implements NotificationObserver {
    private MessageFactory factory = new PushMessageFactory();
    public void notify(OrderEvent event) {
        System.out.println("PUSH - " + factory.build(event));
    }
}
