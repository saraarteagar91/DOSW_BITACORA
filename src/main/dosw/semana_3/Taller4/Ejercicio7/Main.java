package main.dosw.semana_3.Taller4.Ejercicio7;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el título del documento: ");
        String titulo = sc.nextLine().trim();
        Document doc = new Document(titulo);
        doc.printStatus();
        System.out.println("\nRevisores disponibles: autor, lider, juridico");
        System.out.print("Ingrese la cadena de revisores en orden: ");
        String[] revisores = sc.nextLine().trim().split(",");
        DocumentHandler primero = null, ultimo = null;
        for (String rev : revisores) {
            DocumentHandler handler = null;
            switch (rev.trim().toLowerCase()) {
                case "autor":
                    handler = new AutorHandler(); break;
                case "lider":
                    System.out.print("El lider aprueba el documento: ");
                    boolean aprueba = sc.nextLine().trim().equalsIgnoreCase("si");
                    handler = new LiderHandler(aprueba); break;
                case "juridico":
                    handler = new JuridicoHandler(); break;
                default:
                    System.out.println("Revisor desconocido: " + rev.trim()); continue;
            }
            if (primero == null) {
                primero = handler;
                ultimo = handler;
            }
            else {
                ultimo.setNext(handler);
                ultimo = handler;
            }
        }
        if (primero != null) {
            DocumentHandler actual = primero;
            while (actual != null) {
                actual.handle(doc);
                actual = null;
            }
            primero.handle(doc);
        }
        System.out.println();
        doc.printStatus();
        sc.close();
    }
}
