package main.dosw.semana_3.Taller4.Ejercicio3;

public class ReportFactory {
    public static ReportGenerator create(String type) {
        return switch (type.toUpperCase()) {
            case "PDF" -> new PdfReport();
            case "EXCEL" -> new ExcelReport();
            case "CSV" -> new CsvReport();
            default -> throw new IllegalArgumentException("Formato no soportado: " + type);
        };
    }
}
