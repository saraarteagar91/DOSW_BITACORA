public class SepiaDecorator extends ImageDecorator {
    public SepiaDecorator(Image i) { super(i); }
    public String render() { return wrapped.render() + " -> [Sepia]"; }
}
