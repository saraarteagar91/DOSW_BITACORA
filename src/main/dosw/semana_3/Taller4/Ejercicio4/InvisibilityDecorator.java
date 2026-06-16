package main.dosw.semana_3.Taller4.Ejercicio4;

public class InvisibilityDecorator extends CharacterDecorator {
    public InvisibilityDecorator(Character c) {
        super(c);
    }
    public void attack() {
        System.out.println("Invisibilidad - critico x3");
        character.attack();
    }
    public String getDescription() {
        return character.getDescription() + " + Invisibilidad";
    }
}
