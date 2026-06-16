package main.dosw.semana_3.Taller4.Ejercicio7;

public class ApprovedState implements DocumentState {
    public void approve(Document doc) {
        System.out.println("Ya está aprobado.");
    }
    public void reject(Document doc) {
        System.out.println("No se puede rechazar un documento aprobado.");
    }
    public String getStateName() {
        return "APROBADO";
    }
}
