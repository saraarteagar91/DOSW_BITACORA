package main.dosw.semana_3.Taller4.Ejercicio10;

public class ApplyGrayscaleCommand implements ImageCommand {
    private final ImageContext ctx;
    private Image before;
    public ApplyGrayscaleCommand(ImageContext c) {
        ctx=c;
    }
    public void execute() {
        before=ctx.getCurrent();
        ctx.setCurrent(new GrayscaleDecorator(before));
        System.out.println("Filtro BlancoNegro aplicado.");
    }
    public void undo() { ctx.setCurrent(before);
        System.out.println("Filtro BlancoNegro removido.");
    }
    public String getName() {
        return "BlancoNegro";
    }
}
