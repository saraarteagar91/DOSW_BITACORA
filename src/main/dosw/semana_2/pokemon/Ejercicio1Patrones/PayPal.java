package main.dosw.semana_2.pokemon.Ejercicio1Patrones;
public class PayPal implements MetodoPago {
    @Override
    public void procesarPago(double monto) {
        System.out.printf("Pago con PayPal por $ %.2f%n", monto);
    }
}
