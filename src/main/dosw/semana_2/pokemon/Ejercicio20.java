package main.dosw.semana_2.pokemon;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio20 {
    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L,  "Pikachu",   "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L,  "Mewtwo",    "Psíquico",  80, 680, "Kanto", true),
                new Pokemon(3L,  "Dragonite", "Dragón",    70, 530, "Kanto", false),
                new Pokemon(4L,  "Squirtle",  "Agua",      20, 210, "Kanto", false),
                new Pokemon(5L,  "Gengar",    "Fantasma",  55, 495, "Kanto", false),
                new Pokemon(6L,  "Charizard", "Fuego",     75, 610, "Kanto", false),
                new Pokemon(7L,  "Chikorita", "Planta",    18, 190, "Johto",  false),
                new Pokemon(8L,  "Lugia",     "Psíquico",  85, 690, "Johto",  true),
                new Pokemon(9L,  "Torchic",   "Fuego",     15, 180, "Hoenn",  false),
                new Pokemon(10L, "Psyduck",   "Agua",      30, 280, "Kanto",  false)
        );

        Map<String, Long> porTipo = pokemones.stream()
                .collect(Collectors.groupingBy(p -> p.getTipo(), Collectors.counting()));

        Map<String, Long> porRegion = pokemones.stream()
                .collect(Collectors.groupingBy(p -> p.getRegion(), Collectors.counting()));

        long legendarios = pokemones.stream()
                .filter(p -> p.isLegendario())
                .count();

        double promedioNivel = pokemones.stream()
                .mapToInt(p -> p.getNivel())
                .average()
                .orElse(0);

        Pokemon masFuerte = pokemones.stream()
                .reduce(pokemones.get(0), (a, b) -> a.getPoderCombate() >= b.getPoderCombate() ? a : b);

        System.out.println("Pokédex Analítica");
        System.out.println("Por tipo: " + porTipo);
        System.out.println("Por región: " + porRegion);
        System.out.println("Legendarios: " + legendarios);
        System.out.println("Promedio niv: " + promedioNivel);
        System.out.println("Más fuerte: " + masFuerte.getNombre() + " (PC: " + masFuerte.getPoderCombate() + ")");
    }
}