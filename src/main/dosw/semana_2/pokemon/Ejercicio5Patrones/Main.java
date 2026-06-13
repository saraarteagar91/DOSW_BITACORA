package main.dosw.semana_2.pokemon.Ejercicio5Patrones;
public class Main {
    public static void main(String[] args) {
        Forma circuloRojo = new Circulo(new Rojo());
        circuloRojo.dibujar();

        Forma circuloAzul = new Circulo(new Azul());
        circuloAzul.dibujar();

        Forma cuadradoRojo = new Cuadrado(new Rojo());
        cuadradoRojo.dibujar();

        Forma cuadradoAzul = new Cuadrado(new Azul());
        cuadradoAzul.dibujar();
    }
}
