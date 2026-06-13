package main.dosw.semana_2.pokemon.Ejercicio12Patrones;
public class RutaTransportePublico implements EstrategiaRuta {
    @Override public void calcularRuta(String o, String d) {
        System.out.println("Ruta en transporte publico de " + o + " a " + d + ": Metro linea 1, luego bus 45");
    }
}
