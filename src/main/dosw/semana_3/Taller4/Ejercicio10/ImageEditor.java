import java.util.ArrayDeque; import java.util.Deque;
public class ImageEditor {
    ImageContext ctx; private Deque<ImageCommand> history=new ArrayDeque<>(), redoStack=new ArrayDeque<>();
    public ImageEditor(String f) { ctx=new ImageContext(new BaseImage(f)); }
    public void apply(ImageCommand c) { c.execute(); history.push(c); redoStack.clear(); print(); }
    public void undo() { if(history.isEmpty()){System.out.println("  Nada que deshacer.");return;} ImageCommand c=history.pop(); c.undo(); redoStack.push(c); print(); }
    public void redo() { if(redoStack.isEmpty()){System.out.println("  Nada que rehacer.");return;} ImageCommand c=redoStack.pop(); c.execute(); history.push(c); print(); }
    private void print() { System.out.println("  Vista: " + ctx.getCurrent().render() + "\n"); }
}
