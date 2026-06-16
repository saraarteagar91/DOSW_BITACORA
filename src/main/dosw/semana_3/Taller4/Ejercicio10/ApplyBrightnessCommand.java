package main.dosw.semana_3.Taller4.Ejercicio10;

public class ApplyBrightnessCommand implements ImageCommand {
    private final ImageContext ctx;
    private Image before;
    private final int level;
    public ApplyBrightnessCommand(ImageContext c, int l) {
        ctx=c; level=l;
    }
    public void execute() {
        before=ctx.getCurrent();
        ctx.setCurrent(new BrightnessDecorator(before,level));
        System.out.println("Filtro Brillo" + level + " aplicado.");
    }
    public void undo() {
        ctx.setCurrent(before);
        System.out.println("Filtro Brillo" + level + " removido.");
    }
    public String getName() {
        return "Brillo"+level;
    }
}
