package main.dosw.semana_3.Taller4.Ejercicio7;

public class DraftState implements DocumentState {
    public void approve(Document doc) {
        System.out.println("Borrador enviado a revision.");
        doc.setState(new InReviewState());
    }
    public void reject(Document doc) {
        System.out.println("No se puede rechazar un borrador.");
    }
    public String getStateName() {
        return "BORRADOR";
    }
}
