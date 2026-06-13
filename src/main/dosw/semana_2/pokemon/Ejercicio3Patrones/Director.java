package main.dosw.semana_2.pokemon.Ejercicio3Patrones;
public class Director {
    private MunecoBuilder builder;

    public Director(MunecoBuilder builder) {
        this.builder = builder;
    }

    public Muneco construirMunecoCompleto() {
        return builder.construirCabeza()
                      .construirCuerpo()
                      .construirBrazos()
                      .construirPiernas()
                      .agregarAccesorios()
                      .build();
    }
}
