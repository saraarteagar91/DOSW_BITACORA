package main.dosw.semana_2.pokemon.Ejercicio3Patrones;
public class MunecoAccionBuilder implements MunecoBuilder {
    private Muneco muneco = new Muneco();

    @Override
    public MunecoBuilder construirCabeza() { muneco.setCabeza("Cabeza musculosa"); return this; }
    @Override
    public MunecoBuilder construirCuerpo() { muneco.setCuerpo("Cuerpo atlético con armadura"); return this; }
    @Override
    public MunecoBuilder construirBrazos() { muneco.setBrazos("Brazos articulados con guantes"); return this; }
    @Override
    public MunecoBuilder construirPiernas() { muneco.setPiernas("Piernas articuladas con botas"); return this; }
    @Override
    public MunecoBuilder agregarAccesorios() { muneco.setAccesorios("Espada y escudo"); return this; }
    @Override
    public Muneco build() { return muneco; }
}
