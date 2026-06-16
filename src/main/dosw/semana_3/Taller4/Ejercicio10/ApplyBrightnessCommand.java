public class ApplyBrightnessCommand implements ImageCommand {
    private ImageContext ctx; private Image before; private int level;
    public ApplyBrightnessCommand(ImageContext c, int l) { ctx=c; level=l; }
    public void execute() { before=ctx.getCurrent(); ctx.setCurrent(new BrightnessDecorator(before,level)); System.out.println("  [+] Filtro Brillo+" + level + " aplicado."); }
    public void undo()    { ctx.setCurrent(before); System.out.println("  [-] Filtro Brillo+" + level + " removido."); }
    public String getName() { return "Brillo+"+level; }
}
