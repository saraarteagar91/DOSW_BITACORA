package main.dosw.semana_3.Taller4.Ejercicio9;

public class TimeValidator extends AuthValidator {
    protected boolean check(AuthResult r, Credentials c) {
        boolean ok = c.hour >= 6 && c.hour <= 22;
        System.out.println("Horario - Hora " + c.hour + ":00 - " + (ok?"OK":"DENEGADO"));
        return ok;
    }
}
