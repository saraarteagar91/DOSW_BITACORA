package main.dosw.semana_3.Taller4.Ejercicio9;

public class PasswordStrategy implements AuthStrategy {
    public AuthResult authenticate(Credentials c) {
        boolean ok = c.token.startsWith("PWD_");
        System.out.println("Password - Verificando clave" + (ok?"OK":"FALLO"));
        return new AuthResult(ok, c.userId, "USER");
    }
}
