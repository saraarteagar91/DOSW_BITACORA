package main.dosw.semana_3.Taller4.Ejercicio4;

public class CharacterBuilder {
    private final String name;
    private String armor="Cuero";
    private String weapon="Espada basica";
    private String skill="Ninguna";
    public CharacterBuilder(String name) {
        this.name = name;
    }
    public CharacterBuilder setArmor(String a) {
        armor=a;
        return this;
    }
    public CharacterBuilder setWeapon(String w) {
        weapon=w;
        return this;
    }
    public CharacterBuilder setSkill(String s) {
        skill=s;
        return this;
    }
    public Character build() {
        return new BaseCharacter(name, armor, weapon, skill);
    }
}
