package main.dosw.semana_2.pokemon.Ejercicio4Patrones;
public class VehiculoCombustion implements SistemaAbastecimiento {
    @Override
    public void abastecer(double litros) {
        System.out.printf("Abasteciendo vehículo a combustión con %.2f litros de gasolina%n", litros);
    }
}
