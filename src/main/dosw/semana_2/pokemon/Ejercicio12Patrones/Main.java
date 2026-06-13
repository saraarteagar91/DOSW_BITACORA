package main.dosw.semana_2.pokemon.Ejercicio12Patrones;
public class Main {
    public static void main(String[] args) {
        AppNavegacion app = new AppNavegacion(new RutaCarretera());
        app.navegarA("Bogota", "Medellin");

        app.setEstrategia(new RutaTransportePublico());
        app.navegarA("Bogota", "Medellin");

        app.setEstrategia(new RutaBicicleta());
        app.navegarA("Casa", "Trabajo");

        app.setEstrategia(new RutaPie());
        app.navegarA("Hotel", "Museo");
    }
}
