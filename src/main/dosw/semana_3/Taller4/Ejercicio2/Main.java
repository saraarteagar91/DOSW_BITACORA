package main.dosw.semana_3.Taller4.Ejercicio2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de Notificaciones Multicanal");
        System.out.print("Ingresa el ID del pedido: ");
        String id = sc.nextLine().trim();
        Pedido pedido = new Pedido(id);
        System.out.println("Canales disponibles: email, sms, push");
        System.out.print("Ingresa los canales activos separados por coma: ");
        String[] canales = sc.nextLine().trim().split(",");
        for (String canal : canales) {
            switch (canal.trim().toLowerCase()) {
                case "email": pedido.addObserver(new EmailNotifier()); break;
                case "sms":   pedido.addObserver(new SmsNotifier());   break;
                case "push":  pedido.addObserver(new PushNotifier());  break;
                default: System.out.println("Canal desconocido ignorado: " + canal.trim());
            }
        }
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nIngresa el nuevo estado del pedido o salir: ");
            String estado = sc.nextLine().trim();
            if (estado.equalsIgnoreCase("salir")) {
                continuar = false;
            } else {
                pedido.cambiarEstado(estado.toUpperCase());
            }
        }
        sc.close();
    }
}
