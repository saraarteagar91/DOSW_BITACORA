package main.dosw.semana_3.Taller4.Ejercicio6;

public class NotificationService implements PreferenceObserver {
    public void onPreferenceChanged(String u, RecommendationAlgorithm a) {
        System.out.println(a.recommend(u).getFirst() + "\"");
    }
}
