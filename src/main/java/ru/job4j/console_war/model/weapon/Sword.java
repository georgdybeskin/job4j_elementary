package ru.job4j.console_war.model.weapon;

import ru.job4j.console_war.model.Weapon;

public class Sword extends Weapon {

    public Sword(double damage) {
        super("Sword", damage);
    }

    @Override
    public String printAction() {
        return "ударил мечом " + "(" + this.name + "):";
    }
}
