package main.dosw.semana_2.pokemon.Ejercicio6Patrones;
public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("Manzana", 1.50);
        Producto p2 = new Producto("Leche", 2.00);
        Producto p3 = new Producto("Chocolate", 3.50);
        Producto p4 = new Producto("Galletas", 1.80);

        Caja cajaChica = new Caja("Caja Chica");
        cajaChica.agregar(p3);
        cajaChica.agregar(p4);

        Caja cajaGrande = new Caja("Caja Grande");
        cajaGrande.agregar(p1);
        cajaGrande.agregar(p2);
        cajaGrande.agregar(cajaChica);

        System.out.println("=== Contenido de la bodega ===");
        cajaGrande.mostrar("");
        System.out.printf("%nPrecio total de la caja grande: $%.2f%n", cajaGrande.getPrecioTotal());
    }
}
