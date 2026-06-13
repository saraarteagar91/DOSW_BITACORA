package main.dosw.semana_2.pokemon.Ejercicio3Patrones;
public interface MunecoBuilder {
    MunecoBuilder construirCabeza();
    MunecoBuilder construirCuerpo();
    MunecoBuilder construirBrazos();
    MunecoBuilder construirPiernas();
    MunecoBuilder agregarAccesorios();
    Muneco build();
}
