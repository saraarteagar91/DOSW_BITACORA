public class GrayscaleDecorator extends ImageDecorator {
    public GrayscaleDecorator(Image i) { super(i); }
    public String render() { return wrapped.render() + " -> [BlancoNegro]"; }
}
