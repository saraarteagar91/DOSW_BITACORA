package main.dosw.semana_3.Taller4.Ejercicio8;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tamaño de la hamburguesa (sencilla/doble/triple): ");
        String tamano = sc.nextLine()
                          .trim();
        System.out.print("Tipo de carne (res/pollo/vegetariana): ");
        String carne = sc.nextLine()
                         .trim();
        OrderBuilder builder = new OrderBuilder().setSize(tamano)
                                                 .setMeat(carne);
        System.out.print("Agrega toppings: ");
        String toppingsInput = sc.nextLine()
                                 .trim();
        if (!toppingsInput.isEmpty())
            for (String t : toppingsInput.split(","))
                builder.addTopping(t.trim());
        System.out.print("Agrega acompanantes: ");
        String sidesInput = sc.nextLine()
                              .trim();
        if (!sidesInput.isEmpty())
            for (String s : sidesInput.split(","))
                builder.addSide(s.trim());
        System.out.print("Dirección de entrega o Enter para recoger en tienda: ");
        String dir = sc.nextLine()
                       .trim();
        if (!dir.isEmpty())
            builder.setAddress(dir);
        System.out.print("Valor total del pedido: $");
        double total = Double.parseDouble(sc.nextLine()
                                            .trim());
        builder.setTotal(total);
        Order order = builder.build();
        System.out.println("\nPedido: " + order.getSummary());
        System.out.println("Notificaciones: cocina, facturación, domicilio");
        System.out.print("Servicios a notificar: ");
        String[] servicios = sc.nextLine()
                               .trim()
                               .split(",");
        for (String s : servicios) {
            switch (s.trim()
                     .toLowerCase()) {
                case "cocina":order.addObserver(new KitchenService());
                break;
                case "facturación":order.addObserver(new BillingService());
                break;
                case "domicilio":order.addObserver(new DeliveryService());
                break;
                default: System.out.println("Servicio desconocido: " + s.trim());
            }
        }
        order.confirm();
        sc.close();
    }
}
