package main.dosw.semana_3.Taller4.Ejercicio6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese su nombre de usuario: ");
        String userId = sc.nextLine().trim();
        UserProfile perfil = new UserProfile(userId);
        perfil.addObserver(new HomePageComponent());
        perfil.addObserver(new NotificationService());
        perfil.addObserver(new SuggestedListComponent());
        System.out.println("Algoritmos disponibles: genero, historial, popularidad, similitud");
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nSeleccione algoritmo de recomendacion (o 'salir'): ");
            String opcion = sc.nextLine().trim().toLowerCase();
            switch (opcion) {
                case "genero":perfil.changePreference(new GenreStrategy());
                break;
                case "historial":perfil.changePreference(new HistoryStrategy());
                break;
                case "popularidad":perfil.changePreference(new PopularityStrategy());
                break;
                case "similitud":perfil.changePreference(new SimilarityStrategy());
                break;
                case "salir":continuar = false;
                break;
                default: System.out.println("Opcion no valida.");
            }
        }
        sc.close();
    }
}
