package main.dosw.semana_3.Taller4.Ejercicio10;

public class ContrastDecorator extends ImageDecorator {
    public ContrastDecorator(Image i) {
        super(i);
    }
    public String render() {
        return wrapped.render() + "   [Contraste";
    }
}
