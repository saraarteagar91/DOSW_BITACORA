package main.dosw.semana_2.pokemon.Ejercicio12Patrones;
public class AppNavegacion {
    private EstrategiaRuta estrategia;
    public AppNavegacion(EstrategiaRuta estrategia) { this.estrategia = estrategia; }
    public void setEstrategia(EstrategiaRuta estrategia) { this.estrategia = estrategia; }
    public void navegarA(String origen, String destino) { estrategia.calcularRuta(origen, destino); }
}
