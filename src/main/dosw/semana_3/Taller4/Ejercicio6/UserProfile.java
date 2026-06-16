package main.dosw.semana_3.Taller4.Ejercicio6;
import java.util.*;

public class UserProfile {
    private final String userId;
    private RecommendationAlgorithm algorithm;
    private final List<PreferenceObserver> observers = new ArrayList<>();
    public UserProfile(String u) {
        this.userId=u;
        this.algorithm=new PopularityStrategy();
    }
    public void addObserver(PreferenceObserver o) {
        observers.add(o);
    }
    public void changePreference(RecommendationAlgorithm a) {
        this.algorithm = a;
        System.out.println("\nUsuario " + userId + " cambio preferencia:");
        for (PreferenceObserver o : observers) o.onPreferenceChanged(userId, algorithm);
    }
}
