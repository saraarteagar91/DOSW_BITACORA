package main.dosw.semana_2.pokemon.Ejercicio8Patrones;
public class AprobacionFinal extends ControlMigratorio {
    @Override
    public void verificar(Persona persona) {
        System.out.println("✓ APROBADO: " + persona.getNombre() + " puede ingresar a Estados Unidos");
    }
}
