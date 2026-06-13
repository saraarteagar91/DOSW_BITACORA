package main.dosw.semana_2.pokemon.Ejercicio7Patrones;
public class Main {
    public static void main(String[] args) {
        Barco barco = new BarcoBasico();
        System.out.println(barco.getDescripcion());
        System.out.println("Ataque: " + barco.getAtaque() + " | Defensa: " + barco.getDefensa());

        barco = new BlindajeReforzado(barco);
        barco = new RadarAvanzado(barco);
        barco = new Misiles(barco);
        barco = new SistemaAntitorpedos(barco);

        System.out.println("\n" + barco.getDescripcion());
        System.out.println("Ataque: " + barco.getAtaque() + " | Defensa: " + barco.getDefensa());
    }
}
