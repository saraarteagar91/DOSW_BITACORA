package main.dosw.semana_2.pokemon.Ejercicio1Patrones;
public abstract class PagoFactory {
    public abstract MetodoPago crearMetodoPago();
    public void procesarPago(double monto) {
        crearMetodoPago().procesarPago(monto);
    }
}
