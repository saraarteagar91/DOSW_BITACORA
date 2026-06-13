package main.dosw.semana_2.pokemon.Ejercicio8Patrones;
public abstract class ControlMigratorio {
    protected ControlMigratorio siguiente;

    public ControlMigratorio setSiguiente(ControlMigratorio siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public abstract void verificar(Persona persona);
}
