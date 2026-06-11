package main.dosw.semana_2.pokemon;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio19 {
    public static void main(String[] args) {

        List<Entrenador> entrenadores = List.of(
                new Entrenador(1L, "Gary",  10, List.of(
                        new Pokemon(1L, "Mewtwo",  "Psíquico",  80, 2340, "Kanto", true))),
                new Entrenador(2L, "Ash",   8,  List.of(
                        new Pokemon(2L, "Pikachu", "Eléctrico", 45, 1850, "Kanto", false))),
                new Entrenador(3L, "Dawn",  7,  List.of(
                        new Pokemon(3L, "Piplup",  "Agua",      40, 2100, "Sinnoh", false))),
                new Entrenador(4L, "Brock", 6,  List.of(
                        new Pokemon(4L, "Onix",    "Roca",      40, 1670, "Kanto", false)))
        );

        Comparator<Entrenador> rankingComparator = Comparator
                .comparingInt(Entrenador::getMedallas).reversed()
                .thenComparingDouble(Entrenador::getPoderTotal).reversed()
                .thenComparing(Entrenador::getNombre);

        List<Entrenador> top3 = entrenadores.stream()
                .sorted(rankingComparator)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Top 3 de Entrenadores:");
        int[] rank = {1};
        top3.forEach(e -> System.out.printf("  #%d %-6s – %d medallas, PC: %.0f%n", rank[0]++, e.getNombre(), e.getMedallas(), e.getPoderTotal()));
    }
}