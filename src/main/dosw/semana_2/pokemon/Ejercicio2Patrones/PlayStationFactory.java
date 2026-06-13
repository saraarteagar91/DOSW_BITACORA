package main.dosw.semana_2.pokemon.Ejercicio2Patrones;

public class PlayStationFactory implements ConsolaFactory {
    @Override
    public Control crearControl() { return new ControlPlayStation(); }
    @Override
    public Juego crearJuego() { return new JuegoPlayStation(); }
    @Override
    public InterfazGrafica crearInterfazGrafica() { return new InterfazGraficaPlayStation(); }
}
