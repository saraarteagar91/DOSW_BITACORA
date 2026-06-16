package main.dosw.semana_3.Taller4.Ejercicio9;

public class AuthResult {
    private final boolean success;
    private String userId;
    private final String role;
    public AuthResult(boolean s, String u, String r) {
        success=s;
        userId=u;
        role=r;
    }
    public boolean isSuccess() {
        return success;
    }
    public String getRole() {
        return role;
    }
}
