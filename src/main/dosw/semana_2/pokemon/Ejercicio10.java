package main.dosw.semana_2.pokemon;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio10 {
    public static void main(String[] args) {

        List<Pokemon> pokemones = List.of(
                new Pokemon(1L, "Pikachu",   "Eléctrico", 45, 320, "Kanto", false),
                new Pokemon(2L, "Mewtwo",    "Psíquico",  80, 680, "Kanto", true),
                new Pokemon(3L, "Dragonite", "Dragón",    70, 530, "Kanto", false),
                new Pokemon(4L, "Squirtle",  "Agua",      20, 210, "Kanto", false),
                new Pokemon(5L, "Gengar",    "Fantasma",  55, 495, "Kanto", false),
                new Pokemon(6L, "Charizard", "Fuego",     75, 610, "Kanto", false)
        );

        List<String> nombres = pokemones.stream()
                .map(Pokemon::getNombre)
                .collect(Collectors.toList());

        System.out.println("Pokédex Compacta: " + nombres);
    }
}