package main.dosw.semana_2.pokemon.Ejercicio9Patrones;
public class ComandoSaltar implements Comando {
    private Personaje personaje;
    public ComandoSaltar(Personaje personaje) { this.personaje = personaje; }
    @Override
    public void ejecutar() { personaje.saltar(); }
}
