package main.dosw.semana_3.Taller4.Ejercicio10;

public class BrightnessDecorator extends ImageDecorator {
    private final int level;
    public BrightnessDecorator(Image i, int l) {
        super(i);
        level=l;
    }
    public String render() {
        return wrapped.render() + "Brillo " + level;
    }
}
