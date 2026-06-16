package main.dosw.semana_3.Taller4.Ejercicio7;

public class JuridicoHandler extends DocumentHandler {
    protected boolean canHandle(Document doc) {
        return doc.getState()
                  .getStateName()
                  .equals("ENREVISION");
    }
    protected void process(Document doc) {
        System.out.println("Revision juridica.");
        doc.approve();
    }
}
