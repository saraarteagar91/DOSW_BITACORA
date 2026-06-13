package main.dosw.semana_2.pokemon.Ejercicio1Patrones;
public class TransferenciaBancaria implements MetodoPago {
    @Override
    public void procesarPago(double monto) {
        System.out.printf("Pago con Transferencia Bancaria por $ %.2f%n", monto);
    }
}
