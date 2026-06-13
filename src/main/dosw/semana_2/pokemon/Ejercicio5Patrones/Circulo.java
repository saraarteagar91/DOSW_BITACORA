package main.dosw.semana_2.pokemon.Ejercicio5Patrones;
public class Circulo extends Forma {
    public Circulo(Color color) { super(color); }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Círculo de color " + color.aplicarColor());
    }
}
