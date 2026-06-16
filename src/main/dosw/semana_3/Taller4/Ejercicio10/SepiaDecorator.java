package main.dosw.semana_3.Taller4.Ejercicio10;

public class SepiaDecorator extends ImageDecorator {
    public SepiaDecorator(Image i) {
        super(i);
    }
    public String render() {
        return wrapped.render() + "    Sepia";
    }
}
