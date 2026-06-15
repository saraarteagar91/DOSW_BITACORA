package main.dosw.semana_3.Taller4.Ejercicio1;

public interface PaymentFactory {
    PaymentStrategy create(String type);
}
