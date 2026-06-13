package main.dosw.semana_2.pokemon.Ejercicio4Patrones;
public class AdaptadorCargadorRapido implements SistemaAbastecimiento {
    private CargadorRapido cargador;

    public AdaptadorCargadorRapido(CargadorRapido cargador) {
        this.cargador = cargador;
    }

    @Override
    public void abastecer(double litros) {
        double kwh = litros * 8.0;
        cargador.cargarKWh(kwh);
    }
}
