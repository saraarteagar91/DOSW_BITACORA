package main.dosw.semana_3.Taller4.Ejercicio9;

public class CredentialValidator extends AuthValidator {
    protected boolean check(AuthResult r, Credentials c) {
        if (!r.isSuccess()) {
            System.out.println("Credencial - DENEGADO.");
            return false;
        }
        System.out.println("Credencial - OK");
        return true;
    }
}
