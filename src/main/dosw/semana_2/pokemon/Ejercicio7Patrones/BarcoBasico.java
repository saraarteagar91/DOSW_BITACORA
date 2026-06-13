package main.dosw.semana_2.pokemon.Ejercicio7Patrones;
public class BarcoBasico implements Barco {
    @Override
    public String getDescripcion() { return "Barco básico"; }
    @Override
    public int getAtaque() { return 10; }
    @Override
    public int getDefensa() { return 10; }
}
