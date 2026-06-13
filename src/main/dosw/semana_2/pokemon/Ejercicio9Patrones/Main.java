package main.dosw.semana_2.pokemon.Ejercicio9Patrones;
public class Main {
    public static void main(String[] args) {
        Personaje heroe = new Personaje("Héroe");
        ControlJuego control = new ControlJuego();

        control.setComando(new ComandoCaminar(heroe));
        control.presionarBoton();

        control.setComando(new ComandoSaltar(heroe));
        control.presionarBoton();

        control.setComando(new ComandoAtacar(heroe));
        control.presionarBoton();

        control.setComando(new ComandoDefenderse(heroe));
        control.presionarBoton();
    }
}
