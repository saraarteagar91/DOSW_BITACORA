public class BaseImage implements Image {
    private String filename;
    public BaseImage(String f) { filename=f; }
    public String render() { return "[Base:" + filename + "]"; }
}
