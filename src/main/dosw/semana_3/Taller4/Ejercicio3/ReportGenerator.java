package main.dosw.semana_3.Taller4.Ejercicio3;

public abstract class ReportGenerator {
    public final void generate() {
        fetchData();
        processData();
        applyFormat();
        exportFile();
        System.out.println("Reporte generado exitosamente.");
    }
    private void fetchData() {
        System.out.println("Obteniendo datos");
    }
    private void processData() {
        System.out.println("Procesando informacion");
    }
    protected abstract void applyFormat();
    protected abstract void exportFile();
}
