package main.dosw.semana_2.pokemon;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio18 {
    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu",   "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo",    "Psíquico",  80, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón",    70, 530, "Kanto", false),
                new Pokemon(4L, "Squirtle",  "Agua",      20, 210, "Kanto", false),
                new Pokemon(5L, "Gengar",    "Fantasma",  55, 495, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego",     75, 610, "Kanto", false),
                new Pokemon(7L, "Snorlax",   "Normal",    60, 180, "Kanto", false)
        );

        List<Pokemon> top5 = pokemones.stream()
                .sorted(Comparator.comparingDouble(Pokemon::getPoderCombate).reversed())
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Top 5 de Pokémon más fuertes:");
        int[] rank = {1};
        top5.forEach(p -> System.out.printf("  #%d %-12s – PC: %.0f%n", rank[0]++, p.getNombre(), p.getPoderCombate()));
    }
}