package main.dosw.semana_2.pokemon.Ejercicio8Patrones;
public class RevisionMotivoViaje extends ControlMigratorio {
    @Override
    public void verificar(Persona persona) {
        if (persona.getMotivoViaje() == null || persona.getMotivoViaje().isEmpty()) {
            System.out.println("RECHAZADO en Revisión de Motivo del Viaje: motivo no especificado");
            return;
        }
        System.out.println("✓ Motivo del viaje aceptado: " + persona.getMotivoViaje());
        if (siguiente != null) siguiente.verificar(persona);
    }
}
