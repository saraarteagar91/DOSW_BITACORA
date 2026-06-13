package main.dosw.semana_2.pokemon.Ejercicio1Patrones;
public class TransferenciaBancariaFactory extends PagoFactory {
    @Override public MetodoPago crearMetodoPago() { return new TransferenciaBancaria(); }
}
