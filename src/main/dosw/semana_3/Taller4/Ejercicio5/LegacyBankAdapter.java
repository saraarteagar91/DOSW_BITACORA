package main.dosw.semana_3.Taller4.Ejercicio5;

public class LegacyBankAdapter implements PaymentProcessor {
    private final LegacyBankService legacy;
    private static final String ACCOUNT_ID = "ACC-001";
    public LegacyBankAdapter(LegacyBankService legacy) {
        this.legacy = legacy;
    }
    public boolean pay(double amount) {
        return legacy.executeTransaction(ACCOUNT_ID, (int)(amount * 100));
    }
    public double getBalance() {
        return legacy.verifyBalance(ACCOUNT_ID) / 100.0;
    }
}
