package main.dosw.semana_3.Taller4.Ejercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el saldo inicial de la cuenta: $");
        double saldo = Double.parseDouble(sc.nextLine()
                                             .trim());
        BankFacade bank = new BankFacade(saldo);
        System.out.println();
        bank.consultarSaldo();
        boolean con = true;
        while (con) {
            System.out.print("\nIngresa el monto a pagar: $");
            double monto = Double.parseDouble(sc.nextLine()
                                                 .trim());
            if (monto == 0) {
                con = false;
            } else {
                bank.procesarPago(monto);
                bank.consultarSaldo();
            }
        }
        sc.close();
    }
}
