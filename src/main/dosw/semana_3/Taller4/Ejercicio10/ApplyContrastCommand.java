package main.dosw.semana_3.Taller4.Ejercicio10;

public class ApplyContrastCommand implements ImageCommand {
    private final ImageContext ctx;
    private Image before;
    public ApplyContrastCommand(ImageContext c) {
        ctx=c;
    }
    public void execute() {
        before=ctx.getCurrent();
        ctx.setCurrent(new ContrastDecorator(before));
        System.out.println("Filtro Contraste aplicado.");
    }
    public void undo() {
        ctx.setCurrent(before);
        System.out.println("Filtro Contraste removido.");
    }
    public String getName() {
        return "Contraste";
    }
}
