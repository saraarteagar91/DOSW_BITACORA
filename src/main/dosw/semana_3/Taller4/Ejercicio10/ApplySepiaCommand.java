package main.dosw.semana_3.Taller4.Ejercicio10;

public class ApplySepiaCommand implements ImageCommand {
    private ImageContext ctx;
    private Image before;
    public ApplySepiaCommand(ImageContext c) {
        ctx=c;
    }
    public void execute() {
        before=ctx.getCurrent();
        ctx.setCurrent(new SepiaDecorator(before));
        System.out.println("Filtro Sepia aplicado.");
    }
    public void undo() {
        ctx.setCurrent(before);
        System.out.println("Filtro Sepia removido.");
    }
    public String getName() {
        return "Sepia";
    }
}
