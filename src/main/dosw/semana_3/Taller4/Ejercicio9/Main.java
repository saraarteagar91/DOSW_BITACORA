package main.dosw.semana_3.Taller4.Ejercicio9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthService service = new AuthService();
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nNombre de usuario: ");
            String usuario = sc.nextLine().trim();
            if (usuario.equalsIgnoreCase("salir")) {
                continuar = false;
                continue;
            }
            System.out.println("Métodos: password, google, biometria");
            System.out.print("Método de autenticación: ");
            String metodo = sc.nextLine()
                              .trim()
                              .toLowerCase();
            System.out.print("Token de acceso: ");
            String token = sc.nextLine()
                             .trim();
            System.out.print("Pais de acceso: ");
            String pais = sc.nextLine()
                            .trim();
            System.out.print("Hora de acceso: ");
            int hora = Integer.parseInt(sc.nextLine()
                                          .trim());
            Credentials creds = new Credentials(usuario, token, pais, hora);
            AuthStrategy strategy;
            switch (metodo) {
                case "password":strategy = new PasswordStrategy();
                break;
                case "google":strategy = new GoogleStrategy();
                break;
                case "biometria":strategy = new BiometricStrategy();
                break;
                default:System.out.println("Metodo no valido.");
                continue;
            }
            service.login(strategy, creds);
        }
        sc.close();
    }
}
