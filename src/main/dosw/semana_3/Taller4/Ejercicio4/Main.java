package main.dosw.semana_3.Taller4.Ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Plataforma de Videojuegos: Personajes");
        System.out.print("Ingresa el nombre del personaje: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Ingresa el tipo de armadura: ");
        String armadura = sc.nextLine().trim();
        System.out.print("Ingresa el tipo de arma: ");
        String arma = sc.nextLine().trim();
        System.out.print("Ingresa la habilidad especial: ");
        String habilidad = sc.nextLine().trim();
        Character personaje = new CharacterBuilder(nombre)
                .setArmor(armadura)
                .setWeapon(arma)
                .setSkill(habilidad)
                .build();
        System.out.println("\nPersonaje creado: " + personaje.getDescription());
        System.out.println("Ataque base");
        personaje.attack();
        System.out.println("\nPoderes disponibles: escudo, velocidad, invisibilidad");
        System.out.print("Ingresa los poderes a activar: ");
        String[] poderes = sc.nextLine().trim().split(",");
        for (String poder : poderes) {
            switch (poder.trim().toLowerCase()) {
                case "escudo":personaje = new ShieldDecorator(personaje);
                break;
                case "velocidad":personaje = new SpeedDecorator(personaje);
                break;
                case "invisibilidad":personaje = new InvisibilityDecorator(personaje);
                break;
                default: System.out.println("Poder desconocido: " + poder.trim());
            }
        }
        System.out.println("\nAtaque con poderes activos");
        System.out.println("Estado: " + personaje.getDescription());
        personaje.attack();
        sc.close();
    }
}