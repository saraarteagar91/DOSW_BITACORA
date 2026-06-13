package main.dosw.semana_2.pokemon.Ejercicio11Patrones;
public class Main {
    public static void main(String[] args) {
        AppNavegacion app = new AppNavegacion(new RutaCarretera());
        app.navegarA("Casa", "Oficina");

        app.setEstrategia(new RutaTransportePublico());
        app.navegarA("Casa", "Oficina");

        app.setEstrategia(new RutaBicicleta());
        app.navegarA("Casa", "Parque");
    }
}
