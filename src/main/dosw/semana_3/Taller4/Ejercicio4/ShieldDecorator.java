package main.dosw.semana_3.Taller4.Ejercicio4;

public class ShieldDecorator extends CharacterDecorator {
    public ShieldDecorator(Character c) {
        super(c);
    }
    public void attack() {
        System.out.println("Escudo - bloquea 50% daño");
        character.attack();
    }
    public String getDescription() {
        return character.getDescription() + " + Escudo";
    }
}
