package main.dosw.semana_2.pokemon.Ejercicio9Patrones;
public class ComandoAtacar implements Comando {
    private Personaje personaje;
    public ComandoAtacar(Personaje personaje) { this.personaje = personaje; }
    @Override
    public void ejecutar() { personaje.atacar(); }
}
