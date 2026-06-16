package main.dosw.semana_3.Taller4.Ejercicio7;

public class InReviewState implements DocumentState {
    public void approve(Document doc) {
        System.out.println("Documento aprobado.");
        doc.setState(new ApprovedState());
    }
    public void reject(Document doc) {
        System.out.println("Documento rechazado.");
        doc.setState(new RejectedState());
    }
    public String getStateName() {
        return "ENREVISION";
    }
}
