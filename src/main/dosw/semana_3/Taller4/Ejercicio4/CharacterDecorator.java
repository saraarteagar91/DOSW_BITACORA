package main.dosw.semana_3.Taller4.Ejercicio4;

public abstract class CharacterDecorator implements Character {
    protected Character character;
    public CharacterDecorator(Character c) {
        this.character = c;
    }
}
