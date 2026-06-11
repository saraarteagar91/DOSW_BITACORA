package main.dosw.semana_2.pokemon;
import java.util.Comparator;
import java.util.List;

public class Ejercicio12 {
    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu",   "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo",    "Psíquico",  80, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón",    70, 530, "Kanto", false),
                new Pokemon(4L, "Charizard", "Fuego",     75, 610, "Kanto", false)
        );

        pokemones.stream()
                .max(Comparator.comparingDouble(Pokemon::getPoderCombate))
                .ifPresent(p -> System.out.println(
                        "Campeón: " + p.getNombre() + " con PC: " + p.getPoderCombate()));
    }
}