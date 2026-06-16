package main.dosw.semana_3.Taller4.Ejercicio9;

public class PermissionValidator extends AuthValidator {
    protected boolean check(AuthResult r, Credentials c) {
        boolean ok = r.getRole().equals("USER") || r.getRole().equals("ADMIN");
        System.out.println("Permisos - Rol: " + r.getRole() + " - " + (ok?"OK":"DENEGADO"));
        return ok;
    }
}
