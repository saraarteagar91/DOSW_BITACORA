package main.dosw.semana_2.pokemon.Ejercicio5Patrones;
public class Cuadrado extends Forma {
    public Cuadrado(Color color) { super(color); }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Cuadrado de color " + color.aplicarColor());
    }
}
