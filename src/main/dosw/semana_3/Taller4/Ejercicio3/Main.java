package main.dosw.semana_3.Taller4.Ejercicio3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de Reportes Empresariales");
        System.out.println("Formatos disponibles: PDF, EXCEL, CSV");
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nIngrese el formato del reporte o salir: ");
            String tipo = sc.nextLine().trim();
            if (tipo.equalsIgnoreCase("salir")) {
                continuar = false;
            } else {
                try {
                    ReportGenerator reporte = ReportFactory.create(tipo);
                    System.out.println("Generando el reporte " + tipo.toUpperCase() + ":");
                    reporte.generate();
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        sc.close();
    }
}
