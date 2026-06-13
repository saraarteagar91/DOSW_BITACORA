package main.dosw.semana_2.pokemon.Ejercicio1Patrones;
public class TarjetaCredito implements MetodoPago {
    @Override
    public void procesarPago(double monto) {
        System.out.printf("Pago con Tarjeta de Credito por $ %.2f%n", monto);
    }
}
