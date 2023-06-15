package ru.job4j.console_war.model.weapon;

import ru.job4j.console_war.model.Weapon;

public class Spear extends Weapon {

    public Spear(double damage) {
        super("Spear", damage);
    }

    @Override
    public String printAction() {
        return "ударил копьём " + "(" + this.name + "):";
    }
}
