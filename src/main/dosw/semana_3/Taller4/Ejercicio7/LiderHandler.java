package main.dosw.semana_3.Taller4.Ejercicio7;

public class LiderHandler extends DocumentHandler {
    private final boolean aprueba;
    public LiderHandler(boolean aprueba) {
        this.aprueba=aprueba;
    }
    protected boolean canHandle(Document doc) {
        return doc.getState()
                  .getStateName()
                  .equals("ENREVISION");
    }
    protected void process(Document doc) {
        if (aprueba) {
            System.out.println("Lider aprueba.");
            doc.approve();
        } else {
            System.out.println("Lider rechaza.");
            doc.reject();
        }
    }
}
