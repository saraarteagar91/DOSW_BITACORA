package main.dosw.semana_2.pokemon.Ejercicio5Patrones;
public abstract class Forma {
    protected Color color;

    public Forma(Color color) {
        this.color = color;
    }

    public abstract void dibujar();
}
