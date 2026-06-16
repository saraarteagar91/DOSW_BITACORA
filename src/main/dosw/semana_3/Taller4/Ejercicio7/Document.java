package main.dosw.semana_3.Taller4.Ejercicio7;

public class Document {
    private final String title;
    private DocumentState state;
    public Document(String title) {
        this.title=title;
        this.state=new DraftState();
    }
    public void setState(DocumentState s) {
        this.state=s;
    }
    public DocumentState getState() {
        return state;
    }
    public String getTitle() {
        return title;
    }
    public void approve() {
        state.approve(this);
    }
    public void reject() {
        state.reject(this);
    }
    public void printStatus() {
        System.out.println("Documento " + title  + state.getStateName());
    }
}
