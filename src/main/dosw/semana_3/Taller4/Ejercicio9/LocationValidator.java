package main.dosw.semana_3.Taller4.Ejercicio9;

public class LocationValidator extends AuthValidator {
    protected boolean check(AuthResult r, Credentials c) {
        boolean ok = c.location.equalsIgnoreCase("Colombia");
        System.out.println("Ubicacion - " + c.location + " - " + (ok?"OK":"DENEGADO"));
        return ok;
    }
}
