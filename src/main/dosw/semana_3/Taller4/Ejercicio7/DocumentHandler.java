package main.dosw.semana_3.Taller4.Ejercicio7;

public abstract class DocumentHandler {
    private DocumentHandler next;
    public DocumentHandler setNext(DocumentHandler n) {
        this.next=n;
        return n;
    }
    public void handle(Document doc) {
        if (canHandle(doc)) process(doc);
        else if (next!=null) next.handle(doc);
    }
    protected abstract boolean canHandle(Document doc);
    protected abstract void process(Document doc);
}
