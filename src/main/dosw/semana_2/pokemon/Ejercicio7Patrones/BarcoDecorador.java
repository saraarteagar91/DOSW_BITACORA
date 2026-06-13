package main.dosw.semana_2.pokemon.Ejercicio7Patrones;
public abstract class BarcoDecorador implements Barco {
    protected Barco barco;
    public BarcoDecorador(Barco barco) { this.barco = barco; }
}
