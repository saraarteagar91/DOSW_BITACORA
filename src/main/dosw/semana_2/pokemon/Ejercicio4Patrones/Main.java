package main.dosw.semana_2.pokemon.Ejercicio4Patrones;
public class Main {
    public static void main(String[] args) {
        SistemaAbastecimiento combustion = new VehiculoCombustion();
        combustion.abastecer(40.0);

        SistemaAbastecimiento rapidoAdapter = new AdaptadorCargadorRapido(new CargadorRapido());
        rapidoAdapter.abastecer(40.0);

        SistemaAbastecimiento lentoAdapter = new AdaptadorCargadorLento(new CargadorLento());
        lentoAdapter.abastecer(40.0);
    }
}
