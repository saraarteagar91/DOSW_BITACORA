package main.dosw.semana_3.Taller4.Ejercicio10;

public interface ImageCommand {
    void execute();
    void undo();
    String getName();
}
