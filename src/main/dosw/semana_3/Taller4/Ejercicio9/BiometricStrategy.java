package main.dosw.semana_3.Taller4.Ejercicio9;

public class BiometricStrategy implements AuthStrategy {
    public AuthResult authenticate(Credentials c) {
        boolean ok = c.token.startsWith("BIO_");
        System.out.println("Biometria - Leyendo huella" + (ok?"OK":"FALLO"));
        return new AuthResult(ok, c.userId, "ADMIN");
    }
}
