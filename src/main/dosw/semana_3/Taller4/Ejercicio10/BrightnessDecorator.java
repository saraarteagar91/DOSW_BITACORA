public class BrightnessDecorator extends ImageDecorator {
    private int level;
    public BrightnessDecorator(Image i, int l) { super(i); level=l; }
    public String render() { return wrapped.render() + " -> [Brillo+" + level + "]"; }
}
