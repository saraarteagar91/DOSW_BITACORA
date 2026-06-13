package main.dosw.semana_2.pokemon.Ejercicio3Patrones;
public class MunecoClasicaBuilder implements MunecoBuilder {
    private Muneco muneco = new Muneco();

    @Override
    public MunecoBuilder construirCabeza() { muneco.setCabeza("Cabeza con cabello largo"); return this; }
    @Override
    public MunecoBuilder construirCuerpo() { muneco.setCuerpo("Cuerpo con vestido"); return this; }
    @Override
    public MunecoBuilder construirBrazos() { muneco.setBrazos("Brazos delgados articulados"); return this; }
    @Override
    public MunecoBuilder construirPiernas() { muneco.setPiernas("Piernas delgadas con zapatos"); return this; }
    @Override
    public MunecoBuilder agregarAccesorios() { muneco.setAccesorios(null); return this; }
    @Override
    public Muneco build() { return muneco; }
}
