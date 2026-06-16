package main.dosw.semana_3.Taller4.Ejercicio5;

public class BankFacade {
    private PaymentProcessor processor;
    public BankFacade(double saldoInicial) {
        this.processor = new LegacyBankAdapter(new LegacyBankService((int)(saldoInicial * 100)));
    }
    public void procesarPago(double monto) {
        boolean r = processor.pay(monto);
        System.out.println("Resultado: " + (r ? "APROBADO" : "RECHAZADO"));
    }
    public void consultarSaldo() {
        System.out.printf("Saldo actual: $%.2f%n", processor.getBalance());
    }
}
