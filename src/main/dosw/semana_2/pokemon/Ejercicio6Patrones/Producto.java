package main.dosw.semana_2.pokemon.Ejercicio6Patrones;
public class Producto implements ItemBodega {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public double getPrecioTotal() { return precio; }

    @Override
    public void mostrar(String indentacion) {
        System.out.printf("%s- %s: $%.2f%n", indentacion, nombre, precio);
    }
}
