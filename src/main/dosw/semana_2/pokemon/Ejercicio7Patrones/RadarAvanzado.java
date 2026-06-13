package main.dosw.semana_2.pokemon.Ejercicio7Patrones;
public class RadarAvanzado extends BarcoDecorador {
    public RadarAvanzado(Barco barco) { super(barco); }
    @Override
    public String getDescripcion() { return barco.getDescripcion() + " + Radar avanzado"; }
    @Override
    public int getAtaque() { return barco.getAtaque() + 10; }
    @Override
    public int getDefensa() { return barco.getDefensa(); }
}
