package main.dosw.semana_3.Taller4.Ejercicio10;

public class BaseImage implements Image {
    private final String filename;
    public BaseImage(String f) {
        filename=f;
    }
    public String render() {
        return "Imagen base:" + filename;
    }
}
