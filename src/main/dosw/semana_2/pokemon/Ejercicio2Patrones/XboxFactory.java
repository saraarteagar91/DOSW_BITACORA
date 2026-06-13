package main.dosw.semana_2.pokemon.Ejercicio2Patrones;

public class XboxFactory implements ConsolaFactory {
    @Override
    public Control crearControl() { return new ControlXbox(); }
    @Override
    public Juego crearJuego() { return new JuegoXbox(); }
    @Override
    public InterfazGrafica crearInterfazGrafica() { return new InterfazGraficaXbox(); }
}
