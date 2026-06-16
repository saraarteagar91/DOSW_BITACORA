package main.dosw.semana_3.Taller4.Ejercicio2;

public class EmailNotifier implements NotificationObserver {
    private MessageFactory factory = new EmailMessageFactory();
    public void notify(OrderEvent event) {
        System.out.println("EMAIL - " + factory.build(event));
    }
}
