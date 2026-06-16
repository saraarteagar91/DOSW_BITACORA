package main.dosw.semana_3.Taller4.Ejercicio9;

public class AuthService {
    private AuthValidator chain;
    public AuthService() {
        AuthValidator c=new CredentialValidator(), p=new PermissionValidator(), l=new LocationValidator(), t=new TimeValidator();
        c.setNext(p).setNext(l)
                    .setNext(t);
        this.chain=c;
    }
    public boolean login(AuthStrategy strategy, Credentials creds) {
        System.out.println("Autenticando usuario: " + creds.userId);
        AuthResult result = strategy.authenticate(creds);
        boolean access = chain.validate(result, creds);
        System.out.println("Resultado: " + (access ? "ACCESO CONCEDIDO" : "ACCESO DENEGADO") + "\n");
        return access;
    }
}
