package main.dosw.semana_2.pokemon.Ejercicio3Patrones;
public class Main {
    public static void main(String[] args) {
        Director director1 = new Director(new MunecoAccionBuilder());
        Muneco munecoAccion = director1.construirMunecoCompleto();
        System.out.println("Muñeco de acción: " + munecoAccion);

        Director director2 = new Director(new MunecoClasicaBuilder());
        Muneco munecoClasica = director2.construirMunecoCompleto();
        System.out.println("Muñeca clásica: " + munecoClasica);
    }
}
