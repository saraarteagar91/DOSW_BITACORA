package main.dosw.semana_3.Taller4.Ejercicio5;

public class LegacyBankService {
    private int balanceCents;
    public LegacyBankService(int saldoInitial) {
        this.balanceCents = saldoInitial;
    }
    public boolean executeTransaction(String accountId, int amountCents) {
        if (balanceCents >= amountCents) {
            balanceCents -= amountCents;
            return true;
        }
        System.out.println("Fondos insuficientes.");
        return false;
    }
    public int verifyBalance(String accountId) {
        return balanceCents;
    }
}
