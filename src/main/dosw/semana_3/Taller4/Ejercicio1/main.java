package main.dosw.semana_3.Taller4.Ejercicio1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Plataforma de Pagos Inteligentes");
        System.out.print("Ingresa tu pais: ");
        String country = sc.nextLine().trim();
        PaymentFactory factory;
        try {
            factory = PaymentFactoryProvider.getFactory(country);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.close();
            return;
        }
        if (country.equalsIgnoreCase("colombia")) {
            System.out.println("Métodos disponibles: pse, nequi, tarjeta");
        } else {
            System.out.println("Métodos disponibles: paypal, stripe");
        }
        System.out.print("Elige metodo de pago: ");
        String method = sc.nextLine().trim();
        System.out.print("Ingresa el monto a pagar: $");
        double amount = Double.parseDouble(sc.nextLine().trim());
        PaymentStrategy strategy;
        try {
            strategy = factory.create(method);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.close();
            return;
        }
        new Checkout(strategy).completePurchase(amount);
        sc.close();
    }
}