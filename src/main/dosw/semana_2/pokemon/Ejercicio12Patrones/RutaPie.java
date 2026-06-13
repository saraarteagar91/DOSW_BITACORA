package main.dosw.semana_2.pokemon.Ejercicio12Patrones;
public class RutaPie implements EstrategiaRuta {
    @Override public void calcularRuta(String o, String d) {
        System.out.println("Ruta a pie de " + o + " a " + d + ": Caminar por el boulevard principal");
    }
}
