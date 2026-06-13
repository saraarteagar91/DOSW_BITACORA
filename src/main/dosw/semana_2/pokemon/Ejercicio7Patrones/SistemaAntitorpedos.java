package main.dosw.semana_2.pokemon.Ejercicio7Patrones;
public class SistemaAntitorpedos extends BarcoDecorador {
    public SistemaAntitorpedos(Barco barco) { super(barco); }
    @Override
    public String getDescripcion() { return barco.getDescripcion() + " + Sistema antitorpedos"; }
    @Override
    public int getAtaque() { return barco.getAtaque() + 20; }
    @Override
    public int getDefensa() { return barco.getDefensa(); }
}
