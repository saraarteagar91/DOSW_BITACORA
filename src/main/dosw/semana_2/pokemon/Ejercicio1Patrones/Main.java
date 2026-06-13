package main.dosw.semana_2.pokemon.Ejercicio1Patrones;
public class Main {
    public static void main(String[] args) {
        PagoFactory factory1 = new TarjetaCreditoFactory();
        factory1.procesarPago(150.75);

        PagoFactory factory2 = new PayPalFactory();
        factory2.procesarPago(89.99);

        PagoFactory factory3 = new TransferenciaBancariaFactory();
        factory3.procesarPago(500.00);
    }
}
