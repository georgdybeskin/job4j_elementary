package ru.job4j.console_war.model.weapon;

import ru.job4j.console_war.model.Weapon;

public class Fist extends Weapon {

    public Fist(double damage) {
        super("Fist", damage);
    }

    @Override
    public String printAction() {
        return "ударил кулаком " + "(" + this.name + "):";
    }
}
