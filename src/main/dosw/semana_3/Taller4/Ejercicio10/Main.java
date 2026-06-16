import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Aplicacion de Edicion de Imagenes ===");

        System.out.print("Nombre del archivo de imagen: ");
        String archivo = sc.nextLine().trim();

        ImageEditor editor = new ImageEditor(archivo);
        System.out.println("Imagen cargada: " + editor.ctx.getCurrent().render());

        System.out.println("\nComandos: aplicar, deshacer, rehacer, salir");
        System.out.println("Filtros disponibles: blanconegro, sepia, brillo, contraste");

        boolean continuar = true;
        while (continuar) {
            System.out.print("\nComando: ");
            String cmd = sc.nextLine().trim().toLowerCase();
            switch (cmd) {
                case "aplicar":
                    System.out.print("  Filtro a aplicar: ");
                    String filtro = sc.nextLine().trim().toLowerCase();
                    switch (filtro) {
                        case "blanconegro": editor.apply(new ApplyGrayscaleCommand(editor.ctx)); break;
                        case "sepia":       editor.apply(new ApplySepiaCommand(editor.ctx));     break;
                        case "brillo":
                            System.out.print("  Nivel de brillo (1-100): ");
                            int nivel = Integer.parseInt(sc.nextLine().trim());
                            editor.apply(new ApplyBrightnessCommand(editor.ctx, nivel)); break;
                        case "contraste":   editor.apply(new ApplyContrastCommand(editor.ctx));  break;
                        default: System.out.println("  Filtro desconocido.");
                    }
                    break;
                case "deshacer": editor.undo(); break;
                case "rehacer":  editor.redo(); break;
                case "salir":    continuar = false; break;
                default: System.out.println("Comando no reconocido.");
            }
        }
        sc.close();
    }
}
