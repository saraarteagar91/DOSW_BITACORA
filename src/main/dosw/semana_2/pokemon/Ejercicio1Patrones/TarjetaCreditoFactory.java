package main.dosw.semana_2.pokemon.Ejercicio1Patrones;
public class TarjetaCreditoFactory extends PagoFactory {
    @Override public MetodoPago crearMetodoPago() { return new TarjetaCredito(); }
}
