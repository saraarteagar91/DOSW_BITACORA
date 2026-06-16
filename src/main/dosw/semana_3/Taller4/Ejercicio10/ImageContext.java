package main.dosw.semana_3.Taller4.Ejercicio10;

public class ImageContext {
    private Image current;
    public ImageContext(Image i) {
        current=i;
    }
    public Image getCurrent() {
        return current;
    }
    public void setCurrent(Image i) {
        current=i;
    }
}
