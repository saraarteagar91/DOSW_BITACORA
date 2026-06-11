package main.dosw.semana_1.streams;

import java.util.List;

public class Ejercicio5 {

    record Transaction(String id, double amount, boolean approved) {}

    public static void main(String[] args) {

        List<Transaction> transactions = List.of(
                new Transaction("T001", 150.0,  true),
                new Transaction("T002", 320.5,  true),
                new Transaction("T003", 89.0,   false),
                new Transaction("T004", 540.0,  true),
                new Transaction("T005", 210.75, false)
        );

        boolean tieneNoAprobadas = transactions.stream()
                .peek(t -> System.out.println("Procesando transacción: " + t.id() + " Monto: $" + t.amount() + " Aprobada: " + t.approved()))
                .anyMatch(t -> !t.approved());
        System.out.println("\nLote válido: " + !tieneNoAprobadas);
    }
}