package main.dosw.semana_2.pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {

    public static void main(String[] args) {

        List<String> pokemones = List.of(
                "Pikachu", "Charmander", "Squirtle", "Bulbasaur"
        );

        List<String> gritones = pokemones.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Pokédex Gritona: " + gritones);
    }
}