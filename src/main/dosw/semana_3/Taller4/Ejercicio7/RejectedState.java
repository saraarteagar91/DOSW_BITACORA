package main.dosw.semana_3.Taller4.Ejercicio7;

public class RejectedState implements DocumentState {
    public void approve(Document doc) {
        System.out.println("Reingresado a revision.");
        doc.setState(new InReviewState());
    }
    public void reject(Document doc) {
        System.out.println("Ya fue rechazado el documento.");
    }
    public String getStateName() {
        return "RECHAZADO";
    }
}
