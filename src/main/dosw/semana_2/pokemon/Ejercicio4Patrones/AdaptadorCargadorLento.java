package main.dosw.semana_2.pokemon.Ejercicio4Patrones;
public class AdaptadorCargadorLento implements SistemaAbastecimiento {
    private CargadorLento cargador;

    public AdaptadorCargadorLento(CargadorLento cargador) {
        this.cargador = cargador;
    }

    @Override
    public void abastecer(double litros) {
        double kwh = litros * 7.0;
        cargador.cargarKWh(kwh);
    }
}
