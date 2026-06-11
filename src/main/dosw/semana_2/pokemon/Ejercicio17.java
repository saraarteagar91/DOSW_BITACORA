package main.dosw.semana_2.pokemon;
import java.util.Comparator;
import java.util.List;

public class Ejercicio17 {
    public static void main(String[] args) {

        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Ash",   8,  List.of(
                        new Pokemon(1L, "Pikachu",   "Eléctrico", 45, 620,  "Kanto", false),
                        new Pokemon(2L, "Charizard", "Fuego",     75, 1230, "Kanto", false))),
                new Entrenador(2L, "Gary",  10, List.of(
                        new Pokemon(3L, "Mewtwo",    "Psíquico",  80, 1500, "Kanto", true),
                        new Pokemon(4L, "Dragonite", "Dragón",    70, 840,  "Kanto", false))),
                new Entrenador(3L, "Brock", 6,  List.of(
                        new Pokemon(5L, "Onix",      "Roca",      40, 900,  "Kanto", false),
                        new Pokemon(6L, "Geodude",   "Roca",      20, 770,  "Kanto", false)))
        );

        entrenadores.stream()
                .max(Comparator.comparingDouble(Entrenador::getPoderTotal))
                .ifPresent(e -> {
                    System.out.println("Entrenador más poderoso: " + e.getNombre());
                    System.out.println("Poder acumulado del equipo: " + e.getPoderTotal());
                });
    }
}