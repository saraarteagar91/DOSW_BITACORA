package main.dosw.semana_3.Taller4.Ejercicio4;

public class BaseCharacter implements Character {
    private final String name;
    private final String armor;
    private final String weapon;
    private final String skill;
    public BaseCharacter(String name, String armor, String weapon, String skill) {
        this.name=name;
        this.armor=armor;
        this.weapon=weapon;
        this.skill=skill;
    }
    public void attack() {
        System.out.println(name + "Ataca con " + weapon + " Habilidad: " + skill);
    }
    public String getDescription() {
        return name + " Armadura: " + armor + " Arma: " + weapon + " Habilidad: " + skill;
    }
}
