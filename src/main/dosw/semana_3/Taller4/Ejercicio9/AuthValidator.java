package main.dosw.semana_3.Taller4.Ejercicio9;

public abstract class AuthValidator {
    private AuthValidator next;
    public AuthValidator setNext(AuthValidator n) {
        this.next=n;
        return n;
    }
    public boolean validate(AuthResult r, Credentials c) {
        if (!check(r, c)) return false;
        return next == null || next.validate(r, c);
    }
    protected abstract boolean check(AuthResult r, Credentials c);
}
