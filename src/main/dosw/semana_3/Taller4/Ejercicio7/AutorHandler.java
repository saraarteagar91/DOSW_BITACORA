package main.dosw.semana_3.Taller4.Ejercicio7;

public class AutorHandler extends DocumentHandler {
    protected boolean canHandle(Document doc) {
        return doc.getState()
                  .getStateName()
                  .equals("BORRADOR");
    }
    protected void process(Document doc) {
        System.out.println("Revision del autor."); doc.approve();
    }
}
