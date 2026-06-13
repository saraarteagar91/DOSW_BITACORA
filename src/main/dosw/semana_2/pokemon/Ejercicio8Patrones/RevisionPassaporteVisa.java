package main.dosw.semana_2.pokemon.Ejercicio8Patrones;
public class RevisionPassaporteVisa extends ControlMigratorio {
    @Override
    public void verificar(Persona persona) {
        if (!persona.tienePassaporte() || !persona.tieneVisa()) {
            System.out.println("RECHAZADO en Revisión de Pasaporte/Visa: documentos inválidos");
            return;
        }
        System.out.println("✓ Pasaporte y visa válidos");
        if (siguiente != null) siguiente.verificar(persona);
    }
}
