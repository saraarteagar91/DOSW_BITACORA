package main.dosw.semana_2.pokemon.Ejercicio1Patrones;
public class PayPalFactory extends PagoFactory {
    @Override public MetodoPago crearMetodoPago() { return new PayPal(); }
}
