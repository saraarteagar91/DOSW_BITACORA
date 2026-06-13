package main.dosw.semana_2.pokemon.Ejercicio9Patrones;
public class ControlJuego {
    private Comando comando;

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void presionarBoton() {
        if (comando != null) comando.ejecutar();
    }
}
