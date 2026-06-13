package main.dosw.semana_2.pokemon.Ejercicio6Patrones;
import java.util.ArrayList;
import java.util.List;

public class Caja implements ItemBodega {
    private String nombre;
    private List<ItemBodega> items = new ArrayList<>();

    public Caja(String nombre) { this.nombre = nombre; }

    public void agregar(ItemBodega item) { items.add(item); }
    public void eliminar(ItemBodega item) { items.remove(item); }

    @Override
    public double getPrecioTotal() {
        return items.stream().mapToDouble(ItemBodega::getPrecioTotal).sum();
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.printf("%s[Caja: %s] Total: $%.2f%n", indentacion, nombre, getPrecioTotal());
        items.forEach(item -> item.mostrar(indentacion + "  "));
    }
}
