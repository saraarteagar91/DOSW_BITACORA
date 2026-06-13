package main.dosw.semana_2.pokemon.Ejercicio11Patrones;
public class RutaBicicleta implements EstrategiaRuta {
    @Override public void calcularRuta(String o, String d) {
        System.out.println("Ruta en bicicleta de " + o + " a " + d + ": Ciclovia del parque central");
    }
}
