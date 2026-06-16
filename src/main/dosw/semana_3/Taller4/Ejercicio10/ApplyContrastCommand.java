public class ApplyContrastCommand implements ImageCommand {
    private ImageContext ctx; private Image before;
    public ApplyContrastCommand(ImageContext c) { ctx=c; }
    public void execute() { before=ctx.getCurrent(); ctx.setCurrent(new ContrastDecorator(before)); System.out.println("  [+] Filtro Contraste aplicado."); }
    public void undo()    { ctx.setCurrent(before); System.out.println("  [-] Filtro Contraste removido."); }
    public String getName() { return "Contraste"; }
}
