package main.dosw.semana_2.pokemon.Ejercicio11Patrones;
public class RutaCarretera implements EstrategiaRuta {
    @Override public void calcularRuta(String o, String d) {
        System.out.println("Ruta por carretera de " + o + " a " + d + ": Tomar autopista principal");
    }
}
