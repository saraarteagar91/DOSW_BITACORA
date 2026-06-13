package main.dosw.semana_2.pokemon.Ejercicio7Patrones;
public class Misiles extends BarcoDecorador {
    public Misiles(Barco barco) { super(barco); }
    @Override
    public String getDescripcion() { return barco.getDescripcion() + " + Misiles"; }
    @Override
    public int getAtaque() { return barco.getAtaque() + 40; }
    @Override
    public int getDefensa() { return barco.getDefensa(); }
}
