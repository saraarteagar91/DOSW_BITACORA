package main.dosw.semana_2.pokemon.Ejercicio8Patrones;
public class ControlAntecedentes extends ControlMigratorio {
    @Override
    public void verificar(Persona persona) {
        if (persona.tieneAntecedentes()) {
            System.out.println("RECHAZADO en Control de Antecedentes: registros criminales encontrados");
            return;
        }
        System.out.println("✓ Sin antecedentes criminales");
        if (siguiente != null) siguiente.verificar(persona);
    }
}
