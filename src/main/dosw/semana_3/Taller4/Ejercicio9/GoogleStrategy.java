package main.dosw.semana_3.Taller4.Ejercicio9;

public class GoogleStrategy implements AuthStrategy {
    public AuthResult authenticate(Credentials c) {
        boolean ok = c.token.startsWith("GOOGLE_");
        System.out.println("Google - Verificando" + (ok?"OK":"FALLO"));
        return new AuthResult(ok, c.userId, "USER");
    }
}
