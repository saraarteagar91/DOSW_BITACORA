package main.dosw.semana_3.Taller4.Ejercicio6;

import java.util.*; public class GenreStrategy implements RecommendationAlgorithm {
    public List<String> recommend(String u) {
        return Arrays.asList("Terror","Comedia","Acción");
    }
}
