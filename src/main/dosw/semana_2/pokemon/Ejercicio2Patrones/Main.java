package main.dosw.semana_2.pokemon.Ejercicio2Patrones;

public class Main {
    static void iniciarConsola(ConsolaFactory factory) {
        Control control = factory.crearControl();
        Juego juego = factory.crearJuego();
        InterfazGrafica ui = factory.crearInterfazGrafica();
        control.conectar();
        juego.iniciar();
        ui.renderizar();
    }

    public static void main(String[] args) {
        System.out.println("=== PlayStation ===");
        iniciarConsola(new PlayStationFactory());
        System.out.println("=== Xbox ===");
        iniciarConsola(new XboxFactory());
    }
}
