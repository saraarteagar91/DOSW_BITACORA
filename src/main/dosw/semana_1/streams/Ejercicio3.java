package main.dosw.semana_1.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio3 {

    record User(int id, String name, int age, boolean active) {}

    public static void main(String[] args) {

        List<User> users = List.of(
                new User(1, "Carlos",  25, true),
                new User(2, "Ana",     30, false),
                new User(3, "Beatriz", 22, true),
                new User(4, "Daniel",  28, true),
                new User(5, "Elena",   35, false)
        );

        List<String> sortedUsers = users.stream()
                .filter(User::active)
                .map(u -> u.name().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Usuarios activos (mayúsculas, ordenados): " + sortedUsers);
    }
}