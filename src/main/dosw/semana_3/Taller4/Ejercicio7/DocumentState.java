package main.dosw.semana_3.Taller4.Ejercicio7;

public interface DocumentState {
    void approve(Document doc);
    void reject(Document doc);
    String getStateName();
}
