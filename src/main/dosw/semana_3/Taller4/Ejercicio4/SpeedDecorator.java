package main.dosw.semana_3.Taller4.Ejercicio4;

public class SpeedDecorator extends CharacterDecorator {
    public SpeedDecorator(Character c) {
        super(c);
    }
    public void attack() {
        System.out.println("Mayor Velocidad - doble ataque");
        character.attack();
        character.attack();
    }
    public String getDescription() {
        return character.getDescription() + " + Velocidad";
    }
}
