package main.dosw.semana_2.pokemon.Ejercicio2Patrones;

public interface ConsolaFactory {
    Control crearControl();
    Juego crearJuego();
    InterfazGrafica crearInterfazGrafica();
}
