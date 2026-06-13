package main.dosw.semana_2.pokemon.Ejercicio8Patrones;
public class Persona {
    private String nombre;
    private boolean tienePassaporte;
    private boolean tieneVisa;
    private boolean tieneAntecedentes;
    private String motivoViaje;

    public Persona(String nombre, boolean tienePassaporte, boolean tieneVisa,
                   boolean tieneAntecedentes, String motivoViaje) {
        this.nombre = nombre;
        this.tienePassaporte = tienePassaporte;
        this.tieneVisa = tieneVisa;
        this.tieneAntecedentes = tieneAntecedentes;
        this.motivoViaje = motivoViaje;
    }

    public String getNombre() { return nombre; }
    public boolean tienePassaporte() { return tienePassaporte; }
    public boolean tieneVisa() { return tieneVisa; }
    public boolean tieneAntecedentes() { return tieneAntecedentes; }
    public String getMotivoViaje() { return motivoViaje; }
}
