package main.dosw.semana_3.Taller4.Ejercicio10;

public class GrayscaleDecorator extends ImageDecorator {
    public GrayscaleDecorator(Image i) {
        super(i);
    }
    public String render() {
        return wrapped.render() + "    BlancoNegro";
    }
}
