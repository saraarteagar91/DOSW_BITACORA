public class ContrastDecorator extends ImageDecorator {
    public ContrastDecorator(Image i) { super(i); }
    public String render() { return wrapped.render() + " -> [Contraste]"; }
}
