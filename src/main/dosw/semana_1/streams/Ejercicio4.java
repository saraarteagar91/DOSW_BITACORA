package main.dosw.semana_1.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4 {

    record User(int id, String name, int age, boolean active) {}

    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Carlos",  25, true),
                new User(2, "Ana",     16, false),
                new User(3, "Beatriz", 17, true),
                new User(4, "Daniel",  28, true),
                new User(5, "Elena",   15, false)
        );

        List<String> mayores = users.stream()
                .filter(u -> u.age() >= 18)
                .map(User::name)
                .collect(Collectors.toList());

        System.out.println("Personas mayores de edad: " + mayores);
    }
}