package main.dosw.semana_2.pokemon.Ejercicio8Patrones;
public class Main {
    public static void main(String[] args) {
        ControlMigratorio cadena = new RevisionPassaporteVisa();
        cadena.setSiguiente(new ControlAntecedentes())
              .setSiguiente(new RevisionMotivoViaje())
              .setSiguiente(new AprobacionFinal());

        System.out.println("=== Persona 1 (todos los requisitos) ===");
        cadena.verificar(new Persona("Carlos", true, true, false, "Turismo"));

        System.out.println("\n=== Persona 2 (sin visa) ===");
        cadena.verificar(new Persona("Ana", true, false, false, "Negocios"));

        System.out.println("\n=== Persona 3 (con antecedentes) ===");
        cadena.verificar(new Persona("Luis", true, true, true, "Estudio"));
    }
}
