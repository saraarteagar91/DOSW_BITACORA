package main.dosw.semana_2.pokemon.Ejercicio9Patrones;
public class ComandoCaminar implements Comando {
    private Personaje personaje;
    public ComandoCaminar(Personaje personaje) { this.personaje = personaje; }
    @Override
    public void ejecutar() { personaje.caminar(); }
}
