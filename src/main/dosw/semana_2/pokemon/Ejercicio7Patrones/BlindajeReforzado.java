package main.dosw.semana_2.pokemon.Ejercicio7Patrones;
public class BlindajeReforzado extends BarcoDecorador {
    public BlindajeReforzado(Barco barco) { super(barco); }
    @Override
    public String getDescripcion() { return barco.getDescripcion() + " + Blindaje reforzado"; }
    @Override
    public int getAtaque() { return barco.getAtaque(); }
    @Override
    public int getDefensa() { return barco.getDefensa() + 30; }
}
