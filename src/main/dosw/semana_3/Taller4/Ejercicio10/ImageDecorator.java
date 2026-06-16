public abstract class ImageDecorator implements Image {
    protected Image wrapped;
    public ImageDecorator(Image w) { wrapped=w; }
    public Image getWrapped() { return wrapped; }
}
